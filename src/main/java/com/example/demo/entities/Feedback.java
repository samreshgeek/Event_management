package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback 
{
	
	//fields
	@Id
	private int fb_id;
	
	@ManyToOne
	@JoinColumn(name = "c_id")
	Consumers c_id;
	
	@ManyToOne
	@JoinColumn(name = "sp_id")
	ServiceProviders sp_id;
	
	@Column
	private String review;
	@Column
	private Date fb_date;
	@Column
	private float rating;
	
	//default constructor
	public Feedback() 
	{
		super();
	}

	public Feedback(int fb_id, Consumers c_id, ServiceProviders sp_id, String review, Date fb_date, float rating) {
		super();
		this.fb_id = fb_id;
		this.c_id = c_id;
		this.sp_id = sp_id;
		this.review = review;
		this.fb_date = fb_date;
		this.rating = rating;
	}

	public int getFb_id() {
		return fb_id;
	}

	public void setFb_id(int fb_id) {
		this.fb_id = fb_id;
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

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Date getFb_date() {
		return fb_date;
	}

	public void setFb_date(Date fb_date) {
		this.fb_date = fb_date;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Feedback [fb_id=" + fb_id + ", c_id=" + c_id + ", sp_id=" + sp_id + ", review=" + review + ", fb_date="
				+ fb_date + ", rating=" + rating + "]";
	}

}
