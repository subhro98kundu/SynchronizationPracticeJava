package exceptionhandlingmultithreading;

import exceptionhandlingmultithreading.constants.OperatorEnum;
import exceptions.OperationNotAllowedException;

public class Expression implements Runnable {
    private double a, b;
    private OperatorEnum operatorEnum;
    private char operator;
    public Expression(double a, double b, char operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
        setOperatorEnum(operator);
    }

    private void setOperatorEnum(char operator) throws OperationNotAllowedException {
        switch(operator){
            case '+':
                this.operatorEnum = OperatorEnum.ADD;
                break;
            case '-':
                this.operatorEnum = OperatorEnum.SUBSTRACT;
                break;
            case '*':
                this.operatorEnum = OperatorEnum.MULTIPLY;
                break;
            case '/':
                this.operatorEnum = OperatorEnum.DIVIDE;
                break;
            default:
                throw new OperationNotAllowedException("Operation not allowed: "+operator);
        }
    }

    private void evaluateExpression() throws ArithmeticException{
        Calculator calculator = new Calculator();
        System.out.print("Executing from thread: " + Thread.currentThread().getName() + " ---> " + a + " " + operator + " " + b + " = ");
        calculator.calculate(a, b, operatorEnum);
    }

    @Override
    public void run() throws ArithmeticException, OperationNotAllowedException {
        this.evaluateExpression(); // Any exceptions thrown here won't be caught in the main thread.
    }
}
