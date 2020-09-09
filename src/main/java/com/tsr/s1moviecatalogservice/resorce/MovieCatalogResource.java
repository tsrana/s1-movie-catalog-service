package com.tsr.s1moviecatalogservice.resorce;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tsr.s1moviecatalogservice.model.CatalogItem;
import com.tsr.s1moviecatalogservice.model.Movie;
import com.tsr.s1moviecatalogservice.model.Rating;
import com.tsr.s1moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId){
		
		System.out.println("TSR -- inside getCatalog()... userId="+userId);
		UserRating ratings = restTemplate.getForObject("http://s3-rating-data-service:8083/ratingsdata/users/"+userId, UserRating.class);
		//UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userId, UserRating.class);
		
		return ratings.getUserRating().stream().map(rating -> {
			//Movie movie = restTemplate.getForObject("http://s2-movie-info-service:8082/movies/"+rating.getMovieId(), Movie.class);
			Movie movie = restTemplate.getForObject("http://p2-movie-info-service:5000/api/v1.0/task/id/"+rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), "Film of 2000s", rating.getRating());
		})
		.collect(Collectors.toList());
				
	}
	
	@RequestMapping("/movie/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId) {
		System.out.println("TSR -- inside getMovieInfo()");
		return new Movie(movieId, "Hatyara12");
	}

}
