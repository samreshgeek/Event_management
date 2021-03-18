package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Feedback;
import com.example.demo.entities.ServiceProviders;
import com.example.demo.repositories.FeedbackRepository;
import com.example.demo.repositories.ServiceProvidersRepository;

@Service
public class FeedbackServices 
{
	@Autowired
	FeedbackRepository feedbackrepository;
	@Autowired
	ServiceProvidersRepository serprorepository;
	
	public List<Feedback> getAllFeedbacks()
	{
		return feedbackrepository.findAll();
	}
	
/////////
	public void saveFeedback(Feedback feedback) 
	{
		feedbackrepository.save(feedback);
	}

	public void updateFeedback(Feedback feedback)   
	{  
		feedbackrepository.save(feedback);  
	}   

	public List<Feedback> getFeedbacBySpId(int sp_id)
	{
		ServiceProviders sp= serprorepository.findById(sp_id).get();
		return feedbackrepository.getFeedbacBySpId(sp);
	}
}
