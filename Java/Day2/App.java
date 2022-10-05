import animals.Cat;
import animals.Dog;
import animals.Pet;
import animals.Steerable;
import vehicles.Bike;

import java.util.ArrayList;
import java.util.List;

public class App {


    public static void main(String[] args) {


        Math.sqrt(9);

        System.out.println(Cat.getNumberOfCats());

        Cat myCat = new Cat("Agnes");



        myCat.setColour("white");
        System.out.println(myCat.getColour());

        Cat tlcCat = new Cat("Aikins");
        tlcCat.setColour("green");
        System.out.println(tlcCat.getColour());

        Dog myDog = new Dog("Buddy");
        System.out.println(myDog.sayHello());
        System.out.println(myCat.sayHello());

        playWithPet(myCat);
        playWithPet(myDog);


        myDog.fetch("ball");

        Pet myPet = new Dog("Betty");
        //error!!
        //myPet.fetch();

        //error!
        //animals.Pet myOtherPEt = new animals.Pet("name", "black");

        System.out.println(myCat);
        Steerable aThing = new Dog("Missy");
        Steerable anotherThing = new Bike("BMX");

        Bike myBike = new Bike("BMX");
//        steerMyThing(myBike);
//        steerMyThing(myDog);

        int[] myInts = new int[8];
        myInts[0] = 7;
        myInts[4] = 17;
        for(int i= 0; i<myInts.length;i++ ){
            System.out.println(myInts[i]);
        }

        Steerable[] myThings = new Steerable[2];
        myThings[0] = myDog;
        myThings[1] = myBike;

        Pet[] myPets = {myCat, myDog, tlcCat};

        for(Steerable i : myThings){
            i.steerLeft(15);
        }

        List<Pet> myZoo = new ArrayList<>();
        myZoo.add(myCat);
        myZoo.add(myDog);
        for (Pet p : myZoo){
            p.play();
        }

    }

    //class method
    //polymorphism
    public static void playWithPet(Pet pet){
        pet.play();
    }

    public static void steerMyThing(Steerable thing){
        thing.steerLeft(15);
    }


}
