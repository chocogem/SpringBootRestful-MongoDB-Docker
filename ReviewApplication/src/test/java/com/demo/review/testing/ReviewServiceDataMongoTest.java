package com.demo.review.testing;


import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.review.entities.Review;
import com.demo.review.repositories.ReviewRepository;
import com.demo.review.service.ReviewService;


@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
@RunWith(SpringRunner.class)
public class ReviewServiceDataMongoTest {
		private ReviewService reviewService;
		@Autowired 
		ReviewRepository reviewRepository;
		@Autowired
		private MongoTemplate mongoTemplate;
		@Before
	    public void setUp() {
			reviewService = new ReviewService(reviewRepository,mongoTemplate);
			reviewRepository.deleteAll();
			
	    }
		@After
	    public void tearDown() {
			reviewRepository.deleteAll();
	    }
		@Test
		public void test_searchReviewByID(){
			Integer id = 1;
			Review review = new Review();
			review.setReviewID(id);
			review.setReview("มีทั้งเมนูไทย จีน สากล ให้เลือกทาน");
	       
			reviewRepository.save(review);
			Review expected = reviewService.searchReviewByID(id);
			Assert.assertNotNull(expected);
		}
		@Test
		public void test_searchReviewByKeyword(){
			 String keyword = "healthy";
			 List<Review> reviews = new ArrayList<Review>();
			 Review review1 = new Review();
			 review1.setReviewID(1);
			 review1.setReview("ไม่ว่าจะ healthy หรือว่าแบบครีมๆจัดเต็มก็มีให้เลือกครับ");
			 reviews.add(review1);
			 
			 Review review2 = new Review();
			 review2.setReviewID(2);
			 review2.setReview("เลือกเป็นแบบ healthy เป็น Veggie Delite");
			 reviews.add(review2);
			 reviewRepository.saveAll(reviews);
			 List<Review> expected = reviewService.searchReviewByKeyword(keyword);
			 Assert.assertNotNull(expected);
			 Assert.assertEquals(2, expected.size());
		} 
		@Test
		public void test_editReview() {
			String editedReview ="นม ขนมปังต่างๆ สังขยา" ;
			Integer id = 1;
			Review review = new Review();
			review.setReviewID(id);
			review.setReview("มีทั้งเมนูไทย จีน สากล ให้เลือกทาน");
			reviewRepository.save(review);
			
			review.setReview(editedReview);
			reviewService.editReview(review, id);
			
			Review expected = reviewService.searchReviewByID(id);	
			Assert.assertNotNull(expected);
			Assert.assertEquals(expected.getReview(), editedReview);
		}
		
	
}
