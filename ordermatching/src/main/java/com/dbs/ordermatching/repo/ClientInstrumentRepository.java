package com.dbs.ordermatching.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbs.ordermatching.model.ClientInstrument;
@Repository
public interface ClientInstrumentRepository extends JpaRepository<ClientInstrument, String> {

}
