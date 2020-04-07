package com.project.module;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String userType;
	private String sex;
	private Date birthDate;
	private String country;
	private String city;
	private String phoneNumber;
	private String nrOfNewMessages;
	@OneToMany(mappedBy = "user")
	private Set<Message> newMessages;

	public Set<Message> getNewMessages() {
		return newMessages;
	}

	public void setNewMessages(Set<Message> newMessages) {
		this.newMessages = newMessages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNrOfNewMessages() {
		return nrOfNewMessages;
	}

	public void setNrOfNewMessages(String nrOfNewMessages) {
		this.nrOfNewMessages = nrOfNewMessages;
	}

}
