package test;

import main.Calculator;
import main.DivisionByZeroException;
import main.InterestCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
    private Calculator calc;
    InterestCalculator iCalcMock = mock(InterestCalculator.class);

    @BeforeEach
    public void setup(){
        //to use a test stub
        //calc = new Calculator(new InterestCalcStub());

        calc = new Calculator(iCalcMock);

    }

    @Test
    public void divisionWithoutZeroTest() throws DivisionByZeroException {
        double a = 5;
        double b = 10;

        double result = calc.division(a,b);

        Assertions.assertEquals(0.5, result);

    }

    @Test
    public void divisionByZeroTest() {
        double a = 5;
        double b = 0;
        DivisionByZeroException e = Assertions.assertThrows(DivisionByZeroException.class, ()->calc.division(a,b));

        Assertions.assertEquals(a, e.getA() );
        Assertions.assertEquals(b, e.getB());
        Assertions.assertEquals("You are trying to divide by zero", e.getMessage());
    }

    @Test
    public void ageTooSmallCalculateInterestTest(){
        //expected result = 0.05
        //test data = 5

        double actualResult = calc.calculateInterest(5, 0.34);

        Assertions.assertEquals(0.05, actualResult);
        verify(iCalcMock, Mockito.times(0)).getInterest(anyInt(), anyDouble());
    }

    @Test
    public void highCreditScoreCalculateInterestTest(){
        when(iCalcMock.getInterest(19, 1)).thenReturn(0.3);
        double expectedResult = 0.32;

        double actualResult = calc.calculateInterest(19, 1);

        Assertions.assertEquals(expectedResult, actualResult, 0.000001);
        // verify interraction with mock
        verify(iCalcMock, Mockito.times(1)).getInterest(19, 1);
    }





}
