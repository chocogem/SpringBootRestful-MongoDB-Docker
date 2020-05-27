package com.demo.review.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.review.entities.Review;
import com.demo.review.service.ReviewService;
@RestController
public class ReviewServiceController {
	@Autowired
	private ReviewService reviewService;

	
	@RequestMapping(value = "/reviews/{id}", method = RequestMethod.GET)
	public Review searchReviewByID(@PathVariable Integer id) {
		return reviewService.searchReviewByID(id);
		
	}
	
	@RequestMapping(value = "/reviews", method = RequestMethod.GET)
	public List<Review> searchReviewByKeyword(@RequestParam("query") String text) {
		return reviewService.searchReviewByKeyword(text);
	}
	
	@RequestMapping(value = "/reviews/{id}", method = RequestMethod.PUT)
	public void editReview(@RequestHeader HttpHeaders httpHeader,@RequestBody Review editReview,@PathVariable Integer id) {
		reviewService.editReview(editReview,id);
		
	}
	
	
}
