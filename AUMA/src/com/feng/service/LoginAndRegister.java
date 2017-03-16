package com.feng.service;

import org.springframework.ui.Model;

public interface LoginAndRegister {
	public String loginVertify(String username,String password,Model model);

}
