package com.demo.review.dictionary.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.review.entities.FoodDictionary;
import com.demo.review.entities.Review;

public interface FoodDictionaryRepository extends JpaRepository<FoodDictionary, Integer>{
}
