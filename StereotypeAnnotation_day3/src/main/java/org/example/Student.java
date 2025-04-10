package org.example;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Student
{
    @Value("22")
    private int age;
    private String name;
//    @Autowired
//    @Qualifier("pen")
    private Writer writer;
//    @Autowired
//    @Qualifier("pen")
    public void setWriter(Writer writer)
    {
        this.writer=writer;
    }
    public void show()
    {
        writer.write();
    }

    public Student()
    {

    }
   @Autowired
    public Student(@Qualifier("pen") Writer writer)
    {
        this.writer=writer;
    }
}
