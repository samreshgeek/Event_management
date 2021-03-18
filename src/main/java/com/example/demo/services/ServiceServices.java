package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Services;
import com.example.demo.repositories.ServicesRepository;

@Service
public class ServiceServices 
{
		@Autowired
		ServicesRepository servicesrepository;
		
		public List<Services> getAllServices()
		{
			return servicesrepository.findAll();
		}
		
		public Services getServiceById(int service_id)   
		{  
			return servicesrepository.findById(service_id).get();  
		}

		public void deleteServiceById(int service_id) 
		{
			
			servicesrepository.deleteById(service_id);
		}

		public void saveService(Services service) 
		{
			servicesrepository.save(service);
		}

		public void updateService(Services service)   
		{  
			servicesrepository.save(service);  
		}

		public List<Services> getspAllServices() 
		{
			List<Services> slist=servicesrepository.findAll();
			return slist;
		}

		
		  
		
		
}
