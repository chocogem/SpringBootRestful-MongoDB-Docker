package com.demo.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.demo.review.entities.Review;
import com.demo.review.repositories.ReviewRepositryImpl;
@Component
public class ReviewController {
	@Autowired
	private ReviewRepositryImpl reviewRepositoryImpl;
	
	public List<Review> getReviewByID(){
		 return reviewRepositoryImpl.findReviewById();
	 }
	public List<Review> getReviewByText(){
		 return reviewRepositoryImpl.findReviewById();
	 }
}
