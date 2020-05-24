package com.demo.review.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.review.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
	@Query(value ="SELECT UUID() AS guid,reviewID,group_concat(review_text) AS review_text,1 AS seq from (select * FROM REVIEW WHERE reviewID = :id order by reviewID,seq)  group by reviewID",nativeQuery = true)
	List<Review> findReviewById(@Param("id") Integer id);
	
	@Query(value ="SELECT UUID() AS guid,reviewID,replace(group_concat(review_text),:text,concat('<keyword>',:text,'<keyword>')) AS review_text,1 AS seq from (select * FROM REVIEW WHERE review_text like %:text% order by reviewID,seq)  group by reviewID",nativeQuery = true)
	//@Query("SELECT r FROM Review r WHERE r.reviewText like %:text%")
    List<Review> findReviewByText(@Param("text") String text1);
}
