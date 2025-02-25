package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml")) {
            Dev obj = context.getBean(Dev.class);

            // System.out.println("My age is: " + obj.getAge());
            // obj.getLaptop().compile();
            
            obj.build();
        }
    }
}
