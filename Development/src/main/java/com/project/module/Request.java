package com.project.module;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="`request`")
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String requestType;
	private RequestStatus status;
	private String requestObject;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "adminId", nullable = false)
	private Admin admin;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "providerId", nullable=false)
	private Provider provider;

	public Request(int id, String requestType, RequestStatus status, String requestObject, Admin admin,
			Provider provider) {
		super();
		this.id = id;
		this.requestType = requestType;
		this.status = status;
		this.requestObject = requestObject;
		this.admin = admin;
		this.provider = provider;
	}
	
	public Request() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public String getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(String requestObject) {
		this.requestObject = requestObject;
	}
}
