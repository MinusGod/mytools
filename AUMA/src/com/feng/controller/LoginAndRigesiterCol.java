package com.feng.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feng.service.LoginAndRegisterServcie;

@Controller
@RequestMapping("/login_register") 
public class LoginAndRigesiterCol {
	public static Logger log; 
	@Resource
	private LoginAndRegisterServcie loginAndRegisterService;
	static{
		log = Logger.getLogger(LoginAndRigesiterCol.class);
	}	
	@RequestMapping("/login") 
	public String login(){
		return "login";
	}
	
	
	@RequestMapping("/loginVertify") 
	public String loginVertify(String username,String password,Model model){
		log.info("****用户登录****"+"username:"+username+","+"password:"+password);
		return loginAndRegisterService.loginVertify(username, password, model);
	}
	
	@RequestMapping("/json") 
	@ResponseBody
	public String jsonTest(){
	String str=
		"<html>"
		+"<head>"+
			"<meta charset='UTF-8'>"+
			"<title></title>"+
		"</head>"+
		"<style type='text/css'>"+
			".colr{color: #00B8AC;}"+
		"</style>"+
		"<body>"+
			"<section class='colr'>"+
				"\u4f60\u597d\u4e16\u754c"+
			"</section>"+
		"</body>"+
	   "</html>";
		return str;
	}

}

