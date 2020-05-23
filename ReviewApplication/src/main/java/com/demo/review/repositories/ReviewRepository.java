package com.demo.review.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.review.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
}
