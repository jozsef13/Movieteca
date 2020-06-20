package com.project.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "request")
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String requestType;
	private String status;
	private String requestObject;
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(String requestObject) {
		this.requestObject = requestObject;
	}
}
