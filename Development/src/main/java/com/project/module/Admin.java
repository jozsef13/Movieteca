package com.project.module;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`admin`")
public class Admin extends User {
	
	private int numberOfRequests = 0;
	@OneToMany(mappedBy = "admin")
	private Set<Request> receivedRequests;

	public Admin(int numberOfRequests, Set<Request> receivedRequests, User user) {
		super(user);
		this.numberOfRequests = numberOfRequests;
		this.receivedRequests = receivedRequests;
	}
	
	public Request getRequestById(int id) {
        Request returnRequest = new Request();
        for (Request request : receivedRequests) {
            if(request.getId() == id) {
                returnRequest = request;
                break;
            }
        }

        return returnRequest;
    }

    public List<Request> getRequestsByType(String type){
        List<Request> returnRequests = new ArrayList<Request>();
        for (Request request : receivedRequests) {
            if(request.getRequestType().equals(type)) {
                returnRequests.add(request);
            }
        }

        return returnRequests;
    }

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
