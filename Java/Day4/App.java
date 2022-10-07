import main.Calculator;
import main.DivisionByZeroException;
import main.InterestCalculator;
import test.InterestCalcStub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {
        Function<Integer, Integer> myFunc = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer arg) {
                return arg-1;
            }
        };

        BinaryOperator<Integer> myFunc2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        } ;

        myFunc2.apply(2,3);


        System.out.println(myFunc.apply(2));

    try{
        FileReader fr = getFileREader("myFile.txt");
    }catch(FileNotFoundException e){
        System.out.println(e.getStackTrace());
    }

    Calculator calc = new Calculator(new InterestCalcStub());
    try{
        System.out.println( calc.division(2,0) );
    }catch(DivisionByZeroException e){
        System.out.println(e.getMessage());
        System.out.println("You have tried to divide " +e.getA() +" by " + e.getB());
    }


        InterestCalculator iCalc = new InterestCalculator() {
            @Override
            public double getInterest(int age, double creditScore) {
                return 0.01;
            }
        };



    }

    public static FileReader getFileREader(String path) throws FileNotFoundException{
//      try {
//          return new FileReader(path);
//      }
//      catch(FileNotFoundException e){
//          System.out.println(e.getMessage());
//          return null;
//      }
        return new FileReader(path);
    }
}
