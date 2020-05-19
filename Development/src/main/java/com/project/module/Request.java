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
	private RequestStatus status = RequestStatus.Sent;
	private String requestObject;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "adminId", nullable = true)
	private Admin admin;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "providerId", nullable = true)
	private Provider provider;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId", nullable=true)
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
