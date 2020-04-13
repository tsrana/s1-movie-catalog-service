package com.tsr.s1moviecatalogservice.resorce;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.RequestContext;

import com.tsr.s1moviecatalogservice.model.CatalogItem;
import com.tsr.s1moviecatalogservice.model.Movie;
import com.tsr.s1moviecatalogservice.model.Rating;
import com.tsr.s1moviecatalogservice.model.UserRating;

@RestController
//@RequestMapping("/")
public class MovieCatalogResourceDefault {
	
	static int cnt=100;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/")
	public List<CatalogItem> getCatalog(){
		
		System.out.println("TSR 1 -- Default Calling...");
		cnt++;
		return restTemplate.getForObject("http://s1-git:8081/catalog/TSR.."+cnt, List.class);
	}
	
	@RequestMapping("/movie/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId) {
		System.out.println("TSR123 -- inside getMovieInfo()");
		return new Movie(movieId, "Hatyara1");
	}

}
