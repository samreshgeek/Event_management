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
import com.example.demo.entities.Consumers;
import com.example.demo.entities.Events;
import com.example.demo.entities.Feedback;
import com.example.demo.entities.ServiceProviders;
import com.example.demo.entities.Services;
import com.example.demo.entities.SpServices;
import com.example.demo.services.BookingServices;
import com.example.demo.services.ConsumerService;
import com.example.demo.services.EventsServices;
import com.example.demo.services.FeedbackServices;
import com.example.demo.services.ServiceProvidersServices;
import com.example.demo.services.ServiceServices;
import com.example.demo.services.SpServicesServices;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ConsumerController
{
	@Autowired
	ConsumerService cservice;
	
	@Autowired
	BookingServices bookingservice;

	@Autowired
	EventsServices eventservices;
	
	@Autowired
	FeedbackServices feedbackservice;
	
	@Autowired
	ServiceProvidersServices serviceproviderservice;
	
	@Autowired
	ServiceServices serviceservices;
	
	@Autowired
	SpServicesServices spservices;
	
	@Autowired
	BookingServices bookingservices;
	
	//Consumer Controller Methods
	
	@GetMapping("/getBookingByConsumerId")
	public List<Booking> getBookingByConsumerId(@RequestParam("c_id")int c_id)
	{
		System.out.println(c_id);
		List<Booking> blist = bookingservices.getBookingByConsumerId(c_id);
		System.out.println(blist);
		return blist;
	}
	
	@GetMapping("/getServiceProviders")
	public List<ServiceProviders> getSpServices(@RequestParam("service_id")int service_id)
	{
		System.out.println(service_id);
		List<ServiceProviders> splist  =  spservices.getSpServices(service_id);
		
		System.out.println(splist);
		
		return splist;
	}
	
	//Get list Sp_service
	
	@GetMapping("/getSpServicesList")
	public List<SpServices> getSpServicesList(@RequestParam("service_id")int service_id)
	{
		System.out.println(service_id);
		List<SpServices> spservicelist  =  spservices.getSpServicesList(service_id);
		
		System.out.println(spservicelist);
		
		return spservicelist;
	}
	
	
	@GetMapping("ConsumerLogIn")
	public Consumers ConsumerLogIn(@RequestParam("c_user_id") String c_user_id ,@RequestParam("password") String password)
	{		
		return cservice.ConsumerLogIn(c_user_id, password);	
	}
	
	@GetMapping("/getAllServices")
	public List<Services> getAllServices()
	{
		return serviceservices.getAllServices();
	}
	
	@GetMapping("/getall")
	public List<Consumers> getAllConsumer()
	{
		return cservice.getAllConsumers();
	}
	
	@GetMapping("/getConsumerById")  
	public Consumers getById(@RequestParam("c_id") int c_id)
	{
		return cservice.getConsumerById(c_id);
	}
	
	// This method not provide in angular/ front end
	@GetMapping("/deleteConsumerById")  
	public String deleteConsumer(@RequestParam("c_id") int c_id)   
	{  
		cservice.deleteConsumerById(c_id); 
		return "You Have Successfull Deleted Your Account";
	}  
	
	@PostMapping("/saveConsumer")
	public String saveConsumer(@RequestBody Consumers consumer)   
	{  
		cservice.saveConsumer(consumer);  
		return "You Have Successfull Registered";  
	}  
	
	@PostMapping("/updateConsumer")
	public String updateConsumer(@RequestBody Consumers consumer)   
	{  
		cservice.updateConsumer(consumer);  
		return "updated";  
	}  
	
//Booking Controller Methods
	
	@GetMapping("/getAllBookings")
	public List<Booking> getAllBookings()
	{
		return bookingservice.getAllBookings();
	}
	
	@GetMapping("/getConsumerBookingById")
	public Booking getConsumerBookingById(@RequestParam("b_id") int b_id)
	{
		return bookingservice.getBookingById(b_id);
	}
	
	@PostMapping("/consumerSaveBooking")
	public void saveConsumerBooking(@RequestBody Booking booking)
	{
		System.out.println(booking);
		 bookingservice.saveBooking(booking);
	}

	@GetMapping("/deleteConsumerBookingById")  
	public String deleteConsumerBookingById(@RequestParam("b_id") int b_id)   
	{  
		bookingservice.deleteConsumerBookingById(b_id); 
		return "You Have Successfull Deleted Your Account";
	}  
	
//Events Controller Methods
		
	@GetMapping("/getAllEvents")
	public List<Events> getAllEvents()
	{
		return eventservices.getAllEvents();
	}
			

// Service Provider Controller Methods
	
	@GetMapping("/getAllServiceProviders")
	public List<ServiceProviders> getAllServiceProviders()
	{
		return serviceproviderservice.getAllServiceProviders();
	}
	
	
	///servicder+consumer
		@GetMapping("/getFeedbackById")
		public List<Feedback> getConsumerFeedbackById(@RequestParam("sp_id") int sp_id)
		{
			return feedbackservice.getFeedbacBySpId(sp_id);
		}
		 
		
		@PostMapping("/saveConsumerFeedback")
		public String saveConsumerFeedback(@RequestBody Feedback feedback)   
		{  
			feedbackservice.saveFeedback(feedback);
			return "registered";  
		}  
		

	
	
}
