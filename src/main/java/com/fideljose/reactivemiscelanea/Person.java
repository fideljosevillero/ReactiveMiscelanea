package com.fideljose.reactivemiscelanea;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@Component
public class Person {

	@NotNull
	private String id; 
	
	@NotNull(message="Last Name cannot be null")
	@Size(min=3, message="Name cannot ve less that 3 characters")
	private String name;
	
	@NotNull(message="Last Name cannot be null")
	@Size(min=3, message="Lastname cannot ve less that 3 characters")
	private String lastname;
	
	@NotNull(message="Last Name cannot be null")
	@Email(message="Invalid email format")
	private String email;
	
	@NotNull(message="Last Name cannot be null")
	@Size(max=200, min=3)
	private String address;
	
	public Person() {}
	
	public Person(String name, String lastname, String email, String address) {
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
