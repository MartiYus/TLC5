package main;

public class Calculator {

    //dependency
    private InterestCalculator iCalc;

    //dependency injection
    //constructor injection
    public Calculator(InterestCalculator iCalc){
        this.iCalc = iCalc;
    }

    //alternative setter injection
//    public void setiCalc(InterestCalculator iCalc){
//        this.iCalc = iCalc;
//    }

    public double division(double a, double b) throws DivisionByZeroException{
        if (b == 0){
           throw new DivisionByZeroException("You are trying to divide by zero", a,b);
        }
        else return a/b;
    }

    public double calculateInterest(int age, double creditScore){
        double result;
        if (age > 18){
            if (creditScore > 0.95){
                 //from the third party tool
                result = iCalc.getInterest(age, creditScore);
                return result +0.02;
            }
            else if (creditScore > 0.85){
                result = iCalc.getInterest(age, creditScore);
                return result +0.01;
            }
            else{
                return iCalc.getInterest(age, creditScore);
            }
        }
        else{
            return 0.05;
        }
    }


}
