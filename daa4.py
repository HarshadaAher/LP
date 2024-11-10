def knapsack(weights, values, capacity, n):
    # Create a DP table to store the maximum value for each subproblem
    dp = [[0 for _ in range(capacity + 1)] for _ in range(n + 1)]

    # Fill the DP table
    for i in range(n + 1):
        for w in range(capacity + 1):
            if i == 0 or w == 0:
                dp[i][w] = 0  # Base case: no items or zero capacity
            elif weights[i - 1] <= w:
                # If the current item can be included
                dp[i][w] = max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w])
            else:
                # If the current item cannot be included
                dp[i][w] = dp[i - 1][w]

    # The value in the bottom-right corner of the DP table is the maximum value
    return dp[n][capacity]

# Main function to take user input and run the algorithm
def main():
    # Take the number of items and the capacity of the knapsack
    n = int(input("Enter the number of items: "))
    capacity = int(input("Enter the capacity of the knapsack: "))

    weights = []
    values = []

    # Take input for weights and values of each item
    for i in range(n):
        print(f"Enter details for item {i + 1}:")
        weight = int(input(f"Weight of item {i + 1}: "))
        value = int(input(f"Value of item {i + 1}: "))
        weights.append(weight)
        values.append(value)

    # Solve the 0/1 Knapsack problem using dynamic programming
    max_value = knapsack(weights, values, capacity, n)
    print(f"The maximum value that can be obtained is: {max_value}")

if __name__ == "__main__":
    main()
