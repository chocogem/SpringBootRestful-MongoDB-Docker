package com.demo.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.demo.review.controller.InitDataController;
import com.demo.review.entities.Review;
import com.demo.review.repositories.ReviewRepository;



@Service
public class ReviewService {
		@Autowired
		ReviewRepository reviewRepository;
		@Autowired
		private MongoTemplate mongoTemplate;
		@Autowired 
		InitDataController reviewController;
		
		@Autowired
	    public ReviewService(ReviewRepository reviewRepository,MongoTemplate mongoTemplate) {
	        this.reviewRepository = reviewRepository;
	        this.mongoTemplate = mongoTemplate;
	    }
		@Autowired
	    public ReviewService(ReviewRepository reviewRepository) {
	        this.reviewRepository = reviewRepository;
	    }
	
		
		public Review searchReviewByID(Integer id){
			return reviewRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
			
		}
		
		
		public List<Review> searchReviewByKeyword(String keyword){
			 Iterable<Review> reviews = reviewRepository.searchReviewByKeyword(keyword);
			 if(reviews==null) {
				 throw  new ResponseStatusException(HttpStatus.NO_CONTENT);
			 }
			 reviews.forEach(review -> review.setReview(review.getReview().replace(keyword, "<keyword>"+keyword+"</keyword>")));
			return (List<Review>) reviews;
		} 
		public void editReview(Review review,Integer reviewID) {
			Query query = new Query();
			query.addCriteria(Criteria.where("reviewID").is(reviewID).and("version").is(review.getVersion()));
			Update update = new Update();
			update.set("review", review.getReview());
			if (mongoTemplate.findAndModify(query, update, Review.class) == null) {
				throw new ResponseStatusException(HttpStatus.CONFLICT);
			}
		}
		
	
}
