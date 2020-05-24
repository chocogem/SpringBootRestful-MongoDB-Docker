package com.demo.review.repositories;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.review.entities.ReviewTransaction;

public interface ReviewTransactionRepository extends JpaRepository<ReviewTransaction, Integer>{
	@Query(value ="SELECT * from Review_Transaction WHERE reviewID =:id ",nativeQuery = true)
	List<ReviewTransaction> findReviewTransactionById(@Param("id") Integer id);
}
