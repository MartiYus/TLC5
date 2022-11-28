package io.turntabl.bootDemo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cat {
    @Value("Mouse")
    private String name;


    public Cat(){
    }

    public void makeCatSpeak(){
        System.out.println("Meow meow, my name is "+ name );
    }

    public void setName(String newName) {
        this.name = newName;
    }

    @PostConstruct
    public void afterSetup(){
        System.out.println("Cat bean created");
    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("Cat is going to be destroyed.");
    }
}
