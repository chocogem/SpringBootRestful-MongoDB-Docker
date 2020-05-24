package com.demo.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.review.entities.Review;
import com.demo.review.repositories.ReviewRepository;


@Service
public class ReviewService {

		@Autowired
		ReviewRepository reviewRepository;
		
		public List<Review> getReviewByID(Integer id){
			return reviewRepository.findReviewById(id);
		}
		
		public List<Review> getReviewByText(String text){
			return reviewRepository.findReviewByText(text);
		} 
	
}
