public class Owner {
    //dependency
    private Cat cat;
    private String name;

    //constructor injection
    public Owner(String name, Cat cat){
        this.name=name;
        this.cat = cat;
    }

    public Owner(String name){
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
