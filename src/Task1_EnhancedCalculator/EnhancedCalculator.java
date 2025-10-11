package Task1_EnhancedCalculator;

import java.util.Scanner;
import java.text.DecimalFormat;

public class EnhancedCalculator {

    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("#.##");
    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            showMainMenu();
            int choice = getIntInput("Choose an option: ");

            switch (choice) {
                case 1:
                    arithmeticMenu();
                    break;
                case 2:
                    scientificMenu();
                    break;
                case 3:
                    conversionMenu();
                    break;
                case 0:
                    System.out.println("Exiting calculator. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void showMainMenu() {
        System.out.println("\n=== Enhanced Calculator ===");
        System.out.println("1. Arithmetic Operations");
        System.out.println("2. Scientific Operations");
        System.out.println("3. Unit Conversions");
        System.out.println("0. Exit");
    }

    static void arithmeticMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n--- Arithmetic Operations ---");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("0. Back");

            int choice = getIntInput("Choose an operation: ");
            double a, b;

            switch (choice) {
                case 1:
                    a = getDoubleInput("Enter first number: ");
                    b = getDoubleInput("Enter second number: ");
                    System.out.println("Result: " + df.format(a + b));
                    break;
                case 2:
                    a = getDoubleInput("Enter first number: ");
                    b = getDoubleInput("Enter second number: ");
                    System.out.println("Result: " + df.format(a - b));
                    break;
                case 3:
                    a = getDoubleInput("Enter first number: ");
                    b = getDoubleInput("Enter second number: ");
                    System.out.println("Result: " + df.format(a * b));
                    break;
                case 4:
                    a = getDoubleInput("Enter first number: ");
                    b = getDoubleInput("Enter second number: ");
                    if (b != 0) {
                        System.out.println("Result: " + df.format(a / b));
                    } else {
                        System.out.println("Error: Division by zero!");
                    }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    static void scientificMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n--- Scientific Operations ---");
            System.out.println("1. Square root");
            System.out.println("2. Power (a^b)");
            System.out.println("0. Back");

            int choice = getIntInput("Choose an operation: ");
            double a, b;

            switch (choice) {
                case 1:
                    a = getDoubleInput("Enter number: ");
                    if (a >= 0) {
                        System.out.println("Result: " + df.format(Math.sqrt(a)));
                    } else {
                        System.out.println("Error: Negative number!");
                    }
                    break;
                case 2:
                    a = getDoubleInput("Enter base: ");
                    b = getDoubleInput("Enter exponent: ");
                    System.out.println("Result: " + df.format(Math.pow(a, b)));
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    static void conversionMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n--- Unit Conversions ---");
            System.out.println("1. Temperature (Celsius ↔ Fahrenheit)");
            System.out.println("2. Currency (INR ↔ USD)");
            System.out.println("0. Back");

            int choice = getIntInput("Choose conversion: ");
            double value;

            switch (choice) {
                case 1:
                    System.out.println("1. Celsius → Fahrenheit");
                    System.out.println("2. Fahrenheit → Celsius");
                    int tempChoice = getIntInput("Choose option: ");
                    if (tempChoice == 1) {
                        value = getDoubleInput("Enter temperature in Celsius: ");
                        double fahrenheit = (value * 9 / 5) + 32;
                        System.out.println(df.format(value) + "°C = " + df.format(fahrenheit) + "°F");
                    } else if (tempChoice == 2) {
                        value = getDoubleInput("Enter temperature in Fahrenheit: ");
                        double celsius = (value - 32) * 5 / 9;
                        System.out.println(df.format(value) + "°F = " + df.format(celsius) + "°C");
                    } else {
                        System.out.println("Invalid option!");
                    }
                    break;
                case 2:
                    System.out.println("1. INR → USD");
                    System.out.println("2. USD → INR");
                    int currencyChoice = getIntInput("Choose option: ");
                    if (currencyChoice == 1) {
                        value = getDoubleInput("Enter amount in INR: ");
                        double usd = value / 83;
                        System.out.println(df.format(value) + " INR = " + df.format(usd) + " USD");
                    } else if (currencyChoice == 2) {
                        value = getDoubleInput("Enter amount in USD: ");
                        double inr = value * 83;
                        System.out.println(df.format(value) + " USD = " + df.format(inr) + " INR");
                    } else {
                        System.out.println("Invalid option!");
                    }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    static int getIntInput(String msg) {
        System.out.print(msg);
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    static double getDoubleInput(String msg) {
        System.out.print(msg);
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input. Enter a number: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}
