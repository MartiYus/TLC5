public class Cat extends Pet{

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

}
