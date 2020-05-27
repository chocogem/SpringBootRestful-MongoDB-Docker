package com.demo.review.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.demo.review.entities.Review;

public interface ReviewRepository extends MongoRepository<Review, Integer>{
	@Query("{ 'review' : { $regex : ?0 } }")
    public List<Review> searchReviewByKeyword(String text);
	/*
	 * @Query(value
	 * ="SELECT UUID() AS guid,reviewID,group_concat(review_text) AS review_text,1 AS seq from (select * FROM REVIEW WHERE reviewID = :id order by reviewID,seq)  group by reviewID"
	 * ,nativeQuery = true) List<Review> findReviewById(@Param("id") Integer id);
	 * 
	 * @Query(value
	 * ="SELECT UUID() AS guid,reviewID,replace(group_concat(review_text),replace(:text,'%',''),concat('%keyword%',replace(:text,'%',''),'%/keyword%')) AS review_text,1 AS seq from (select * FROM REVIEW WHERE review_text like %:text% order by reviewID,seq)  group by reviewID"
	 * ,nativeQuery = true) //@Query(value
	 * ="SELECT UUID() AS guid,reviewID,replace(group_concat(review_text),:text,concat('<keyword>',:text,'</keyword>')) AS review_text,1 AS seq from (select * FROM REVIEW WHERE review_text like %:text% order by reviewID,seq)  group by reviewID"
	 * ,nativeQuery = true) List<Review> findReviewByText(@Param("text") String
	 * text);
	 * 
	 * Long deleteByReviewID(Integer id);
	 * 
	 * @Modifying
	 * 
	 * @Query(value =" DELETE from Review r WHERE r.reviewID = :id ") void
	 * deleteReviewByID(@Param("id") Integer id);
	 */
}
