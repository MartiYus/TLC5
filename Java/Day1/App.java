public class App {

    public static void main(String[] args) {

        //this will print out Hello World
        /*System.out.println("Hello World");
        int a = 4;
        int b = 7;
        double result = 4/7;
        System.out.println(result);*/

//        int var3 = 1;
//        double doubleVar3 = var3;
//
//        byte byteVar3 = (byte) var3;
//
//        System.out.println();
        Integer myInt = 7;

        System.out.println(Cat.getNumberOfCats());

        Cat myCat = new Cat("Agnes");
        myCat.setColour("white");

        System.out.println(myCat.getColour());



        Cat tlcCat = new Cat("Aikins");
        tlcCat.setColour("green");

        System.out.println(tlcCat.getColour());

        Dog myDog = new Dog("Buddy");


        Cat thirdCat = new Cat();

        thirdCat = myCat;
        System.out.println(Cat.getNumberOfCats());

    }

}
