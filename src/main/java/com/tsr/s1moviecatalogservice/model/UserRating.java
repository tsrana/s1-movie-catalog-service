package com.tsr.s1moviecatalogservice.model;

import java.util.List;

public class UserRating {
	private List<Rating> userRating;
	
	public UserRating() {}

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}
	
	
}
