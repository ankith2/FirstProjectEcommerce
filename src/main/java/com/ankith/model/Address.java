package com.ankith.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
@NotEmpty(message="should not be empty")
private String houseNo;
@NotEmpty(message="should not be empty")
private String street;
@NotEmpty(message="should not be empty")
private String city;
@NotEmpty(message="should not be empty")
private String state;
@NotEmpty(message="should not be empty")
private String Country;
@NotEmpty(message="should not be empty")
private String pin;
@ManyToOne(cascade=CascadeType.ALL)
private User users;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getHouseNo() {
	return houseNo;
}
public void setHouseNo(String houseNo) {
	this.houseNo = houseNo;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return Country;
}
public void setCountry(String country) {
	Country = country;
}
public String getPin() {
	return pin;
}
public void setPin(String pin) {
	this.pin = pin;
}
public User getUsers() {
	return users;
}
public void setUsers(User users) {
	this.users = users;
}




}