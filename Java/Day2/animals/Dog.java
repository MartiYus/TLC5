package animals;

public class Dog extends Pet implements Steerable{

    public Dog(String name){
        super(name, "pink");
    }

    //method overriding
    @Override
    public String sayHello(){
        return "Woof Woof " + super.sayHello();
    }

    public void play(){
        System.out.println("I'm chewing on your shoe.");
    }

    public void fetch(String thing){
        System.out.println("I'm teching your "+thing);
    }

    public void steerLeft(int degree){
        System.out.println("I'm steering left");
    }
    public void steerRight(int degree){
        System.out.println("I'm steering right");
    }


}
