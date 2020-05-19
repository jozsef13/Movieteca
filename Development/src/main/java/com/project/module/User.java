package com.project.module;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String userType;
	private String sex;
	private String password;
	private String birthDate;
	private String country = "Romania";
	private String state;
	private String city;
	private String address;
	private String phoneNumber;
	private String profilePicture;
	private boolean active;
	@Transient
	private String passwordConfirm;

	public User(int id, String userName, String firstName, String lastName, String email, String userType, String sex,
			String password, String birthDate, String country, String state, String city, String address,
			String phoneNumber, String profilePicture, boolean active, String passwordConfirm) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userType = userType;
		this.sex = sex;
		this.password = password;
		this.birthDate = birthDate;
		this.country = country;
		this.state = state;
		this.city = city;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.profilePicture = profilePicture;
		this.active = active;
		this.passwordConfirm = passwordConfirm;
	}

	public User(User user) {
		id = user.getId();
		userName = user.getUserName();
		firstName = user.getFirstName();
		email = user.getEmail();
		userType = user.getUserType();
		sex = user.getSex();
		password = user.getPassword();
		birthDate = user.getBirthDate();
		country = user.getCountry();
		state = user.getState();
		city = user.getCity();
		address = user.getAddress();
		phoneNumber = user.getPhoneNumber();
		active = true;
	}

	public User() {

	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
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
}
