package com.example.FoodData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FoodData.model.Fooddetails;

@Repository
public interface FooddetailsRepository extends JpaRepository<Fooddetails,Long>  
{

}
