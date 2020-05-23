package com.demo.review.repositories;

import java.util.List;

import com.demo.review.entities.Review;

public interface ReviewRepositoryCustom {
	 List<Review> findReviewById();
}
