package com.Basic.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Basic.Model.OTOpersonModel;
import com.Basic.Repository.OTOrepository;
import com.Basic.Service.OTOservice;

import jakarta.transaction.Transactional;


@Service
public class OTOserviceImpl implements OTOservice {
      
	@Autowired
	OTOrepository repo;

	@Override
	public OTOpersonModel save_data(OTOpersonModel sm) {
		
		return repo.save(sm);
	}
}
