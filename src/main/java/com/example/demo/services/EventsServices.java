package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Events;
import com.example.demo.repositories.EventsRepository;


@Service
public class EventsServices 
{
	@Autowired
	EventsRepository eventrepository;
	
	public List<Events> getAllEvents()
	{
		return eventrepository.findAll();
	}
	
	public Events getEventById(int event_id)   
	{  
		return eventrepository.findById(event_id).get();  
	}

	public void deleteEventById(int event_id) 
	{
		
		eventrepository.deleteById(event_id);
	}

	public void saveEvent(Events event) 
	{
		eventrepository.save(event);
	}

	public void updateEvent(Events event)   
	{  
		eventrepository.save(event);  
	}
}
