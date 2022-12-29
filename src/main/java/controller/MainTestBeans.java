package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.AccountUser;

public class MainTestBeans {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("controller/Beans.xml");
		AccountUserJDBCTemplate accountJDBCTemplate = (AccountUserJDBCTemplate) context.getBean("AccountUserJDBCTemplate");
		
		String user = "minhviet.dragon@gmail.com";
		String password = "123";
		AccountUser accountUser = accountJDBCTemplate.getAccountUser(user, password);
		
		System.out.println(accountUser.getUser() + " OK");

	}

}
