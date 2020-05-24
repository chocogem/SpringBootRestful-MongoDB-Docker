package com.demo.review.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.review.entities.Review;
import com.demo.review.service.ReviewService;
@RestController
public class ReviewServiceController {
	@Autowired
	private ReviewService reService;

	
	@RequestMapping(value = "/reviews/{id}", method = RequestMethod.GET)
	public List<Review> searchReviewByID(@PathVariable Integer id) {
		return reService.getReviewByID(id);
		
	}
	
	
	@RequestMapping(value = "/reviews", method = RequestMethod.GET)
	public List<Review> searchReviewByText(@RequestParam("query") String text) {
		return reService.getReviewByText(text);
	}
	
	
}
