package animals;

public class Cat extends Pet {

    //class variable
    private static int numberOfCats = 0;

    //constructor
    public Cat(String name){
        //initialization of the instance attribute
        super(name, "yellow");
        numberOfCats ++;
    }

    //overloaded constructor
    public Cat(){
        this("");
       colour = "";
    }


    public static int getNumberOfCats(){
        return numberOfCats;
    }

    public void play(){
        System.out.println("I'm scratching your expensive sofa!");
    }

    public String toString(){
        return this.name + " is " + this.colour;
    }

}
