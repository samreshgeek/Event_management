package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="emails")
public class Emails
{
	
	//fields
	@Id
	private int mail_id;
	@ManyToOne
	@JoinColumn(name = "c_id")
	Consumers c_id;
	
	@ManyToOne
	@JoinColumn(name = "sp_id")
	ServiceProviders sp_id;
	
	@Column
	private String c_msg_body;
	@Column
	private String sp_msg_body;
	@Column
	private Date mail_date_time;
	
	//default constructor
	public Emails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emails(int mail_id, Consumers c_id, ServiceProviders sp_id, String c_msg_body, String sp_msg_body,
			Date mail_date_time) {
		super();
		this.mail_id = mail_id;
		this.c_id = c_id;
		this.sp_id = sp_id;
		this.c_msg_body = c_msg_body;
		this.sp_msg_body = sp_msg_body;
		this.mail_date_time = mail_date_time;
	}

	public int getMail_id() {
		return mail_id;
	}

	public void setMail_id(int mail_id) {
		this.mail_id = mail_id;
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

	public String getC_msg_body() {
		return c_msg_body;
	}

	public void setC_msg_body(String c_msg_body) {
		this.c_msg_body = c_msg_body;
	}

	public String getSp_msg_body() {
		return sp_msg_body;
	}

	public void setSp_msg_body(String sp_msg_body) {
		this.sp_msg_body = sp_msg_body;
	}

	public Date getMail_date_time() {
		return mail_date_time;
	}

	public void setMail_date_time(Date mail_date_time) {
		this.mail_date_time = mail_date_time;
	}

	@Override
	public String toString() {
		return "Emails [mail_id=" + mail_id + ", c_id=" + c_id + ", sp_id=" + sp_id + ", c_msg_body=" + c_msg_body
				+ ", sp_msg_body=" + sp_msg_body + ", mail_date_time=" + mail_date_time + "]";
	}
	
	
	
	
	
	
}
