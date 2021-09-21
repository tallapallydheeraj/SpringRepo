package com.dbs.ordermatching.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbs.ordermatching.model.Client;
import com.dbs.ordermatching.model.Custodian;
import com.dbs.ordermatching.model.TradeHistory;
@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
	
	public List<Client> findByCustodian(Custodian custodian);
	
	@Query(value="select clientid,sum((quantity-remainingqty)*price) "+
	"as totalbuyvalue from buy group by clientid;",nativeQuery = true)
	public List<Object> generateBuyReport();
	
	@Query(value="select clientid,sum((quantity-remainingqty)*price) "+
			"as totalsellvalue from sell group by clientid;",nativeQuery = true)
	public List<Object> generateSellReport();
	
	
}
