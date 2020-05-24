package com.demo.review.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class ReviewTransaction {
	@Id
	private Integer reviewID;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Date createdDatetime;
	
	@UpdateTimestamp
	private Date editedDatetime;
	@OneToMany(mappedBy="reviewID", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	List<Review>reviews;
	
	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(Integer reviewID) {
		this.reviewID = reviewID;
	}
	

	public Date getCreatedDatetime() {
		return createdDatetime;
	}
	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}
	public Date getEditedDatetime() {
		return editedDatetime;
	}
	public void setEditedDatetime(Date editedDatetime) {
		this.editedDatetime = editedDatetime;
	}

	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	


}
