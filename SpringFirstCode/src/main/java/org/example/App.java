package org.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{




    public static void main( String[] args )
    {
        //Container is created due to this line
        ApplicationContext context=new ClassPathXmlApplicationContext("springconfig.xml");
        Student student=(Student)context.getBean("st1");
//
//        System.out.println(student.getAge());
//        student.show();
//        System.out.println( "Hello World!" );
        student.writing();

    }
}
