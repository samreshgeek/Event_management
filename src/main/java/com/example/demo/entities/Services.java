package com.example.demo.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="services")
public class Services 
{
	//fields
	@Id
	private int service_id;
	@Column
	private String service_type;
	
	//default constructor
	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//parameterised constructor
	public Services(int service_id, String service_type) {
		super();
		this.service_id = service_id;
		this.service_type = service_type;
	}
	
	//getter ajnd setter methods
	
	
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	
	public String getService_type() {
		return service_type;
	}
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Services [service_id=" + service_id + ", service_type=" + service_type + "]";
	}
	
	
}
