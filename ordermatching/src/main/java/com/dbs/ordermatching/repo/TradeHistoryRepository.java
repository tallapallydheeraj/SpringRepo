package com.dbs.ordermatching.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbs.ordermatching.model.TradeHistory;
@Repository
public interface TradeHistoryRepository extends JpaRepository<TradeHistory, Integer> {

	@Query(value="select * from trade_history where buyerid in(select clientid from clients where custodianid= :csid) "
			+ "UNION select * from trade_history where sellerid in(select clientid from clients where custodianid= :csid) ORDER BY tradedate DESC ",nativeQuery = true)
	public List<TradeHistory> getTradeHistoryByCustodian(@Param("csid") String csid);
			
}

