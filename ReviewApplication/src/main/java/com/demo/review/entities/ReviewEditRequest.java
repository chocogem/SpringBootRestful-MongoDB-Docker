package com.demo.review.entities;

import java.sql.Clob;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ReviewEditRequest {
	
	@JsonProperty("review")
	private String reviewText;
	
	private String datetimeEdit;
	
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public String getDatetimeEdit() {
		return datetimeEdit;
	}
	public void setDatetimeEdit(String datetimeEdit) {
		this.datetimeEdit = datetimeEdit;
	}

	
	

		
	

}
