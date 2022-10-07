package test;

import main.InterestCalculator;

public class InterestCalcStub implements InterestCalculator {
    public double getInterest(int age, double creditScore){
        return 0.1;
    }
}
