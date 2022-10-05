package animals;

public interface Steerable {

    void steerLeft(int degree);
    void steerRight(int degree);

    default int count(int a, int b){
        return a+b;
    }
}
