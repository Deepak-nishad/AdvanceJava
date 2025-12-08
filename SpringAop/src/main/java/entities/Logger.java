package entities;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logger {
	@Pointcut("execution(String entities.Emp.toString())")
	public void selectToString() {
		
	};
	@Pointcut("execution(* entities.Emp.*(..))")
	public void selectAll() {
		
	}
	
	@Before("selectToString()")
	public void logMessage() {
		System.out.println("gets called before businnes logic");
	}

	
}
