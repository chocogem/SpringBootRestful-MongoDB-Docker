package com.demo.review.entities;

import java.sql.Clob;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private UUID guid;
	@JsonIgnore
	private Integer seq;
	private Integer reviewID;
	@JsonProperty("review")
	private String reviewText;
	public UUID getGuid() {
		return guid;
	}
	public void setGuid(UUID guid) {
		this.guid = guid;
	}
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(Integer reviewID) {
		this.reviewID = reviewID;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	
	

		
	

}
