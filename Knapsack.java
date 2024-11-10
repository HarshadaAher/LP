import java.util.Scanner;

public class Knapsack {

    // Function to solve the 0/1 Knapsack problem using dynamic programming
    public static int knapsack(int[] weights, int[] values, int capacity, int n) {
        // Create a DP table to store the maximum value for each subproblem
        int[][] dp = new int[n + 1][capacity + 1];

        // Fill the DP table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // Base case: no items or zero capacity
                } else if (weights[i - 1] <= w) {
                    // If the current item can be included
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    // If the current item cannot be included
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // The value in the bottom-right corner of the DP table is the maximum value
        return dp[n][capacity];
    }

    // Main function to take user input and run the algorithm
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take the number of items and the capacity of the knapsack
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        // Take input for weights and values of each item
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for item " + (i + 1) + ":");
            System.out.print("Weight of item " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
            System.out.print("Value of item " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
        }

        // Solve the 0/1 Knapsack problem using dynamic programming
        int maxValue = knapsack(weights, values, capacity, n);
        System.out.println("The maximum value that can be obtained is: " + maxValue);

        scanner.close();
    }
}
