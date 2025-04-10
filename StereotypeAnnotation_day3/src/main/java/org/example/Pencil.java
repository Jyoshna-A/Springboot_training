package org.example;

import org.example.Writer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Pencil implements Writer {
    public Pencil()
    {
        System.out.println("Pencil object is created");
    }
    public void write()
    {
        System.out.println("Writing with Pencil");
    }
}
