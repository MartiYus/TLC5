package test;

import main.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    public void setup(){
        calc = new Calculator();
    }

    @Test
    public void divisionWithoutZeroTest(){
        double a = 5;
        double b = 10;


        double result = calc.division(a,b);


        Assertions.assertEquals(0.5, result);

    }

    @Test
    public void divisionByZeroTest(){
        double a = 5;
        double b = 0;


        double result = calc.division(a,b);

        Assertions.assertEquals(0, result );
    }

}
