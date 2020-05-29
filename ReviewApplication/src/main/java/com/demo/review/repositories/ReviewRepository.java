package com.demo.review.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.demo.review.entities.Review;

public interface ReviewRepository extends MongoRepository<Review, Integer>{
	@Query("{ 'review' : { $regex : ?0 } }")
    public List<Review> searchReviewByKeyword(String text);

}
