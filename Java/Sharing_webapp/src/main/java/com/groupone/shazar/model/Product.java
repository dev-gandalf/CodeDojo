//package com.groupone.shazar.model;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
////import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//
//
//@Entity
//public class Product {
//
//	@Id
//	@GeneratedValue
//	@Column(name="product_id")
//	int productId;
//
//	String description, title, keyword;
//	int borrowerId;
//	int ownerId;
//	java.sql.Date startDate;
//	java.sql.Date endDate;
//	double pricePerDay;
//
//	@OneToOne(cascade = CascadeType.PERSIST)
//	// @OneToMany(cascade = CascadeType.PERSIST)
//	@JoinColumn
//	private Picture picture;
//
//	public Product() {
//	}
//
//	public Product(String description, String title, String keyword, double pricePerDay) {
//		super();
//		this.description = description;
//		this.title = title;
//		this.keyword = keyword;
//		this.pricePerDay = pricePerDay;
//	}
//
//
//	public Picture getPicture() {
//		return picture;
//	}
//
//	public void setPicture(Picture picture) {
//		this.picture = picture;
//	}
//
//	public double getPricePerDay() {
//		return pricePerDay;
//	}
//
//	public void setPricePerDay(double pricePerDay) {
//		this.pricePerDay = pricePerDay;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getKeyword() {
//		return keyword;
//	}
//
//	public void setKeyword(String keyword) {
//		this.keyword = keyword;
//	}
//
//	public int getProductId() {
//		return productId;
//	}
//
//	public void setProductId(int productId) {
//		this.productId = productId;
//	}
//
//	public int getBorrowerId() {
//		return borrowerId;
//	}
//
//	public void setBorrowerId(int borrowerId) {
//		this.borrowerId = borrowerId;
//	}
//
//	public int getOwnerId() {
//		return ownerId;
//	}
//
//	public void setOwnerId(int ownerId) {
//		this.ownerId = ownerId;
//	}
//
//	public java.sql.Date getStartDate() {
//		return startDate;
//	}
//
//	public void setStartDate(java.sql.Date startDate) {
//		this.startDate = startDate;
//	}
//
//	public java.sql.Date getEndDate() {
//		return endDate;
//	}
//
//	public void setEndDate(java.sql.Date endDate) {
//		this.endDate = endDate;
//	}
//
//
//
//}

package com.groupone.shazar.model;

import java.util.Date;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Product {

	@Id
	@GeneratedValue
	@Column(name="product_id")
	int productId;

	String description, title, keyword;

	String borrowerUsername;
	String ownerUsername;
	int borrowerId;
	int ownerId;
	
	@Temporal(TemporalType.DATE)
	java.util.Date startDate;
	
	@Temporal(TemporalType.DATE)
	java.util.Date endDate;
	
	double pricePerDay;
	private boolean requestproduct=false;
	private boolean acceptrequest=false;
	

	

	public void setRequestproduct(boolean requestproduct) {
		this.requestproduct = requestproduct;
	}

	public boolean isAcceptrequest() {
		return acceptrequest;
	}

	public void setAcceptrequest(boolean acceptrequest) {
		this.acceptrequest = acceptrequest;
	}

	
	
	public Product() {
	}
	

	public Product(String description, String title, String keyword, double pricePerDay) {
		super();
		this.description = description;
		this.title = title;
		this.keyword = keyword;
		this.pricePerDay = pricePerDay;
	}
	


	public Product(String description, String title, String keyword, String borrowerUsername,
			String ownerUsername, Date startDate, Date endDate, double pricePerDay, boolean requestproduct,
			boolean acceptrequest, List<Picture> pictures) {
		super();
	
		this.description = description;
		this.title = title;
		this.keyword = keyword;
		this.borrowerUsername = borrowerUsername;
		this.ownerUsername = ownerUsername;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pricePerDay = pricePerDay;
		this.requestproduct = requestproduct;
		this.acceptrequest = acceptrequest;
		this.pictures = pictures;
	}



	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Picture> pictures;

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}



	public String getBorrowerUsername() {
		return borrowerUsername;
	}

	public void setBorrowerUsername(String borrowerUsername) {
		this.borrowerUsername = borrowerUsername;
	}

	public String getOwnerUsername() {
		return ownerUsername;
	}

	public void setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
	}

	public java.util.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public java.util.Date getEndDate() {
		return endDate;
	}

	public void setEndDate(java.util.Date end) {
		this.endDate = end;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(title,description,keyword,pricePerDay);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(obj==null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(title, other.title) 
				&& Objects.equals(description, other.description) 
				&& Objects.equals(keyword, other.keyword) 
				&& Objects.equals(pricePerDay, other.pricePerDay);
	}
	
	public boolean isRequestproduct() {
		return requestproduct;
	}
}


