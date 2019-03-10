package com.sri.Spring_ORM;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sri.Test.Emp;
public class App 
{
    public static void main( String[] args )
    {
    	 ApplicationContext ctx= new AnnotationConfigApplicationContext(com.sri.conf.AppConfig.class);
    //	Emp w= ctx.getBean(Emp.class);
    	 Emp e=(Emp)ctx.getBean("emp");
    	 e.selectEmps();
    }
}
