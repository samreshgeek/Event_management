package com.example.demo.services;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.ServiceProviders;
import com.example.demo.repositories.ServiceProvidersRepository;

@Service
public class ServiceProvidersServices 
{
	@Autowired
	ServiceProvidersRepository serviceproviderrepository;
	
	public List<ServiceProviders> getAllServiceProviders()
	{
		return serviceproviderrepository.findAll();
	}
	
	public ServiceProviders getServicesProviderById(int sp_id)   
	{  
	return serviceproviderrepository.findById(sp_id).get();  
	}

	public void deleteServiceProviderById(int sp_id) 
	{
		
		serviceproviderrepository.deleteById(sp_id);
	}

	public void saveServiceProvider(ServiceProviders serviceprovider) 
	{
		if(	serviceproviderrepository.save(serviceprovider)!=null)
		{String message = "Hello Sir Thank For Registration, You have successfully registered on Event Managment System. "
        		+ " Now you can enjoy our all services...!";

        	String subject = "Successful Registration on Event Managment System";
        
        	String to = serviceprovider.getEmail(); //"onkaryadav096@gmail.com"; //"samadhanb32@gmail.com";  //"manojakhadmal02@gmail.com";
        
        	String from = "manojakhadmal97@gmail.com"; //String from = "eventmanagmentsystem164@gmail.com";

        	sendEmail(message,subject,to,from);
		}
		else
		{
			System.out.println("Fail");
		}

	}

	//Email Function
	
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
	
	

	public void updateServiceProvider(ServiceProviders serviceprovider)   
	{  
		ServiceProviders temp = serviceproviderrepository.findById(serviceprovider.getSp_id()).get();
		
		
		if(temp != null)
		{
			temp.setSp_user_id(serviceprovider.getSp_user_id());

			
		
		temp.setPassword(serviceprovider.getPassword());
		temp.setSp_name(serviceprovider.getSp_name());
		temp.setArea(serviceprovider.getArea());
		temp.setCity(serviceprovider.getCity());
		temp.setCompany_name(serviceprovider.getCompany_name());
		temp.setContact_no(serviceprovider.getContact_no());
		temp.setDob(serviceprovider.getDob());
		temp.setEmail(serviceprovider.getEmail());
		temp.setPincode(serviceprovider.getPincode());
		temp.setSp_user_id(serviceprovider.getSp_user_id());
		temp.setState(serviceprovider.getState());
		}
		else
		{
			temp = serviceprovider;
		}
				
		serviceproviderrepository.save(temp);    
	}   
	
	
	public ServiceProviders ServiceProviderLogIn(String sp_user_id , String password)
	{
		ServiceProviders serviceprovider = null;
		List<ServiceProviders> splist = serviceproviderrepository.findAll();
		

		for (ServiceProviders serviceproviders : splist) 
		{
			if(serviceproviders.getSp_user_id().equals(sp_user_id))
			{
				if(serviceproviders.getPassword().equals(password))
				{
					serviceprovider = serviceproviders; 
				}
			}
		}
		
		return serviceprovider;
		
	}
	

}
