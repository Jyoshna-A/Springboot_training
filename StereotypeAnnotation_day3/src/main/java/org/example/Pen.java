package org.example;

import org.example.Writer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class Pen implements Writer {
    public Pen()
    {
        System.out.println("Pen Object is created");
    }
public void write()
{
    System.out.println("Writing with Pen");
}
}
