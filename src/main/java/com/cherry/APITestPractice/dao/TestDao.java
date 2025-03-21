package com.cherry.APITestPractice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cherry.APITestPractice.model.TestModel;

@Repository
public interface TestDao extends JpaRepository<TestModel, Integer>  {
	List<TestModel> findByName(String name);
	 
	}








