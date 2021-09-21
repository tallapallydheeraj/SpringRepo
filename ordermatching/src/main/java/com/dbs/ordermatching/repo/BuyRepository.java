package com.dbs.ordermatching.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbs.ordermatching.model.Buy;
import com.dbs.ordermatching.model.Sell;
@Repository
public interface BuyRepository extends JpaRepository<Buy, Integer> {
	
	@Query(value = "CALL INTO_BUY(:bid,:cid,:iid,:p,:q);", nativeQuery = true)
	public void insertBuy(@Param("bid") int bid,
			@Param("cid") String cid,
			@Param("iid") String iid,
			@Param("p") Double p,
			@Param("q") Integer q);

	@Query(value="SELECT * from sell s where s.instrumentid= :inst and s.price= :p and s.flag=1 and s.remainingqty>0 order by s.selldate; ",nativeQuery = true)
	public List<Integer> bOrderMatching(@Param("inst") String inst,
			@Param("p") Double p);
}
