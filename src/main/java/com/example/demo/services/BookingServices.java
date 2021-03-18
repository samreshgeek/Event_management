package com.example.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Booking;
import com.example.demo.entities.Consumers;
import com.example.demo.entities.ServiceProviders;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.ConsumerRepository;
import com.example.demo.repositories.ServiceProvidersRepository;

@Transactional
@Service
public class BookingServices 
{
	@Autowired
	BookingRepository bookingrepository;
	
	@Autowired
	ConsumerRepository consumerrepository;
	
	@Autowired
	ServiceProvidersRepository sprepository;
	
	public List<Booking> getAllBookings()
	{
		return bookingrepository.findAll();
	}
	
	public Booking getBookingById(int b_id)   
	{  
		return bookingrepository.findById(b_id).get();  
	}

	public void deleteConsumerBookingById(int b_id) 
	{	
		bookingrepository.deleteConsumerBookingById(b_id);
	}

	public void saveBooking(Booking booking) 
	{
		Consumers consumer = booking.getC_id();
		ServiceProviders serviceprovider = booking.getSp_id();
		
		String servicetype=booking.getSp_service_id().getService_id().getService_type();
		String cname = consumer.getFname().concat(consumer.getLname());
		String spname = serviceprovider.getSp_name();
		String spcompanyname = serviceprovider.getCompany_name();
		String event =booking.getEvent_id().getEvent_type();
		String cmail = consumer.getEmail();
		String spmail = serviceprovider.getEmail();
		String spcontact = serviceprovider.getContact_no();
		String ccontact = consumer.getContact_no();
		Date bdate = booking.getBooking_date();
		
		
		//consumer mail
		
		if(bookingrepository.save(booking)!=null)
		{
			if(consumer instanceof Consumers)
			{

					String message ="Hello "+cname+" you have succefully booked "+spcompanyname+"'s "
							+servicetype+" Service for the event "+event+" on date "+bdate+" thanks for booking "+
							" through Event Management System "
							+"\n\n\n Service Provider Details : \n"+
							"Name : "+spname+"\n Company Name : "+spcompanyname+
							"\n Contact Number : "+spcontact+
							"\n Email Address : "+spmail;
					
	        	String subject = "Successful Booking on Event Managment System";
	        
	        	String to = consumer.getEmail(); //"onkaryadav096@gmail.com"; //"samadhanb32@gmail.com";  //"manojakhadmal02@gmail.com";
	        
	        	String from = "manojakhadmal97@gmail.com"; //String from = "eventmanagmentsystem164@gmail.com";

	        	sendEmail(message,subject,to,from);

			}
			if(serviceprovider instanceof ServiceProviders)
			{
				
				String message ="Hello "+spname+" you have an order for "+event+"booked by "
						+cname+" on date "+bdate+" please provide the service on time. "+
						"\n\n\n Consumer Details : \n"+
						"Name : "+cname+
						"\n Contact Number : "+ccontact+
						"\n Email Address : "+cmail;
				

				
				
				String subject = "Successful Order Through Event Managment System";
		        
	        	String to = serviceprovider.getEmail(); //"onkaryadav096@gmail.com"; //"samadhanb32@gmail.com";  //"manojakhadmal02@gmail.com";
	        
	        	String from = "manojakhadmal97@gmail.com"; //String from = "eventmanagmentsystem164@gmail.com";

	        	sendEmail(message,subject,to,from);

			}
		}
		else
		{
			System.out.println("!!!   Fail   !!!");
		}
		
		 
	}
	
	public static void sendEmail(String message, String subject, String to, String from) 
	{
		//variable for gmail host
		
		String host="smtp.gmail.com";

		//get system properties
	
		 Properties properties = System.getProperties();
		 
		 System.out.println("Properties : "+properties);
	
		 //Setting imp info to properties
		 
		 //set host
		 
		 properties.put("mail.smtp.host", host);
		 
		 properties.put("mail.smtp.port", "465");
		 
		 properties.put("mail.smtp.ssl.enable", "true");
		 
		 properties.put("mail.smtp.auth","true");
		 
		 
		 //Step 1 : To get session obj
		 
		 Session session =  Session.getInstance(properties, new Authenticator(){
			 @Override
				protected PasswordAuthentication getPasswordAuthentication() {
					
					return new PasswordAuthentication("manojakhadmal97@gmail.com", "Manoj@123");
				}	 
			 
		 });

		session.setDebug(true);
		
		 //Step 2 : Compose messagee 
		
		 MimeMessage m = new MimeMessage(session);
		 

		 try 
		 {
			 //set from 
			m.setFrom(from);
		
			//set to
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//set subject
			m.setSubject(subject);
			
			//set text to message
			m.setText(message);
			
			
			// Step 3 : send mail
			//send mail
			
			Transport.send(m);
			
			System.out.println("Mail Send Successfully......................");
			
			
		 }
		 catch (MessagingException e) 
		 {
			e.printStackTrace();
		}
		 
		 
		 
		 
	}

	public void updateBooking(Booking booking)   
	{  
		bookingrepository.save(booking);  
	}
	
	public List<Booking> getBookingByConsumerId(int c_id)
	{
		Optional<Consumers> con =consumerrepository.findById(c_id);
					
		Consumers obj = con.get();
			 
		List<Booking> blist =  bookingrepository.getBookingByConsumerId(obj);
	
		
		return blist;
	}
	public List<Booking> getBookingByServiceProviderById(int sp_id)
	{
		Optional<ServiceProviders> con =sprepository.findById(sp_id);
		
		ServiceProviders sp=con.get();
		
		List<Booking> blist=bookingrepository.getBookingByServiceProviderById(sp);
		return blist;
	}
}
