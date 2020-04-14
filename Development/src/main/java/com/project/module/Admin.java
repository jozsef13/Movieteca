package com.project.module;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`admin`")
public class Admin extends User {
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	private int numberOfRequests;
	@OneToMany(mappedBy = "admin")
	private Set<Request> receivedRequests;
	@OneToMany(mappedBy = "admin")
	private Set<Message> newMessages;

	public Set<Request> getReceivedRequests() {
		return receivedRequests;
	}

	public void setReceivedRequests(Set<Request> receivedRequests) {
		this.receivedRequests = receivedRequests;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public int getNumberOfRequests() {
		return numberOfRequests;
	}

	public void setNumberOfRequests(int numberOfRequests) {
		this.numberOfRequests = numberOfRequests;
	}
}
