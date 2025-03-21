package com.cherry.APITestPractice.model;




import java.net.PasswordAuthentication;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Apitest_table")
public class TestModel {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) // 自動生成 ID
	int ID;
	String name;
    String  password;

    public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	}
    
    

