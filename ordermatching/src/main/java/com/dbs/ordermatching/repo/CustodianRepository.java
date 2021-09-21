package com.dbs.ordermatching.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbs.ordermatching.model.Custodian;
@Repository
public interface CustodianRepository extends JpaRepository<Custodian, String>{

	@Query(value="select cs.custodianid,tbl.totalbuys from (select c.custodianid,sum(tb.totalbuyvalue) as totalbuys "
			+ "from clients c join (select clientid,sum((quantity-remainingqty)*price) as totalbuyvalue "
			+ "from buy group by clientid) tb on tb.clientid=c.clientid group by c.custodianid) tbl right join custodian cs on "
			+ "cs.custodianid=tbl.custodianid group by cs.custodianid;",nativeQuery = true)
			public List<Object> generateBuyReport();
	
	@Query(value="select cs.custodianid,tbl.totalsells from (select c.custodianid,sum(tb.totalsellvalue) as totalsells "
			+ "from clients c join (select clientid,sum((quantity-remainingqty)*price) as totalsellvalue "
			+ "from sell group by clientid) tb on tb.clientid=c.clientid group by c.custodianid) tbl right join custodian cs on "
			+ "cs.custodianid=tbl.custodianid group by cs.custodianid;",nativeQuery = true)
			public List<Object> generateSellReport();
}
