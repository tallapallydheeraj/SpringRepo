package com.dbs.ordermatching.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.ordermatching.model.ClientInstrument;
import com.dbs.ordermatching.repo.ClientInstrumentRepository;

@Service
public class ClientInstrumentService {

	@Autowired
	private ClientInstrumentRepository repo;
	@Autowired
	private ClientService cservice;
	@Autowired
	private InstrumentService iservice;
	public ClientInstrument findClientInstrumentById(String ciid) throws Exception {

		ClientInstrument clientInstrument = null;
		try {

			Optional<ClientInstrument> opt = this.repo.findById(ciid);
			if(opt.isPresent())
				clientInstrument = opt.get();
			
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("id cannot be null, Please provide ID");
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return clientInstrument;
	}
	public boolean existsById(String ciid) {
		return this.repo.existsById(ciid);
	}
	public boolean updateClientInstrument(ClientInstrument ci) {
		
			ClientInstrument clientInstrument= repo.save(ci);
				
			if(clientInstrument==null)
				return false;
			return true;
		
	}
	public boolean insertClientInstrument(String cid,
			String iid, int quantity,char type) throws Exception {
		String ciid=cid+iid;
		if(this.existsById(ciid)) {
			ClientInstrument ci= this.findClientInstrumentById(ciid);
			if(type=='S')
				ci.setQuantity(ci.getQuantity()-quantity);
			else
				ci.setQuantity(ci.getQuantity()+quantity);
			this.updateClientInstrument(ci);
		}
		else {
			ClientInstrument ci= new ClientInstrument();
			ci.setClientInstrumentId(ciid);
			ci.setClient(cservice.findClientById(cid));
			ci.setInstrument(iservice.findInstrumentById(iid));
			ci.setQuantity(quantity);
			this.updateClientInstrument(ci);
		}
		
		return true;
	}
	
	public List<ClientInstrument> getClientInstrumentByCustodian(String csid){
		List<ClientInstrument> l=this.repo.findAll();
		List<ClientInstrument> result=new ArrayList<>();
		for(int i=0;i<l.size();i++) {
			if(l.get(i).getClient().getCustodian().getCustodianId().equals(csid))
				result.add(l.get(i));
		}
		return result;
	}
}
