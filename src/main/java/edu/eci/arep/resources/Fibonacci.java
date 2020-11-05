package edu.eci.arep.resources;

/**
 * Class that calculate Fibonacci number
 * @author Maria Hernandez
 */
public class Fibonacci {
    /**
     * Method that calculates Fibonacci's number
     * @param n
     * @return
     */
    public static int calculate(int n){
        if (n <= 1) {
            return n;
        } else {
            return calculate(n - 1) + calculate(n - 2);
        }
    }
}