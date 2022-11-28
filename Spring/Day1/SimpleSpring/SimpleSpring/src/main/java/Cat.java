import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Cat {
    private String name;

    public Cat(String name){
        this.name = name;
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
