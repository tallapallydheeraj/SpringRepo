package com.dbs.ordermatching.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.ordermatching.model.Instrument;
import com.dbs.ordermatching.repo.InstrumentRepository;


@Service
public class InstrumentService {

	@Autowired
	private InstrumentRepository instrumentRepository;


	public InstrumentService() {
		System.out.println("Instrument service");
	}

	public Instrument findInstrumentById(String id) throws Exception
	{
		Instrument instrument = null;
		try {

			Optional<Instrument> opt = this.instrumentRepository.findById(id);
			if(opt.isPresent())
				instrument = opt.get();
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("id cannot be null, Please provide ID");
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return instrument;

	}
	
	public List<Instrument> getAllInstruments()
	{
		List<Instrument> instruments = this.instrumentRepository.findAll();
		return instruments;
	}
	public List<Object> getAllInstrumentsByCustodian(String csid){
		return instrumentRepository.getAllInstrumentsByCustodian(csid);
		 
	}
	
	
	
}