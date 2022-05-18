package org.itstep.springbootsimple.animals;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Dog {
    public void sound(){
        System.out.println("Woof");
    }
}
