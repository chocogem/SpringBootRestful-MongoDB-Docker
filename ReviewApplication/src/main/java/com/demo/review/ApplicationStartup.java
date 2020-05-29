package com.demo.review;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.demo.review.controller.InitDataController;
import com.demo.review.dictionary.repositories.FoodDictionaryRepository;
import com.demo.review.entities.FoodDictionary;

@Component
public class ApplicationStartup 
implements ApplicationListener<ApplicationReadyEvent> {
  @Autowired 
  FoodDictionaryRepository foodDictionaryRepository;
  @Autowired
  InitDataController initDataController;
  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {
      init();
  }
  
  private void init() {
	 // initFoodDictionary();
	  initReviewData();
	  
  }
  private void initFoodDictionary() {
	  foodDictionaryRepository.deleteAll();
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
	          foodDictionary.setId(UUID.randomUUID().toString());
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
		  e.printStackTrace();
	  } finally {
	      if (inputStream != null) {
	          try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	      }
	      if (sc != null) {
	          sc.close();
	      }
	  }
	 
  }
  
  private void initReviewData() {
	  try {
		 initDataController.clearData();
	     ClassLoader classLoader = getClass().getClassLoader();
	     InputStream  inputStream =  classLoader.getResourceAsStream("data/test_file.csv");
	     initDataController.createReviewData(inputStream);
	  }catch (Exception e) {
		  e.printStackTrace();
	  }
  }
  
}