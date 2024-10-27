package exceptionhandlingmultithreading;

import exceptionhandlingmultithreading.constants.OperatorEnum;
import exceptions.OperationNotAllowedException;

public class Calculator {
    private double add(double a, double b) {
        return a+b;
    }
    private double substract(double a, double b) {
        return a-b;
    }
    private double multiply(double a, double b) {
        return a*b;
    }
    private double divide(double a, double b) throws ArithmeticException {
        if (b == 0) throw new ArithmeticException("Division by zero not allowed.");
        return a/b;
    }
    public void calculate(double a,
                            double b,
                            char operator) throws ArithmeticException, OperationNotAllowedException {
        double ans;
        switch(operator){
            case '+':
                ans = add(a,b);
                break;
            case '-':
                ans = substract(a,b);
                break;
            case '*':
                ans = multiply(a,b);
                break;
            case '/':
                ans = divide(a,b);
                break;
            default: throw new OperationNotAllowedException("Operation not allowed");
        }
        System.out.println(ans);
    }
}
