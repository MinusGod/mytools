package com.feng.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.feng.dao.RoleFunctionDao;
import com.feng.dao.UserRoleDao;
import com.feng.dao.UserDao;
import com.feng.entity.Function;
import com.feng.entity.Role;
import com.feng.entity.User;
@Service
public class LoginAndRegisterServcie implements LoginAndRegister {
    @Resource 
    private UserDao userDao;
    @Resource
    private UserRoleDao userRoleDao;
    @Resource
    private RoleFunctionDao roleFunctionDao;
	public String loginVertify(String username, String password, Model model) {
		//查询用户是否合法
		User user=new User();
		user=userDao.findByName(username);
		if(user==null){
			model.addAttribute("userInfo", "用户名不存在！");
			return "login";
		}
		if(!user.getPwd().equals(password)){
			model.addAttribute("pwdInfo","密码错误！");
			return "login";
		}
		
		/*Role role=userRoleDao.roleByUserId(user.getId());
		List<Function> functions=roleFunctionDao.functionByRoleId(role.getId());
		model.addAttribute("user",user);
		model.addAttribute("functions",functions);*/
		return "accountIndex";
	}

}
