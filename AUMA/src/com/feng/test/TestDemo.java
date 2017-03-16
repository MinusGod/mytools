package com.feng.test;

public class TestDemo  {
	public static void main(String[] args) {
	/*	Logger log = Logger.getLogger("");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring.xml");
		UserRoleDao userDao=(UserRoleDao)ctx.getBean("userRoleDao");
		Role role=(Role) userDao.roleByUserId(1);
		log.info("测试ok");
		System.out.println(role.getName());*/
		String str="你好d__sd2343";
		String regex="^[(\\w)(\u4E00-\u9FA5)]*";
		System.out.println(str.matches(regex));
	}
	

}
