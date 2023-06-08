package com.example.FoodData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties.Problemdetails;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.FoodData.model.Food;
//import com.example.FoodData.model.Ingredientsdetails;
import com.example.FoodData.model.Login;
import com.example.FoodData.service.FoodService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class FoodController {

	@Autowired
	FoodService foodService;
	
	@Tag(name="Get", description ="get data")
	@GetMapping(value="/fetchFood")
	public List<Food> getAllRecipe()
	{
		List<Food> studList=foodService.getAllFood();
		return studList;
	}
	//http://localhost:9080/saveStudent
	
	@PostMapping(value="/saveRecipe")
	public Food saveRecipe(@RequestBody Food f)
	{
		return foodService.saveFood(f);
		
	}
	
	@PutMapping(value="/updateFood/{foodId}")
	public Food updateFood(@RequestBody Food f, @PathVariable int foodId)
	{
		return foodService.updateFood(f,foodId);
		
	}
	
	@DeleteMapping("/deleteFood/{foodId}")
	public void deleteFood(@PathVariable("foodId") int foodId)
	{
		foodService.deleteFood(foodId);
		
	}
	
	@GetMapping(value="/sortFood/{field}")
	public List<Food> sortFood(@PathVariable String field)
	{
		return foodService.sortFood(field);
	}

	
	@GetMapping("/pagingFoods/{offset}/{pageSize}")
	public List<Food> pagingFoods(@PathVariable int offset, @PathVariable int pageSize)
	{
		return foodService.pagingFoods(offset,pageSize);
	}
	
	@GetMapping("/pagingFood/{offset}/{pageSize}")
	public Page<Food> pagingFood(@PathVariable int offset, @PathVariable int pageSize)
	{
		return foodService.pagingFood(offset,pageSize);
	}
	
	@GetMapping("/pagingAndSorting/{offset}/{pageSize}/{field}")
	public List<Food> pagingAndSortingFood(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		return foodService.pagingAndSortingFood(offset,pageSize,field);
		
	}
	
	
	
	
	//For Login`
	@GetMapping(value="/getLogin")
	public List<Login> getLogin()
	{
		return foodService.getLogin();
	}
	
	@PostMapping(value="/addUserLogin")
	public Login saveLogin(@RequestBody Login l)
	{
		return foodService.saveLogin(l);
	}
	
	@PostMapping(value="/checkLogin")
	public String validateUserLogin(@RequestBody Login l)
	{
		System.out.println(l.getUsername());
		return foodService.validateUserLogin(l.getUsername(),l.getPassword());
	}
	
	@PostMapping(value="/saveIngredients")
	public Food saveIngredientsDetails(@RequestBody Food f)
	{
		return foodService.saveIngredients(f);
	}
  
	@GetMapping("/fetchByFood/{rating}")
	public List<Food> fetchByRating(@PathVariable int rating)
	{
		return foodService.fetchByRating(rating);
	}
    
	@GetMapping("/getFoodByRating/{foodItem}/{rating}")
	public List<Food> getFoodByRating(@PathVariable String foodItem,@PathVariable int rating)
	{
		return foodService.getFoodByRating(foodItem, rating);  
	}
	
    @GetMapping("/fetchFoodItemWithPrefix")
    public List<Food> fetchFoodItemrWithPrefix(@RequestParam String prefix)
    {
    	return foodService.fetchfoodItemWithPrefix(prefix);
   }
   
    //derived queries
    //queries
  @GetMapping("/fetchFoodItemWithSuffix")
  public List<Food> fetchFoodItemWithSuffix(@RequestParam String suffix)    {
    	return foodService.fetchfoodItemWithSuffix(suffix);
   }
    
	//DML
	@DeleteMapping("/deleteFoodItemByRating/{foodItem}")
    public String deleteFoodItemByRating(@PathVariable String foodItem)
   {
   	int result=foodService.deleteFoodByRating(foodItem);
   	if(result>0)
   		return "food record deleted";
   	else
   		return "Problem occured while deleting";
    }
    
   @PutMapping("/updateFoodByRating/{foodItem}/{Rating}")
   public String updateFoodByRating(@PathVariable String foodItem,@PathVariable int Rating)
   {
  	int result=foodService.updateFoodByRating(foodItem, Rating);
   	if(result>0)
    		return "food record updated";
    	else
    		return "Problem occured while updating";
    }
}
