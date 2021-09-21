package com.dbs.web.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Collateral;
import com.dbs.web.beans.Employee;
import com.dbs.web.beans.repository.CollateralRepository;
import com.dbs.web.beans.repository.EmployeeRepository;


@Service
public class CollateralService {


	@Autowired
	private CollateralRepository collateralRepository;


	public List<Collateral> getAllCollaterals() throws Exception
	{
		List<Collateral> collaterals = new ArrayList<Collateral>();
		this.collateralRepository.findAll().forEach(collateral-> collaterals.add(collateral));
		return collaterals;
	}

	public boolean addCollateral(Collateral collateral) throws Exception {

		try {
			if(this.collateralRepository.findById(collateral.getCollateralId()).isPresent())
			{
				return false;
			}
			this.collateralRepository.save(collateral);
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("The id is null");
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return true;
	}

}
