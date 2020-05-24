package com.demo.review.service;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.review.controller.ReviewController;
import com.demo.review.entities.Review;
import com.demo.review.entities.ReviewEditRequest;
import com.demo.review.entities.ReviewEditResponse;
import com.demo.review.entities.ReviewTransaction;
import com.demo.review.repositories.ReviewRepository;
import com.demo.review.repositories.ReviewTransactionRepository;


@Service
public class ReviewService {

		@Autowired
		ReviewRepository reviewRepository;
		@Autowired
		ReviewTransactionRepository reviewTransactionRepository;
		@Autowired 
		ReviewController reviewController;
		
		public List<Review> getReviewByID(Integer id){
			return reviewRepository.findReviewById(id);
		}
		
		public List<Review> getReviewByText(String text){
			return reviewRepository.findReviewByText(text);
		} 
		
		public ReviewEditResponse editReview(ReviewEditRequest editReview,Integer reviewID){
			ReviewEditResponse editResponse = new ReviewEditResponse();
			try {
			List<ReviewTransaction> reviewTransaction = reviewTransactionRepository.findReviewTransactionById(reviewID);
			if(reviewTransaction!=null&&!reviewTransaction.isEmpty()) {
				 SimpleDateFormat formatterDB=new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");  
			     Date editDatetime = formatterDB.parse(editReview.getDatetimeEdit()); 
			     Date lastEditDatetime = reviewTransaction.get(0).getEditedDatetime();
			     //Check cocurrent data
			     if(lastEditDatetime.compareTo(editDatetime)>0) {
			    	 //return error another people updated this record.
			    	 editResponse.setSuccess(false);
			    	 editResponse.setMessage("Cannot update data,This review has been update by another user.");
			    	 editResponse.setReviews(getReviewByID(reviewID));
			    	 
			     }else {

			    	 String reviewText = editReview.getReviewText();
			    	 reviewRepository.deleteReviewByID(reviewID);
			    	 reviewController.editReviewData(reviewText, reviewID);
			    	 editResponse.setSuccess(true);
			    	 editResponse.setMessage("Update data successfully.");
			    	 List<Review>reviews = new ArrayList<Review>();
			    	 Review review = new Review();
			    	 review.setReviewID(reviewID);
			    	 review.setReviewText(reviewText);
			    	 reviews.add(review);
			    	 editResponse.setReviews(reviews);
			    	 
			     }
			     
			}
		
			}catch (Exception e) {
				e.printStackTrace();
				 editResponse.setSuccess(false);
		    	 editResponse.setMessage("System Error: "+e.getMessage());
		    	 editResponse.setReviews(getReviewByID(reviewID));
			}
			return editResponse;
		} 
	
}
