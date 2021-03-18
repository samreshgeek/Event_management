package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Booking;
import com.example.demo.entities.ServiceProviders;
import com.example.demo.entities.Services;
import com.example.demo.entities.SpServices;
import com.example.demo.services.BookingServices;
import com.example.demo.services.ServiceProvidersServices;
import com.example.demo.services.ServiceServices;
import com.example.demo.services.SpServicesServices;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ServiceProviderController
{
	@Autowired
	ServiceProvidersServices serviceproviderservice;
	@Autowired
	BookingServices bookingservices;
	@Autowired
	SpServicesServices spserviceser;
	@Autowired
	ServiceServices serservice;

	@GetMapping("ServiceProviderLogIn")
	public ServiceProviders ServiceProviderLogIn(@RequestParam("sp_user_id") String sp_user_id ,@RequestParam("password") String password)
	{		
		return serviceproviderservice.ServiceProviderLogIn(sp_user_id, password);	
	}
	
	@PostMapping("saveServiceProvider")
	public void saveServiceProvider(@RequestBody ServiceProviders servicepro)
	{
		serviceproviderservice.saveServiceProvider(servicepro);
	}
	
	@PostMapping("updateServiceProvider")
	public void updateServiceProvider(@RequestBody ServiceProviders servicepro)
	{
		serviceproviderservice.updateServiceProvider(servicepro);
	}
	
	@GetMapping ("getBookingByServiceProviderById")
	public List<Booking> getBookingByServiceProviderById(@RequestParam("sp_id") int sp_id)
	{
		
		List<Booking> blist = bookingservices.getBookingByServiceProviderById(sp_id);
		
		return blist;
	}
	
	@PostMapping ("saveSpService")
	public SpServices saveSpService(@RequestBody SpServices spservice)
	{
		System.out.println(spservice);
		return spserviceser.saveSpServices(spservice);
	}
	
	@GetMapping ("getspAllServices")
	public List<Services> getspAllServices()
	{
		return serservice.getspAllServices();
		
	}
	
	
	@GetMapping ("getSpServiceById")
	public SpServices getSpService(@RequestParam("sp_service_id") int sp_service_id)
	{
		return spserviceser.getSpService(sp_service_id);
	}
	
	@GetMapping("/getAllSpServiceBySp_id")
	public List<SpServices> getAllSpServiceBySp_id(@RequestParam("sp_id") int sp_id)
	{
		return spserviceser.getAllSpServiceBySp_id(sp_id);
	}
	
	
	@GetMapping("/deleteSpServicesById")
	public String deleteSpServicesById(@RequestParam("service_id") int service_id)
	{
		spserviceser.deleteSpServicesById(service_id);
		return "Deleted!";
	}
}
