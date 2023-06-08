package com.example.FoodData.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.FoodData.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {

	
	@Query(value="select * from Food f where  f.rating= ?1", nativeQuery=true)
	 public List<Food> fetchFoodItemByRating(int rating);
	
	@Query("select f from Food f where f.foodItem=?1 and f.rating=?2")
	public List<Food> getFoodByRating(String foodItem,int rating);
	
	@Modifying
	@Query("delete from Food f where f.foodItem=?1")
	public int deleteFoodByRating(String foodItem);

	@Modifying
	@Query("update Food f set f.foodItem=?1 where f.rating=?2")
	public int updateFoodByRating(String foodItem,int rating);
	
	List<Food> findByfoodItemStartingWith(String prefix);
	List<Food> findByfoodItemEndingWith(String suffix);
}
