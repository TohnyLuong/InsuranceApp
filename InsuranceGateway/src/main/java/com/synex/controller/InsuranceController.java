package com.synex.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class InsuranceController {
	
	@RequestMapping(value="/gateway")
	public String gateway() {
		System.out.println("InsuranceController --- gateway.jsp");
		
		return "gateway";
	}
	
	
	@RequestMapping(value="/home")
	public String home() {
		System.out.println("InsuranceController --- home.jsp");
		
		return "home";
	}
	
	@RequestMapping(value="/plans")
	public String plans() {
		System.out.println("InsuranceController --- plans.jsp");
		
		return "plans";
	}
	
	@RequestMapping(value="{planType}/register")
	public String register(@PathVariable String planType) {
		System.out.println("InsuranceController --- " + planType +"/register.jsp");
		return "register";
	}
	
	@RequestMapping(value="/login")
	public String login(
			@RequestParam(value="logout", required=false) String logout,
			@RequestParam(value="error", required=false) String error,
			HttpServletRequest req, HttpServletResponse res,
			Model model
			) {
		String message = null;
		if(logout != null) {
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if(auth != null) {
				new SecurityContextLogoutHandler().logout(req, res, auth);
				message="You have been logged out.";
			}
		}
		
		if(error != null) {
			message="Either user name or password is incorrect.";
		}
		model.addAttribute("message", message);
		return "login";
	}
	
	@RequestMapping(value="/success")
	public String success() {
		System.out.println("InsuranceController --- success.jsp");
		
		return "home";
	}
	
	@RequestMapping(value="*/registered")
	public String registered() {
		System.out.println("InsuranceController --- registered.jsp");
		
		return "registered";
	}
	
	@RequestMapping(value="*/payment")
	public String payment() {
		System.out.println("InsuranceController --- payment.jsp");
		
		return "payment";
	}
	
	@RequestMapping(value="gateway/claims")
	public String claims() {
		System.out.println("InsuranceController --- claims.jsp");
		
		return "claims";
	}
	
	@RequestMapping(value="gateway/currentenrollment")
	public String currentenrollment() {
		System.out.println("InsuranceController --- currentenrollment.jsp");
		
		return "currentenrollment";
	}
	
	@RequestMapping(value="*/insuranceGatewayUploadFileToClaim")
	public String insuranceGatewayUploadFileToClaim() {
		System.out.println("InsuranceController --- insuranceGatewayUploadFileToClaim");
		
		return "claims";
	}
}