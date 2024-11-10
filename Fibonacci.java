import java.util.Scanner;

public class Fibonacci {

    // Recursive Fibonacci function with step count
    public static int fibonacciRecursive(int n, int[] stepCount) {
        stepCount[0]++;
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1, stepCount) + fibonacciRecursive(n - 2, stepCount);
    }

    /*  Iterative Fibonacci function with step count
    public static int fibonacciIterative(int n) {
        int stepCount = 0, a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            a = b;
            b = a + b;
            stepCount++;
        }
        return b;
    }
*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter position (n) for Fibonacci(n): ");
        int n = sc.nextInt();

        // Recursive Fibonacci
        int[] stepCountRecursive = {0};
        System.out.println("Recursive Fibonacci(" + n + ") = " + fibonacciRecursive(n, stepCountRecursive));
        System.out.println("Step count (recursive): " + stepCountRecursive[0]);

        // Iterative Fibonacci
        //System.out.println("Iterative Fibonacci(" + n + ") = " + fibonacciIterative(n));
        //System.out.println("Step count (iterative): " + (n - 1));
    }
}
