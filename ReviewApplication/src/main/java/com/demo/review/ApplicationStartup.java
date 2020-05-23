package com.demo.review;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.demo.review.dictionary.repositories.FoodDictionaryRepository;
import com.demo.review.entities.FoodDictionary;
import com.demo.review.entities.Review;
import com.demo.review.repositories.ReviewRepository;

@Component
public class ApplicationStartup 
implements ApplicationListener<ApplicationReadyEvent> {
  @Autowired 
  FoodDictionaryRepository foodDictionaryRepository;
  @Autowired
  ReviewRepository reviewRepository;
  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {
      init();
  }
  
  private void init() {
	  initFoodDictionary();
	  initReviewData();
	  
  }
  private void initFoodDictionary() {
	  InputStream  inputStream = null;
	  Scanner sc = null;
	  try {
	     ClassLoader classLoader = getClass().getClassLoader();
		 inputStream =  classLoader.getResourceAsStream("data/food_dictionary.txt");
	
	      sc = new Scanner(inputStream, "UTF-8");
	      List<FoodDictionary> foodDictionaryList = new ArrayList<>();
	      FoodDictionary foodDictionary = null;
	      int i=1;
	      while (sc.hasNextLine()) {
	    	  if(i>20000) {
	    		  break;
	    	  }
	          String line = sc.nextLine();
	          foodDictionary = new FoodDictionary();
	          foodDictionary.setKeyword(line);
	          foodDictionaryList.add(foodDictionary);
	          //System.out.println(line);
	          
	          i++;
	      }
	      foodDictionaryRepository.saveAll(foodDictionaryList);
	      if (sc.ioException() != null) {
	          throw sc.ioException();
	      }
	  }catch (Exception e) {
		e.getMessage();
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
  
  private void initReviewData() {
	  InputStream  inputStream = null;
	  Scanner sc = null;
	  try {
	     ClassLoader classLoader = getClass().getClassLoader();
		 inputStream =  classLoader.getResourceAsStream("data/test_file.csv");
	
	      sc = new Scanner(inputStream, "UTF-8");
	      List<Review> reviewList = new ArrayList<>();
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