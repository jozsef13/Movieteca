package com.project.module;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`admin`")
public class Admin extends User {
	
	private int numberOfRequests;
	@OneToMany(mappedBy = "admin")
	private Set<Request> receivedRequests;
	@OneToMany(mappedBy = "admin")
	private Set<Message> messages;

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

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> newMessages) {
		this.messages = newMessages;
	}
}
