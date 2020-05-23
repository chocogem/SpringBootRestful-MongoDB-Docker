package com.demo.review.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Columns;

@Entity
public class FoodDictionary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID guid;

	private String keyword;

	
	public UUID getId() {
		return guid;
	}

	public void setId(UUID id) {
		this.guid = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}



}
