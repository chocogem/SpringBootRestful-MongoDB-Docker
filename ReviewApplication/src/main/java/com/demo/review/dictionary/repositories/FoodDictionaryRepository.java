package com.demo.review.dictionary.repositories;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.review.entities.FoodDictionary;

public interface FoodDictionaryRepository extends MongoRepository<FoodDictionary, Integer>{
}
