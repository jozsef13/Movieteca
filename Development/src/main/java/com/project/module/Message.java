package com.project.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message")

public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String textMessage;
	private String messageType;
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
