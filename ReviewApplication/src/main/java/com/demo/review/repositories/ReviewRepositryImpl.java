package com.demo.review.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.review.entities.FoodDictionary;
import com.demo.review.entities.Review;
@Component
public class ReviewRepositryImpl implements ReviewRepositoryCustom {
	@Autowired
	ReviewRepository reviewRepository;
	 public List<Review> findReviewById(){
		 List<Review> reviews = new ArrayList<Review>();
		 Review review = new Review();
		 review.setReviewID(0);
		 reviews.add(review);
		 return reviews;
	 }
	 
	 public List<Review> findReviewByText(){
		 List<Review> reviews = new ArrayList<Review>();
		 Review review = new Review();
		 review.setReviewID(0);
		 reviews.add(review);
		 return reviews;
	 }
	 
	 
	 
	 
}
