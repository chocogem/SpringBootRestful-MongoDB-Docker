package com.demo.review.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.review.entities.Review;
@RestController
public class ReviewServiceController {
	@Autowired
	private ReviewController reviewController;

	
	@RequestMapping(value = "/reviews/{id}", method = RequestMethod.GET)
	public List<Review> searchReviewByID(@PathVariable String id) {
		return reviewController.getReviewByID();
		
	}
	
	
	@RequestMapping(value = "/reviews", method = RequestMethod.GET)
	public List<Review> searchReviewByText(@RequestParam("id") String id) {
		return reviewController.getReviewByText();
	}
	
	
}
