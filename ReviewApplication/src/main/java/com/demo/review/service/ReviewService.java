package com.demo.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.review.entities.Review;
import com.demo.review.repositories.ReviewRepositryImpl;

@Service
public class ReviewService {

		@Autowired
		private ReviewRepositryImpl reviewRepositoryImpl;
		
		public List<Review> getReviewByID() {
			return reviewRepositoryImpl.findReviewById();
		}
	
}
