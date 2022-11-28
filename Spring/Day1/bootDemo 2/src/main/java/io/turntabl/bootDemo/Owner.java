package io.turntabl.bootDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Owner {
    @Autowired
    private Cat cat;
    @Value("Martina")
    private String name;

    public Owner(){
        this.name = name;
    }


    //setter injection
    public void setCat(Cat cat){
        this.cat = cat;
    }

    public void makePetTalk(){
        cat.makeCatSpeak();
    }

    public void renameCat(String newName){
        cat.setName(newName);
    }
}
