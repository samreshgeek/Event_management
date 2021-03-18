package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="sp_services")
public class SpServices 
{
	
	//fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sp_service_id;

	@ManyToOne
	@JoinColumn(name = "sp_id")
	ServiceProviders sp_id;

	@ManyToOne
	@JoinColumn(name = "service_id")
	Services service_id;
	
	@Column
	private String description;
	@Column
	private int price;
	
	
	
	
	public SpServices() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SpServices(int sp_service_id, ServiceProviders sp_id, Services service_id, String description, int price) {
		super();
		this.sp_service_id = sp_service_id;
		this.sp_id = sp_id;
		this.service_id = service_id;
		this.description = description;
		this.price = price;
	}

	public int getSp_service_id() {
		return sp_service_id;
	}

	public void setSp_service_id(int sp_service_id) {
		this.sp_service_id = sp_service_id;
	}

	public ServiceProviders getSp_id() {
		return sp_id;
	}

	public void setSp_id(ServiceProviders sp_id) {
		this.sp_id = sp_id;
	}

	public Services getService_id() {
		return service_id;
	}

	public void setService_id(Services service_id) {
		this.service_id = service_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SpServices [sp_service_id=" + sp_service_id + ", sp_id=" + sp_id + ", service_id=" + service_id
				+ ", description=" + description + ", price=" + price + "]";
	}
	

	
	
	
	
}
