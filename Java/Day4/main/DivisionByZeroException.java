package main;

public class DivisionByZeroException extends Exception{

    private double a,b;
    public DivisionByZeroException(String message, double a, double b){
        super(message);
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }
}
