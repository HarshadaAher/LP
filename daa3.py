# Item class to store weight, value, and value per weight unit
class Item:
    def __init__(self, weight, value):
        self.weight = weight
        self.value = value
        self.value_per_weight = value / weight  # Value per unit weight

# Function to solve the Fractional Knapsack problem
def fractional_knapsack(capacity, items):
    # Sort items by value per weight unit in descending order
    items.sort(key=lambda x: x.value_per_weight, reverse=True)

    total_value = 0  # To store the total value of the knapsack

    for item in items:
        if capacity <= 0:
            break
        
        # If the item can be fully taken
        if item.weight <= capacity:
            total_value += item.value
            capacity -= item.weight
        else:
            # Take the fraction of the item
            total_value += item.value_per_weight * capacity
            capacity = 0  # The knapsack is full

    return total_value

# Main function to take user input
if __name__ == "__main__":
    # Taking input for the number of items and knapsack capacity
    n = int(input("Enter the number of items: "))
    capacity = float(input("Enter the capacity of the knapsack: "))

    items = []

    # Taking input for the weights and values of the items
    for i in range(n):
        print(f"Enter details for item {i+1}:")
        weight = float(input(f"Weight of item {i+1}: "))
        value = float(input(f"Value of item {i+1}: "))
        items.append(Item(weight, value))

    # Solving the Fractional Knapsack problem and printing the result
    max_value = fractional_knapsack(capacity, items)
    print(f"The maximum value in the knapsack is: {max_value}")
