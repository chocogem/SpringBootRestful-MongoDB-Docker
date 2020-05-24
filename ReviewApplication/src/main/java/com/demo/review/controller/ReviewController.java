package com.demo.review.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.review.entities.Review;
import com.demo.review.entities.ReviewTransaction;
import com.demo.review.repositories.ReviewRepository;
import com.demo.review.repositories.ReviewTransactionRepository;


@Component
public class ReviewController {
	 @Autowired
	 ReviewTransactionRepository rReviewTransactionRepository;
	
	 public void createReviewData(InputStream  inputStream) {
		 saveReviewData(inputStream);
	 }
	
	 public void saveReviewData(InputStream  inputStream) {
		  Scanner sc = null;
		  try {
		
		      sc = new Scanner(inputStream, "UTF-8");
		      List<ReviewTransaction> reviewTransactions = new ArrayList<>();
		      List<Review> reviewList = new ArrayList<>();
		      ReviewTransaction reviewTransaction =null;
		      Review review = null;
		      String readLine = "";
		      String reviewText = "";
		      String delimiter = ";";
		      String currentReviewID = "";
		      int indextOfDelimiter=0;
		      int i=1;
		      int seq = 0;
		      while (sc.hasNextLine()) {
		    	  if(i==1) {
		    		  sc.nextLine();
		    	  }else {
		    		  readLine = sc.nextLine();
		    		  indextOfDelimiter = readLine.indexOf(delimiter);
		    		  //first line of each reviewID
		    		  if(indextOfDelimiter>=1 && (indextOfDelimiter<readLine.length()&&readLine.substring(0,indextOfDelimiter).matches("[0-9]+"))) {
		    				    			  
		    			  seq=1;
		    			  String[] reads= readLine.split(delimiter, 2);
		    			  currentReviewID = reads[0];
		    			  reviewText = reads[1];
		    			 // if(saveType == SaveType.CREATE) {
			    			  reviewTransaction = new ReviewTransaction();
			    			  reviewTransaction.setReviewID(Integer.parseInt(currentReviewID));
			    			  reviewList = new ArrayList<>();
			    			  reviewTransaction.setReviews(reviewList);
			    			  reviewTransactions.add(reviewTransaction);
		    			 // }
		    			  if(reviewText.length()>255) {
		    			 	 splitOverReviewText(currentReviewID,reviewText,seq,reviewList);
		    			  }else {
		    				  review = new Review();
		    				  review.setReviewID(Integer.parseInt(currentReviewID));
		    				  review.setSeq(seq);
		    				  review.setReviewText(reviewText);
		    				  reviewList.add(review);
		    				 // System.out.println("ID:"+currentReviewID);
		    				 // System.out.println("SEQ:"+seq);
		    				 // System.out.println(reviewText);
		    			  }
		    			  
		    			 
		    		  }else {
		    			  seq++;
		    			  reviewText = readLine;
		    			  if(reviewText.length()>255) {
			    			 	 splitOverReviewText(currentReviewID,reviewText,seq,reviewList);
			    			  }else {
			    				  review = new Review();
			    				  review.setReviewID(Integer.parseInt(currentReviewID));
			    				  review.setSeq(seq);
			    				  review.setReviewText(reviewText);
			    				  reviewList.add(review);
			    				 // System.out.println("ID:"+currentReviewID);
			    				 // System.out.println("SEQ:"+seq);
			    				 // System.out.println(reviewText);
			    			  }
		    		  }
		    			  
		    	 }
		    		  
			       
		         
		          
		          i++;
		      }
		      if(reviewTransactions!=null&&reviewTransactions.size()>0)
		    	  rReviewTransactionRepository.saveAll(reviewTransactions);
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
	 
	 public void editReviewData(String inputText,Integer reviewID) {
		 try {
		  List<ReviewTransaction> reviewTransactions = new ArrayList<>();
	      List<Review> reviewList = new ArrayList<>();
	      Review review = null;
	      ReviewTransaction reviewTransaction =null;
		  int seq =1;
		  reviewTransaction = new ReviewTransaction();
		  reviewTransaction.setReviewID(reviewID);
		  reviewList = new ArrayList<>();
		  reviewTransaction.setReviews(reviewList);
		  reviewTransactions.add(reviewTransaction);
		  if(inputText.length()>255) {
			 	 splitOverReviewText(String.valueOf(reviewID),inputText,seq,reviewList);
		  }else {
			  review = new Review();
			  review.setReviewID(Integer.parseInt(String.valueOf(reviewID)));
			  review.setSeq(seq);
			  review.setReviewText(inputText);
			  reviewList.add(review);
			 // System.out.println("ID:"+currentReviewID);
			 // System.out.println("SEQ:"+seq);
			 // System.out.println(reviewText);
		  }
		  if(reviewTransactions!=null&&reviewTransactions.size()>0)
			  rReviewTransactionRepository.saveAll(reviewTransactions); 
		 }catch (Exception e) {
			e.printStackTrace();
		}
	 }
	  public void splitOverReviewText(String currentReviewID,String reviewText,int seq,List<Review> reviewList) {
		  Review review = null;
		  if(reviewText.length()>255) {
			  String overText = reviewText.substring(255);
			  reviewText = reviewText.substring(0,255);
			  
			  boolean foundOverText = true;
			  while(foundOverText) {
				  
				  if(overText.length()>255) {
					  reviewText = overText.substring(0,255);
					  overText = overText.substring(255);

					  review = new Review();
					  review.setReviewID(Integer.parseInt(currentReviewID));
	    			  review.setSeq(seq);
	    			  review.setReviewText(reviewText);
	    			  reviewList.add(review);
					  
	    			//  System.out.println("ID:"+currentReviewID);
					//  System.out.println("SEQ:"+seq);
					//  System.out.println(reviewText);
					  seq++;
				  }else {
					  
					  reviewText = overText;
					  foundOverText=false;
					  
					  review = new Review();
					  review.setReviewID(Integer.parseInt(currentReviewID));
	    			  review.setSeq(seq);
	    			  review.setReviewText(reviewText);
	    			  reviewList.add(review);
	    			//  System.out.println("ID:"+currentReviewID);
					//  System.out.println("SEQ:"+seq);
					//  System.out.println(reviewText);
					  seq++;
				  }
			  }
			  
		  }
		  
		  
		  
	  }
}
