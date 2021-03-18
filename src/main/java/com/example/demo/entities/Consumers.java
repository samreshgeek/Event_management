package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consumers")
public class Consumers 
{
	//fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int c_id;
	@Column
	private String c_user_id;
	@Column
	private String password;
	@Column
	private String fname;
	@Column
	private String lname;
	@Column
	private String contact_no;
	@Column
	private String email;
	@Column
	private String area;
	@Column
	private String city;
	@Column
	private String pincode;
	@Column
	private String state;
	@Column
	private Date dob;
	
	//default constructor
	public Consumers()
	{
		super();
	}
	
	//parameterised construcor
	public Consumers( String c_user_id, String password, String fname, String lname, String contact_no,
			String email, String area, String city, String pincode, String state, Date dob) {
		super();
		this.c_user_id = c_user_id;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.contact_no = contact_no;
		this.email = email;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.dob = dob;
	}
	public Consumers( int c_id, String c_user_id, String password, String fname, String lname, String contact_no,
			String email, String area, String city, String pincode, String state, Date dob) {
		super();
		this.c_id=c_id;
		this.c_user_id = c_user_id;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.contact_no = contact_no;
		this.email = email;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.dob = dob;
	}
	
	//getter and setter methods
	
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	
	public String getC_user_id() {
		return c_user_id;
	}
	public void setC_user_id(String c_user_id) {
		this.c_user_id = c_user_id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Consumers [c_id=" + c_id + ", c_user_id=" + c_user_id + ", password=" + password + ", fname=" + fname
				+ ", lname=" + lname + ", contact_no=" + contact_no + ", email=" + email + ", area=" + area + ", city="
				+ city + ", pincode=" + pincode + ", state=" + state + ", dob=" + dob + "]";
	}
	
	
}
