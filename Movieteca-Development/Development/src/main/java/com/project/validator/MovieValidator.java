package com.project.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.project.module.Movie;
import com.project.module.Provider;

@Component
public class MovieValidator {

	public List<String> validate(Movie movie, Provider provider){
		List<String> errors = new ArrayList<String>();
		
		for (Movie providerMovie : provider.getMoviesPosted()) {
			if(providerMovie.getId() == movie.getId()) {
				errors.add("You have another movie posted like this!");
			}
		}
		if(!movie.getPlayTime().matches("[0-9][h] [0-5][0-9]min")) {
			errors.add("The play time is incorrect!");
		}
		if(movie.getBuyPrice() < movie.getRentPrice()) {
			errors.add("The price for buying must be greater than the renting price!");
		}
		if(provider.getPaymentPlan().getPlanType().equals("Basic"))
		{
			if(movie.getStock() > 40) {
				errors.add("You can give a stock of only 40!");
			}
			if(provider.getMoviesPosted().size() > 20) {
				errors.add("You added 20 posts already");
			}
		}
		if(provider.getPaymentPlan().getPlanType().equals("Advanced"))
		{
			if(movie.getStock() > 100) {
				errors.add("You can give a stock of only 100!");
			}
			if(provider.getMoviesPosted().size() > 50) {
				errors.add("You added 50 posts already");
			}
		}
		
		return errors;
	}
	
}
