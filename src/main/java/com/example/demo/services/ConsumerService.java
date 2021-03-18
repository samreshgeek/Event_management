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

import com.example.demo.entities.Consumers;
import com.example.demo.repositories.ConsumerRepository;


@Service
public class ConsumerService
{
	@Autowired
	ConsumerRepository crepository;
	
	public List<Consumers> getAllConsumers()
	{
		return crepository.findAll();
	}
	
	public Consumers getConsumerById(int c_id)   
	{  
		return crepository.findById(c_id).get();  
	}

	public void deleteConsumerById(int c_id) 
	{
		
		crepository.deleteById(c_id);
	}

	/*public void saveConsumer(Consumers consumer) 
	{
		 crepository.save(consumer);
	}*/

	
	public void saveConsumer(Consumers consumer) 
	{
		if(crepository.save(consumer)!=null)
		{
			
			String message = "Hello Sir Thank For Registration, You have successfully registered on Event Managment System. "
        		+ " Now you can enjoy our all services...!";

        	String subject = "Successful Registration on Event Managment System";
        
        	String to = consumer.getEmail(); //"onkaryadav096@gmail.com"; //"samadhanb32@gmail.com";  //"manojakhadmal02@gmail.com";
        
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
	
	
	
	public void updateConsumer(Consumers consumer)   
	{
		
		Consumers temp = crepository.findById(consumer.getC_id()).get();
		
	
		if(temp != null)
		{
			temp.setC_user_id(consumer.getC_user_id());

			System.out.println("Hello    :     "+temp.getC_user_id());
		
		temp.setPassword(consumer.getPassword());
		temp.setFname(consumer.getFname());
		temp.setLname(consumer.getLname());
		temp.setContact_no(consumer.getContact_no());
		temp.setEmail(consumer.getEmail());
		temp.setArea(consumer.getArea());
		temp.setCity(consumer.getCity());
		temp.setPincode(consumer.getPincode());
		temp.setPincode(consumer.getPincode());
		temp.setDob(consumer.getDob());

		}
		else
		{
			temp = consumer;
		}
				
		crepository.save(temp);   	
	}
	
	public Consumers ConsumerLogIn(String c_user_id , String password)
	{
		Consumers consumer1 = null;
		List<Consumers> clist = crepository.findAll();
		

		for (Consumers consumers : clist) 
		{
			if(consumers.getC_user_id().equals(c_user_id))
			{
				if(consumers.getPassword().equals(password))
				{
					consumer1 = consumers; 
				}
			}
		}
		
		return consumer1;
	}

}