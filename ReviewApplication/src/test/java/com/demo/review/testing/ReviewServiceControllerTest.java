package com.demo.review.testing;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.review.entities.Review;
import com.demo.review.service.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ReviewServiceControllerTest {
	@Autowired
    private MockMvc mockMvc;
	@MockBean
    private ReviewService reviewService;
    @Test
	public void test_apiSearchReviewByIDFound() {
    	 try {
    		
		 // given
    		Integer id = 1;
			Review review = new Review();
			review.setReviewID(id);
			review.setReview("มีทั้งเมนูไทย จีน สากล ให้เลือกทาน");
			review.setVersion(1L);
			given(reviewService.searchReviewByID(id)).willReturn(review);
	        
	        
	        mockMvc.perform(get("/reviews/{id}",id))
            .andExpect(status().isOk())
            .andExpect(content().json("{'reviewID': 1,'review':'มีทั้งเมนูไทย จีน สากล ให้เลือกทาน';'version': 1}"));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
  
    @Test
   	public void test_searchReviewByKeywordFound() {
       	 try {
       		
   		 // given
	   		 String keyword = "healthy";
			 List<Review> reviews = new ArrayList<Review>();
			 Review review1 = new Review();
			 review1.setReviewID(1);
			 review1.setReview("ไม่ว่าจะ healthy หรือว่าแบบครีมๆจัดเต็มก็มีให้เลือกครับ");
			 review1.setVersion(1L);
			 reviews.add(review1);
			 
			 Review review2 = new Review();
			 review2.setReviewID(2);
			 review2.setReview("เลือกเป็นแบบ healthy เป็น Veggie Delite");
			 review2.setVersion(1L);
			 reviews.add(review2);
			 reviews.forEach(review -> review.setReview(review.getReview().replace(keyword, "<keyword>"+keyword+"</keyword>")));
   			 given(reviewService.searchReviewByKeyword(keyword)).willReturn(reviews);
   	        
   	        
   	         mockMvc.perform(get("/reviews/")
   	        		 .param("query", keyword))
               .andExpect(status().isOk())
               .andExpect(content().json("[{'reviewID': 1,'review':'ไม่ว่าจะ <keyword>healthy</keyword> หรือว่าแบบครีมๆจัดเต็มก็มีให้เลือกครับ';'version': 1}"
               		+ ",{'reviewID': 2,'review':'เลือกเป็นแบบ <keyword>healthy</keyword> เป็น Veggie Delite';'version': 1}]"));
   		
   		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		
   	}
    
    
    @Test
    public void test_getReview() {
    	try {
    		// given
			 Review review1 = new Review();
			 review1.setReviewID(1);
			 review1.setReview("ไม่ว่าจะ healthy หรือว่าแบบครีมๆจัดเต็มก็มีให้เลือกครับ");
			 review1.setVersion(1L);
			 //reviews.add(review1);
			 
			 given(reviewService.searchReviewByID(1)).willReturn(null);
  	        
			mockMvc.perform( MockMvcRequestBuilders
				      .get("/reviews/{id}", 1)
				      .accept(MediaType.APPLICATION_JSON))
				      .andDo(print())
				      .andExpect(status().isOk());
				      //.andExpect(MockMvcResultMatchers.jsonPath("$.reviewID").value(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
    @Test
    public void test_editReview() {
    	Integer id = 1;
    	String reviewText = "เลือกเป็นแบบ healthy เป็น Veggie Delite";
    	Long version = 1L;
    	Review review = new Review();
    	review.setReviewID(id);
    	review.setReview(reviewText);
    	review.setVersion(version);
    	try {
			mockMvc.perform( MockMvcRequestBuilders
				      .put("/reviews/{id}", 1)
				      .content(asJsonString(review))
				      .contentType(MediaType.APPLICATION_JSON)
				      .accept(MediaType.APPLICATION_JSON))
				      .andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	
}
