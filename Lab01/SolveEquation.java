import java.util.Scanner;
 
public class SolveEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
 
        do {
            System.out.println("Please choose your option:");
            System.out.println("1. Solve first-degree equation with one variable (ax + b = 0)");
            System.out.println("2. Solve system of first-degree equations with two variables");
            System.out.println("3. Solve second-degree equation with one variable (ax^2 + bx + c = 0)");
            System.out.println("0. Exit");
            option = scanner.nextInt();
 
            switch (option) {
                case 1:
                    solveLinearEquation(scanner);
                    break;
                case 2:
                    solveLinearSystem(scanner);
                    break;
                case 3:
                    solveQuadraticEquation(scanner);
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter option 0-3:");
            }
        } while (option != 0);
 
        scanner.close();
    }
 
    private static void solveLinearEquation(Scanner scanner) {
        System.out.println("Solving: ax + b = 0");
        System.out.print("Input a: ");
        double a = scanner.nextDouble();
        System.out.print("Input b: ");
        double b = scanner.nextDouble();
 
        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinitely many solutions.");
            } else {
                System.out.println("The equation has no solution.");
            }
        } else {
            double x = -b / a;
            System.out.println("x = " + x);
        }
    }
 
    private static void solveLinearSystem(Scanner scanner) {
        System.out.println("Solving:");
        System.out.println("a11*x1 + a12*x2 = b1");
        System.out.println("a21*x1 + a22*x2 = b2");
        
        System.out.print("Input a11: "); double a11 = scanner.nextDouble();
        System.out.print("Input a12: "); double a12 = scanner.nextDouble();
        System.out.print("Input b1: ");  double b1 = scanner.nextDouble();
        System.out.print("Input a21: "); double a21 = scanner.nextDouble();
        System.out.print("Input a22: "); double a22 = scanner.nextDouble();
        System.out.print("Input b2: ");  double b2 = scanner.nextDouble();
 
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;
 
        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("Result: The system has infinitely many solutions.");
            } else {
                System.out.println("Result: The system has no solution.");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("Result: x1 = " + x1 + ", x2 = " + x2);
        }
    }
 
    private static void solveQuadraticEquation(Scanner scanner) {
        System.out.println("Solving: ax^2 + bx + c = 0");
        System.out.print("Input a: ");
        double a = scanner.nextDouble();
        System.out.print("Input b: ");
        double b = scanner.nextDouble();
        System.out.print("Input c: ");
        double c = scanner.nextDouble();
 
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Result: The equation has infinitely many solutions.");
                } else {
                    System.out.println("Result: The equation has no solution.");
                }
            } else {
                System.out.println("Result: x = " + (-c / b));
            }
            return;
        }
 
        double delta = b * b - 4 * a * c;
 
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Result: The equation has two distinct roots:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("Result: The equation has a double root: x = " + x);
        } else {
            System.out.println("Result: The equation has no real root.");
        }
    }
}
 