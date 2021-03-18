package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="service_providers")
public class ServiceProviders 
{
	//fields
	@Id
	private int sp_id;
	@Column
	private String sp_user_id;
	@Column
	private String password;
	@Column
	private String company_name;
	@Column
	private String sp_name;
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
	public ServiceProviders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// parameterised constructor
	public ServiceProviders(int sp_id, String sp_user_id, String password, String company_name, String sp_name,
			String contact_no, String email, String area, String city, String pincode, String state,
			Date dob) {
		super();
		this.sp_id = sp_id;
		this.sp_user_id = sp_user_id;
		this.password = password;
		this.company_name = company_name;
		this.sp_name = sp_name;
		this.contact_no = contact_no;
		this.email = email;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.dob = dob;
	}
	
	// getter and setter method

	public int getSp_id() {
		return sp_id;
	}
	public void setSp_id(int sp_id) {
		this.sp_id = sp_id;
	}
	
	public String getSp_user_id() {
		return sp_user_id;
	}
	public void setSp_user_id(String sp_user_id) {
		this.sp_user_id = sp_user_id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	public String getSp_name() {
		return sp_name;
	}
	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
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
		return "ServiceProviders [sp_id=" + sp_id + ", sp_user_id=" + sp_user_id + ", password=" + password
				+ ", company_name=" + company_name + ", sp_name=" + sp_name + ", contact_no=" + contact_no + ", email="
				+ email + ", area=" + area + ", city=" + city + ", pincode=" + pincode + ", state=" + state + ",  dob=" + dob + "]";
	}
	
	
	
}
