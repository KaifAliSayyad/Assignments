package com.main.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.main.DatabaseOperations;
import com.main.User;

import java.util.InputMismatchException;
import java.util.Map;



@Controller
public class MyController {
	@RequestMapping("/")
	public String getHomePage() {
		return "home.html";
	}
	
	@RequestMapping("/signin")
	public String getLoginPage() {
		return "login.html";
	}

	@RequestMapping("/signup")
	public String getRegisterPage() {
		return "register.html";
	}
	
	
	
	@RequestMapping("/verifyLogin")
	public ModelAndView verifyLogin(String id, String password) {
		ModelAndView mv = new ModelAndView();
		try {
			User obj = DatabaseOperations.login(id, password);
			System.out.println(obj.getId());
			mv.addObject("uname" , obj.getName());
			mv.setViewName("welcomePage.jsp");
		}catch(InputMismatchException e) {
			mv.addObject("msg", "Invalid Password");
			mv.addObject("errCode" , "1");
			mv.setViewName("connectionError.jsp");
		}catch(NullPointerException e) {
			mv.addObject("msg", "Customer Not Found");
			mv.addObject("errCode" , "2");
			mv.setViewName("connectionError.jsp");
		}catch(Exception e) {
			mv.addObject("msg" , "Some error occured!");
			mv.addObject("errCode", "3");
			mv.setViewName("connectionError.jsp");
		}
		
		return mv;
	}
	
	@RequestMapping("/verifyRegister")
	public ModelAndView verifyRegister(User u, String c_password) {
		ModelAndView mv = new ModelAndView();
		try {
			if(!u.getPassword().equals(c_password)) {
				mv.addObject("msg" , "Passwords do not match..");
				mv.addObject("errCode" , "2");
				mv.setViewName("connectionError.jsp");
			}else {				
				DatabaseOperations.register(u);
				
				mv.addObject("uname" , u.getName());
				mv.setViewName("welcomePage.jsp");
			}
		}catch(NullPointerException e) {
			mv.addObject("msg", "Customer Already Present");
			mv.addObject("errCode" , "1");
			mv.setViewName("connectionError.jsp");
		}catch(Exception e) {
			mv.addObject("msg" , "Some error occured :(");
			mv.addObject("errCode", "3");
			mv.setViewName("connectionError.jsp");
		}
		
		return mv;
	}
	
	@RequestMapping("/getUsers")
	public ModelAndView getUsersMap() {
		Map<String, User> users = DatabaseOperations.getUsersMap();
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(users);
		mv.addObject("totalUsers", users.size());
		mv.setViewName("displayUsers.jsp");
		return mv;
	}
	
	
}
