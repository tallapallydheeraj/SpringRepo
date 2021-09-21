package com.dbs.ordermatching.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.ordermatching.model.Custodian;
import com.dbs.ordermatching.repo.CustodianRepository;

@Service
public class CustodianService {

	@Autowired
	private CustodianRepository custodianRepository;
	public CustodianService() {
		System.out.println("Custodian Service ");
		// TODO Auto-generated constructor stub
	}
	
	public Custodian findCustodianById(String id) throws Exception
	{
		Custodian custodian = null;
		try {

			Optional<Custodian> opt = this.custodianRepository.findById(id);
			if(opt.isPresent())
				custodian = opt.get();
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("id cannot be null, Please provide ID");
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return custodian;

	}
	public List<Object> generateBuyReport(){
		return custodianRepository.generateBuyReport();
	}
	public List<Object> generateSellReport(){
		return custodianRepository.generateSellReport();
	}
	
	
}
