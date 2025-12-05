package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entities.Emp;

public class SpringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("appContext.xml");
		Emp e=(Emp) ctx.getBean("emp");
		
		System.out.println(e);

	}

}
