package com.example.FoodData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.parsing.Problem;
//import org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties.Problemdetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.FoodData.model.Food;
//import com.example.FoodData.model.Ingredientsdetails;
import com.example.FoodData.model.Login;
import com.example.FoodData.repository.FoodRepository;
import com.example.FoodData.repository.IngredientsdetailsRepository;
import com.example.FoodData.repository.LoginRepository;

import jakarta.transaction.Transactional;

@Service
public class FoodService {

	@Autowired
	FoodRepository foodRepository;
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	IngredientsdetailsRepository idrep;
	
	public List<Food> getAllFood()
	{
		List <Food> studList=foodRepository.findAll();
		return studList;
	}

	public Food saveFood(Food f) 
	{
		Food obj = foodRepository.save(f);
		return obj;
	}
	
	public Food updateFood(Food f, @PathVariable int regno) 
	{
		return foodRepository.save(f);
	}

	public void deleteFood(int foodId) 
	{
		foodRepository.deleteById(foodId);
	}

	public Food getFood(int foodId) 
	{
		return foodRepository.findById(foodId).get();
	}

	public List<Food> sortFood(String field) {
		
		return foodRepository.findAll(Sort.by(field));
//		return foodRepository.findAll(Sort.by(Direction.DESC,field));
	}
	
	public List<Food> pagingFoods(int offset, int pageSize) 
	{
		Pageable paging=PageRequest.of(offset, pageSize);
		Page<Food> foodData=foodRepository.findAll(paging);
		List<Food> foodList=foodData.getContent();//show the List of page
		return foodList;
		
	}

	public Page<Food> pagingFood(int offset, int pageSize) 
	{
		Pageable paging=PageRequest.of(offset, pageSize);
		Page<Food> foodData=foodRepository.findAll(paging);
		return foodData;
	}
	
	public List<Food> pagingAndSortingFood(int offset,int pageSize,String field) 
	{
//		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(field));
		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(Direction.DESC,field));
		Page<Food> foods=foodRepository.findAll(paging);
		return foods.getContent();
	}
	
	
	
	
	
	//For Login
	public List<Login> getLogin() 
	{
		return loginRepository.findAll();
	}
	
	public Login saveLogin(Login l)
	{
		return loginRepository.save(l); 
	}
	
	public String validateUserLogin(String username,String password)
	{
//		String result="";
		Login l=loginRepository.findByUsername(username);
		if(l==null)
		{
			return "Invalid user";
		}
		else
		{
			if(l.getPassword().equals(password))
			{
				return "Login success";
			}
			else
			{
				return "Login failed";
			}
		}
//		return "Invalid";
	}
	public Food saveData(Food f) 
	{
		return foodRepository.save(f);
	}
	public List<Food> getUser()
	{
		
		return foodRepository.findAll();
	}
	
	
	public List<Food> fetchByRating(int rating)
	{
		return foodRepository.fetchFoodItemByRating(rating);
	}
	
	public List<Food> getFoodByRating(String foodItem, int rating)
	{
		return foodRepository.getFoodByRating(foodItem, rating);
	}
	
	public List<Food> fetchfoodItemWithPrefix(String prefix)
	{
		return foodRepository.findByfoodItemStartingWith(prefix);
	}
	
	public List<Food> fetchfoodItemWithSuffix(String suffix)
	{
		return foodRepository.findByfoodItemEndingWith(suffix);
	}
	
	@Transactional
	public int deleteFoodByRating(String foodItem)
	{ 
		return foodRepository.deleteFoodByRating(foodItem);		
	}
	
	@Transactional
	public int updateFoodByRating(String foodItem, int rating)
	{
		return foodRepository.updateFoodByRating(foodItem,rating);		
	}

	public Food saveIngredients(Food f) {
		Food obj = foodRepository.save(f);
		return obj;
	}

	
	
}


