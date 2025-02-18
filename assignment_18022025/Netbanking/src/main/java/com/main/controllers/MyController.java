package com.main.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.main.DatabaseOperations;
import com.main.User;

import java.util.InputMismatchException;

import javax.sql.rowset.JdbcRowSet;


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
			mv.addObject("msg", "Customer Already Present");
			mv.addObject("errCode" , "1");
			mv.setViewName("connectionError.jsp");
		}catch(Exception e) {
			mv.addObject("msg" , e.toString());
			mv.addObject("errCode", "3");
			mv.setViewName("connectionError.jsp");
		}
		
		return mv;
	}
	
	@RequestMapping("/verifyRegister")
	public ModelAndView verifyRegister(String id, String name, String password, String c_password) {
		ModelAndView mv = new ModelAndView();
		try {
			if(!password.equals(c_password)) {
				mv.addObject("msg" , "Passwords do not match..");
				mv.addObject("errCode" , "3");
				mv.setViewName("connectionError.jsp");
			}else {				
				User obj  = DatabaseOperations.register(id, name, password);
				
				mv.addObject("uname" , obj.getName());
				mv.setViewName("welcomePage.jsp");
			}
		}catch(NullPointerException e) {
			mv.addObject("msg", "Customer Already Present");
			mv.addObject("errCode" , "2");
			mv.setViewName("connectionError.jsp");
		}catch(Exception e) {
			mv.addObject("msg" , "Some error occured :(");
			mv.addObject("errCode", "4");
			mv.setViewName("connectionError.jsp");
		}
		
		return mv;
	}
	
	
}
