package com.cherry.APITestPractice.controller;

import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cherry.APITestPractice.dao.TestDao;
import com.cherry.APITestPractice.dao.JdbcDao;
import com.cherry.APITestPractice.model.TestModel;
import com.cherry.APITestPractice.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	public TestDao testDao;
	public TestModel database;
	public JdbcDao jdbcDao;

	@PostMapping("/save")
	public String save( @RequestBody  TestModel data) {
			String name=data.getName();
			String password=data.getPassword();
			System.out.println(name);
			System.out.println(password);
			//存入資料庫
//			testDao.save(data);
			
			jdbcDao.save();
			return "save成功";
			
	}

	@PostMapping("/update")
	public String update(@RequestBody TestModel data) {
		String changename=data.getName();
		String changepassword=data.getPassword();
		System.out.println(changename);
		System.out.println(changepassword);
		//修改
		List<TestModel> changedataList=testDao.findByName(changename);
		TestModel testModel = changedataList.get(0);
		//check if empty
		changedataList.get(0).setPassword(changepassword);
		testDao.save(testModel);
		return "修改"+changename+changepassword+"成功";
		
	}

	@PostMapping("/delete")
	public  String  delete(@RequestBody  TestModel data) {
		String deletename=data.getName();
		String deletepassword=data.getPassword();
		System.out.println(deletename);
		System.out.println(deletepassword);
		List<TestModel> deletedataList=testDao.findByName(deletename);
		testDao.delete(deletedataList.get(0));
		return "刪除成功"+deletename+deletepassword;
	}

	@PostMapping("/find")
	public  List<TestModel> find(@RequestBody  TestModel data) {
		String findname=data.getName();
		String findpassword=data.getPassword();
		System.out.println(findname);
		System.out.println(findpassword);
		 List<TestModel> answerList= testDao.findAll();
		System.out.println(answerList.get(0).getID()); 
		return answerList;
	}

}
