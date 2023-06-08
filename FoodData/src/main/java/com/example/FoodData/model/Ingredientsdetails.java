package com.example.FoodData.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Ingredientsdetails {
	@Id
    @GeneratedValue
	private Long id;
	private String name;
    private String email;
    private String password;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Fooddetails fooddetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Fooddetails getFooddetails() {
		return fooddetails;
	}

	public void setFooddetails(Fooddetails fooddetails) {
		this.fooddetails = fooddetails;
	}

	@Override
	public String toString() {
		return "Ingredientsdetails [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", fooddetails=" + fooddetails + "]";
	}

}
