package Assisment1;

import java.util.Scanner;

class BasicMathFunctions {
    private static int add(int a, int b) {
        return a + b;
    }
	
    private static int subtract(int a, int b) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static int divide(int a, int b) {
        return a / b;
    }

    private static int remainder(int a, int b) {
        return a % b;
    }

    private static int square(int a) {
        return a * a;
    }

    private static int cube(int a) {
        return a * a * a;
    }

    private static int absolute(int a) {
        return Math.abs(a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first and second number: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println("Add = " + add(num1, num2));
        System.out.println("Substract = " + subtract(num1, num2));
        System.out.println("Multiply = " + multiply(num1, num2));
        System.out.println("Divide = " + divide(num1, num2));
        System.out.println("Reminder = " + remainder(num1, num2));
        System.out.println("Square of numbers = " + square(num1) + ", " + square(num2));
        System.out.println("Cube of numbers = " + cube(num1) + " " + cube(num2));
        System.out.println("Absolute of numbers = " + absolute(num1) + " " + absolute(num2));
    }
}
