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
@Table(name="`message`")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String textMessage;
	private String messageType;
	private String sentDateTime;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "costumerId", nullable = false)
	private Customer customer;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "providerId", nullable = false)
	private Provider provider;

	public String getSentDateTime() {
		return sentDateTime;
	}

	public void setSentDateTime(String sentDateTime) {
		this.sentDateTime = sentDateTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
}
