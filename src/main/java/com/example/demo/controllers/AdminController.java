package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Booking;
import com.example.demo.entities.Consumers;
import com.example.demo.entities.ServiceProviders;
import com.example.demo.services.AdminServices;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AdminController 
{

	@Autowired
	AdminServices adminservice;
	
	@GetMapping("/adminLogin")
	public Admin adminLogin(@RequestParam("id") String id, @RequestParam("password") String password)
	{
		return adminservice.adminLogin(id,password);
	}
	
	@GetMapping("/getallConsumers")
	public List<Consumers> getallConsumers()
	{
		return adminservice.getallConsumers();
	}
	
	
	@GetMapping("/getallServiceProviders")
	public List<ServiceProviders> getallServiceProviders()
	{
		return adminservice.getallServiceProviders();
	}
	
	@GetMapping("/getallBookings")
	public List<Booking> getallBookings()
	{
		return adminservice.getallBookings();
	}
}
