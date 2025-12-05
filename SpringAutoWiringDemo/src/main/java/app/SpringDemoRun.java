package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Language;
import beans.Trainer;



public class SpringDemoRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("appContext.xml");
		Trainer l=ctx.getBean(Trainer.class);
		
		
		System.out.println(l);

	}

}
