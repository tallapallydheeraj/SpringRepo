package com.dbs.ordermatching.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.ordermatching.model.Client;
import com.dbs.ordermatching.model.Custodian;
import com.dbs.ordermatching.repo.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CustodianService custodianService;
	public ClientService() {
		System.out.println("Client Service ");
		// TODO Auto-generated constructor stub
	}
	
	public Client findClientById(String id) throws Exception
	{
		Client client = null;
		try {

			Optional<Client> opt = this.clientRepository.findById(id);
			if(opt.isPresent())
				client = opt.get();
			
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("id cannot be null, Please provide ID");
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return client;

	}
	
	public List<Client> findClientsByCustodianId(String custodianId) throws Exception
	{
		List<Client> clientList =  new ArrayList<>();
		try {
			Custodian custodian = this.custodianService.findCustodianById(custodianId);
			clientList = this.clientRepository.findByCustodian(custodian);
			
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("id cannot be null, Please provide ID");
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return clientList;
	}
	
	public List<String> getAllClientIds()
	{
		List<String> clients = new ArrayList<String>();
		this.clientRepository.findAll().forEach(client-> clients.add(client.getClientId()));
		return clients;
	}
	public boolean updateClient(Client client) {
		
		return clientRepository.save(client)!=null;
	}
	public List<Object> generateBuyReport(){
		return clientRepository.generateBuyReport();
	}
	public List<Object> generateSellReport(){
		return clientRepository.generateSellReport();
	}
}
