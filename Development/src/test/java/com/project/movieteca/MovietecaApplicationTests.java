package com.project.movieteca;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.project.module.Admin;
import com.project.module.Request;
import com.project.module.RequestStatus;
import com.project.module.User;


class MovietecaApplicationTests {

	@Test
	void getRequestById() {
		Set<Request> requests =  new HashSet<Request>();
		Request fisrtRequest = new Request(1, "add movie", RequestStatus.Sent, "text1", null, null);
		Request secondRequest = new Request(2, "update movie", RequestStatus.Sent, "text2", null, null);
		Request thirdRequest = new Request(3, "add movie3", RequestStatus.Sent, "text3", null, null);
		Request fourthRequest = new Request(4, "add movie2", RequestStatus.Sent, "text4", null, null);
		Request fifthRequest = new Request(5, "add movie69", RequestStatus.Sent, "text5", null, null);
		Request sixthRequest = new Request(6, "add movie20", RequestStatus.Sent, "text6", null, null);
		
		requests.add(fisrtRequest);
		requests.add(secondRequest);
		requests.add(thirdRequest);
		requests.add(fourthRequest);
		requests.add(fifthRequest);
		requests.add(sixthRequest);

		Admin admin = new Admin(6, requests, new User(1, "User1", "User1_2", "User1_3", "user@email.com", "Admin", "M", "Test123", "12.01.1998", "Romania", "Dolj", "Craiova", "Str. Trandafirului", "0746969696", null, true, null));
		
		Request request = admin.getRequestById(4);
		Assert.isTrue(request == fourthRequest);
	}
	
	@Test
	void getRequestsByType() {
			
		Set<Request> requests =  new HashSet<Request>();
		Request fisrtRequest = new Request(1, "add movie", RequestStatus.Sent, "text1", null, null);
		Request secondRequest = new Request(2, "update movie", RequestStatus.Sent, "text2", null, null);
		Request thirdRequest = new Request(3, "add movie", RequestStatus.Sent, "text3", null, null);
		Request fourthRequest = new Request(4, "add movie", RequestStatus.Sent, "text4", null, null);
		Request fifthRequest = new Request(5, "add movie69", RequestStatus.Sent, "text5", null, null);
		Request sixthRequest = new Request(6, "add movie20", RequestStatus.Sent, "text6", null, null);
		
		requests.add(fisrtRequest);
		requests.add(secondRequest);
		requests.add(thirdRequest);
		requests.add(fourthRequest);
		requests.add(fifthRequest);
		requests.add(sixthRequest);

		Admin admin = new Admin(6, requests, new User(1, "User1", "User1_2", "User1_3", "user@email.com", "Admin", "M", "Test123", "12.01.1998", "Romania", "Dolj", "Craiova", "Str. Trandafirului", "0746969696", null, true, null));

		List<Request> returnedRequest = admin.getRequestsByType("add movie22");
		
		Assert.isTrue(!returnedRequest.isEmpty());
	}
}
