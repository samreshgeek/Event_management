package com.example.demo.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin 
{
	//fields
	@Id
	private String id;
	@Column
	private String password;

	//default constructor
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	//parameterised constructor
	public Admin(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	//getter and setter methods
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//toString method
	@Override
	public String toString() {
		return "Admin [id=" + id + ", password=" + password + "]";
	}
	
	
	
}
