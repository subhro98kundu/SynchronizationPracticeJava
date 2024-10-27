package exceptionhandlingmultithreading;

import com.sun.media.sound.InvalidFormatException;
import exceptionhandlingmultithreading.constants.OperatorEnum;
import exceptions.FormatNotSupportedException;
import exceptions.OperationNotAllowedException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            double a, b;
            char op;
            Scanner sc = new Scanner(System.in);
            System.out.println("-------Enter expression in format: a + b (Spaces must between each operator and operand)-------");
            a = sc.nextDouble();
            op = sc.next().trim().charAt(0);
            if(op == ' ') throw new IOException("Invalid Input format");
            b = sc.nextDouble();
            Calculator calculator = new Calculator();
            System.out.print(a + " " + op + " " + b + " = ");
            calculator.calculate(a,b,op);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ArithmeticException | OperationNotAllowedException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
