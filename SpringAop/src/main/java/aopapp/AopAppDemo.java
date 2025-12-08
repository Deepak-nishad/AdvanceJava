package aopapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Emp;

public class AopAppDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		Emp e = ctx.getBean(Emp.class);
		System.out.println(e.toString());   //business logic	


	}

}
