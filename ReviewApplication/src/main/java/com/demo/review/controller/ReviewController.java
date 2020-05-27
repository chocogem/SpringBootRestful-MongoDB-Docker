package com.demo.review.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.review.entities.Review;
import com.demo.review.repositories.ReviewRepository;


@Component
public class ReviewController {
	 @Autowired
	 ReviewRepository reviewRepository;
	
	 public void clearData() {
		 reviewRepository.deleteAll();
	 }
	 public void createReviewData(InputStream  inputStream) {
		 saveReviewData(inputStream);
	 }
	
	 public void saveReviewData(InputStream  inputStream) {
		  Scanner sc = null;
		  try {
		
		      sc = new Scanner(inputStream, "UTF-8");
		     // List<ReviewTransaction> reviewTransactions = new ArrayList<>();
		      List<Review> reviewList = new ArrayList<>();
		      Review review = null;
		      String readLine = "";
		      String reviewText = "";
		      String delimiter = ";";
		      String currentReviewID = "";
		      int indextOfDelimiter=0;
		      int i=1;
		      
		      while (sc.hasNextLine()) {
		    	  if(i==1) {
		    		  sc.nextLine();
		    	  }else {
		    		  readLine = sc.nextLine();
		    		  indextOfDelimiter = readLine.indexOf(delimiter);
		    		  //first line of each reviewID
		    		  if(indextOfDelimiter>=1 && (indextOfDelimiter<readLine.length()&&readLine.substring(0,indextOfDelimiter).matches("[0-9]+"))) {
		    				    	
		    			  String[] reads= readLine.split(delimiter, 2);
		    			  currentReviewID = reads[0];
		    			  reviewText = reads[1];
		    			  
	    				  review = new Review();
	    				  review.setReviewID(Integer.parseInt(currentReviewID));
	    				  review.setReview(reviewText);
	    				  reviewList.add(review);
		    			  
		    			  
		    			 
		    		  }else {
		    			//next line of each reviewID
		    			  review = reviewList.get(reviewList.size()-1);
		    			  String previousLineText = review.getReview();
		    			  reviewText = previousLineText+readLine;
		    			  review.setReview(reviewText);
			    			  
		    		  }
		    			  
		    	 }
		    		  
			       
		         
		          
		          i++;
		      }
		      if(reviewList!=null&&reviewList.size()>0)
		    	  reviewRepository.saveAll(reviewList);
		      if (sc.ioException() != null) {
		    	  throw sc.ioException();
	        }
		  }catch (Exception e) {
				e.printStackTrace();
			  } finally {
			      if (inputStream != null) {
			          try {
						inputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			      }
			      if (sc != null) {
			          sc.close();
			      }
			  }
	 
	  }
	 
	 
		  
		  
		  
	  
}
