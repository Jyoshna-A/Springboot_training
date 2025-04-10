package org.example;

import org.example.Student;
import org.example.config.MyConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context =new AnnotationConfigApplicationContext(MyConfiguration.class);
//        Student student=context.getBean(Student.class);
        Student student= (Student) context.getBean(Student.class); //It will return objet of type Object,u need to typecast to Student
       System.out.println(student.getAge());
        student.show();
        System.out.println( "Hello World jo!" );
    }
}
