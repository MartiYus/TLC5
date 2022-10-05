package vehicles;

import animals.Steerable;

public class Bike implements Steerable {
    private String model;

    public Bike(String model){
        this.model = model;
    }

    public void steerLeft(int degree){
        System.out.println("I'm steering left on my bike!");
    }
    public void steerRight(int degree)
    {
        System.out.println("I'm steering right on my bike!");
    }
}
