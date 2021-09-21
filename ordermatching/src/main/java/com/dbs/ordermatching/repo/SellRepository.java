package com.dbs.ordermatching.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbs.ordermatching.model.Sell;
@Repository
public interface SellRepository extends JpaRepository<Sell, Integer> {

	@Query(value = "CALL INTO_SELL(:sid,:cid,:iid,:p,:q);", nativeQuery = true)
	public void insertSell(@Param("sid") int sid,
			@Param("cid") String cid,
			@Param("iid") String iid,
			@Param("p") Double p,
			@Param("q") Integer q);

	@Query(value="SELECT * from buy b where b.instrumentid= :inst and b.price= :p and b.flag=1 and b.remainingqty>0 order by b.buydate; ",nativeQuery = true)
	public List<Integer> sOrderMatching(@Param("inst") String inst,
			@Param("p") Double p);
}
