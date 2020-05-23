package com.demo.review.entities;

import java.sql.Clob;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID guid;
	private int seq;
	private int reviewID;
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
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	
	

		
	

}
