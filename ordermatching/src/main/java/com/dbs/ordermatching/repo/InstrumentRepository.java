package com.dbs.ordermatching.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbs.ordermatching.model.Instrument;
@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, String>{
	@Query(value="SELECT i.instrumentname,j.quantity from instrument i inner join (SELECT instrumentid, SUM(quantity) AS quantity FROM client_instrument "+
			"WHERE clientid IN (SELECT clientid FROM clients WHERE custodianid= :csid)"+
			"GROUP BY instrumentid) j on i.instrumentid=j.instrumentid; ",nativeQuery = true)
	public List<Object> getAllInstrumentsByCustodian(@Param("csid") String csid);
}
