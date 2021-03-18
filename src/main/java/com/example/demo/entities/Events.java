package com.example.demo.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Events 
{
	@Id
	private int event_id;
	@Column
	private String event_type;
	
	//default constructor
	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//parameterised constructor
	public Events(int event_id, String event_type) {
		super();
		this.event_id = event_id;
		this.event_type = event_type;
	}
	
	//getter and setter method

	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Events [event_id=" + event_id + ", event_type=" + event_type + "]";
	}
	
	
}
