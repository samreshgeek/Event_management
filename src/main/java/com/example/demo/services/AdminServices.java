package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Booking;
import com.example.demo.entities.Consumers;
import com.example.demo.entities.ServiceProviders;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.ConsumerRepository;
import com.example.demo.repositories.ServiceProvidersRepository;

@Service
public class AdminServices 
{
	@Autowired
	AdminRepository adminrepository;
	
	@Autowired
	ConsumerRepository conrepository;
	
	@Autowired
	ServiceProvidersRepository serprorepository;
	
	@Autowired
	BookingRepository bookingrepository;
	
	public void saveConsumer(Admin admin) 
	{
		adminrepository.save(admin);
	}


	public Admin adminLogin(String id, String password) 
	{
		Admin ad = null;
		List<Admin> clist = adminrepository.findAll();
		

		for (Admin adm : clist) 
		{
			if(adm.getId().equals(id))
			{
				if(adm.getPassword().equals(password))
				{
					ad = adm; 
				}
			}
		}
		
		return ad;
	}


	public List<Consumers> getallConsumers() 
	{
		
		return conrepository.findAll();
	}


	public List<ServiceProviders> getallServiceProviders() 
	{
		return serprorepository.findAll();
	}


	public List<Booking> getallBookings() 
	{
		return bookingrepository.findAll();
	}


}
