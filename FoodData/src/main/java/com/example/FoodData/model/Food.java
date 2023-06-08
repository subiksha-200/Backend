package com.example.FoodData.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Food {

	@Id
	private int foodId;
	private String foodItem;
	private int rating;
	private String offer;
	private int quantity;
	private String hotelName;
	private String totalQuantity;
	private String availableQuantity;
	public Food() {
		super();
	}
	public Food(int foodId, String foodItem, int rating, String offer, int quantity, String hotelName,
			String totalQuantity, String availableQuantity) {
		super();
		this.foodId = foodId;
		this.foodItem = foodItem;
		this.rating = rating;
		this.offer = offer;
		this.quantity = quantity;
		this.hotelName = hotelName;
		this.totalQuantity = totalQuantity;
		this.availableQuantity = availableQuantity;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public String getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(String availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	
}
