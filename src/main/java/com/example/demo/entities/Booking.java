package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking 
{
	
	//fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int b_id;
	
	@ManyToOne
	@JoinColumn(name = "c_id")
	Consumers c_id;
	
	@ManyToOne
	@JoinColumn(name = "sp_id")
	ServiceProviders sp_id;
	
	@ManyToOne
	@JoinColumn(name = "sp_service_id")
	SpServices sp_service_id;
	
	@ManyToOne
	@JoinColumn(name = "event_id")
	
	
	Events event_id;
	
	@Column
	private Date booking_date;
	
	@Column
	private float payment;
	
	//default constructor
	public Booking() {
		super();
	}
	//parameterised constructor
	public Booking(int b_id, Consumers c_id, ServiceProviders sp_id, SpServices sp_service_id, Events event_id,
			Date booking_date, float payment) {
		super();
		this.b_id = b_id;
		this.c_id = c_id;
		this.sp_id = sp_id;
		this.sp_service_id = sp_service_id;
		this.event_id = event_id;
		this.booking_date = booking_date;
		this.payment = payment;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public Consumers getC_id() {
		return c_id;
	}
	public void setC_id(Consumers c_id) {
		this.c_id = c_id;
	}
	public ServiceProviders getSp_id() {
		return sp_id;
	}
	public void setSp_id(ServiceProviders sp_id) {
		this.sp_id = sp_id;
	}
	public SpServices getSp_service_id() {
		return sp_service_id;
	}
	public void setSp_service_id(SpServices sp_service_id) {
		this.sp_service_id = sp_service_id;
	}
	public Events getEvent_id() {
		return event_id;
	}
	public void setEvent_id(Events event_id) {
		this.event_id = event_id;
	}
	public Date getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}
	public float getPayment() {
		return payment;
	}
	public void setPayment(float payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "Booking [b_id=" + b_id + ", c_id=" + c_id + ", sp_id=" + sp_id + ", sp_service_id=" + sp_service_id
				+ ", event_id=" + event_id + ", booking_date=" + booking_date + ", payment=" + payment + "]";
	}
	
	
	
	
	
}
