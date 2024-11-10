import java.util.*;

class Item {
    double weight;
    double value;
    double valuePerWeight;

    // Constructor
    public Item(double weight, double value) {
        this.weight = weight;
        this.value = value;
        this.valuePerWeight = value / weight;  // value per weight
    }
}

public class FractionalKnapsack {

    // Function to solve the fractional knapsack problem
    public static double fractionalKnapsack(double capacity, Item[] items) {
        // Sort the items by value per weight in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.valuePerWeight, a.valuePerWeight));

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity == 0) {
                break;
            }

            // If the item can be fully taken
            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                // Take the fraction of the item
                totalValue += item.valuePerWeight * capacity;
                capacity = 0;
            }
        }

        return totalValue;
    }

    // Main function to take user input and run the algorithm
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take the number of items and the capacity of the knapsack
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        System.out.print("Enter the capacity of the knapsack: ");
        double capacity = scanner.nextDouble();

        Item[] items = new Item[n];

        // Take input for weight and value of each item
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for item " + (i + 1) + ":");
            System.out.print("Weight of item " + (i + 1) + ": ");
            double weight = scanner.nextDouble();
            System.out.print("Value of item " + (i + 1) + ": ");
            double value = scanner.nextDouble();
            items[i] = new Item(weight, value);
        }

        // Call the fractional knapsack function and print the result
        double maxValue = fractionalKnapsack(capacity, items);
        System.out.println("The maximum value in the knapsack is: " + maxValue);
        
        scanner.close();
    }
}
