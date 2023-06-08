package com.example.FoodData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FoodData.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer> {

	public Login findByUsername(String username);

}
