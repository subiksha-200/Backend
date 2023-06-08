package com.example.FoodData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FoodData.model.Ingredientsdetails;

@Repository
public interface IngredientsdetailsRepository extends JpaRepository<Ingredientsdetails,Long> 
{

}
