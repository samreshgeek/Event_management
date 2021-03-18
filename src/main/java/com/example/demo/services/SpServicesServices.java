package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ServiceProviders;
import com.example.demo.entities.Services;
import com.example.demo.entities.SpServices;
import com.example.demo.repositories.ServiceProvidersRepository;
import com.example.demo.repositories.ServicesRepository;
import com.example.demo.repositories.SpServicesRepository;
@Transactional
@Service
public class SpServicesServices 
{
	@Autowired
	SpServicesRepository spservicerepository;
	
	@Autowired
	ServiceProvidersRepository serviceproviderrepository;

	@Autowired
	ServicesRepository ss;
	
	public List<SpServices> getSpServices()
	{
		return spservicerepository.findAll();
	}
	
	//Not  working
	
	public List<SpServices> getSpServicesList(int service_id) {
		
		System.out.println("hello"+service_id);
		
				Optional<Services> obj = ss.findById(service_id);
		
		Services s = obj.get();
		
		List<SpServices> spservicelist = spservicerepository.getSpServicesList(s);
	
		return spservicelist;
	}

	public List<ServiceProviders> getSpServices(int service_id)
	{

		Optional<Services> obj = ss.findById(service_id);
		
		Services s = obj.get();
		
		List<ServiceProviders> splist = spservicerepository.getSpServices(s);
		
		return splist;
	}
	
	public SpServices getSpServicesById(int sp_service_id)   
	{  
	return spservicerepository.findById(sp_service_id).get();  
	}

	public void deleteSpServicesById(int service_id) 
	{
		Services service=ss.findById(service_id).get();
		
		spservicerepository.deleteSpServicesById(service);
	}

	public SpServices saveSpServices(SpServices spservice) 
	{
		return spservicerepository.save(spservice);
	}

	public void updateSpServices(SpServices spservice)   
	{  
		spservicerepository.save(spservice);  
	}

	public SpServices getSpService(int sp_service_id)
	{
		return spservicerepository.findById(sp_service_id).get();
	}

	public List<SpServices> getAllSpServiceBySp_id(int sp_id) 
	{
		ServiceProviders sp = serviceproviderrepository.findById(sp_id).get();
		
		return spservicerepository.getAllSpServiceBySp_id(sp);
	}

	
}
