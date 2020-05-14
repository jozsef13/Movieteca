package com.project.module;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`admin`")
public class Admin extends User {
	
	private int numberOfRequests = 0;
	@OneToMany(mappedBy = "admin", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Request> receivedRequests;
	
	public Set<Request> getReceivedRequests() {
		return receivedRequests;
	}

	public void setReceivedRequests(Set<Request> receivedRequests) {
		this.receivedRequests = receivedRequests;
	}

	public int getNumberOfRequests() {
		return numberOfRequests;
	}

	public void setNumberOfRequests() {
		this.numberOfRequests = receivedRequests.size();
	}
}
