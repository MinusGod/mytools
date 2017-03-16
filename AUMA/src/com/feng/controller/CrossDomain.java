/*package com.feng.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class CrossDomain {
	@RequestMapping("/crossDomain")
	@ResponseBody
	public void crossDomain(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("crossDomain正在执行......");
		PrintWriter print;
		try {
			response.setContentType("text/html;charset=utf-8");
			print = response.getWriter();
			String jsonp = request.getParameter("callback");
			String str = jsonp + "({name:100,age:26})";
			System.out.println(str);
			print.write(str);
			print.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}
*/