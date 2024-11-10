import heapq

# Huffman tree node
class Node:
    def __init__(self, freq, symbol, left=None, right=None):
        self.freq = freq  # Frequency of the symbol
        self.symbol = symbol  # Symbol (character)
        self.left = left  # Left child
        self.right = right  # Right child

    # Define the less-than method for priority queue (min-heap)
    def __lt__(self, other):
        return self.freq < other.freq

# Function to print the Huffman codes by traversing the Huffman Tree
def print_codes(node, code=''):
    # If it's a leaf node, print the character and its code
    if node.left is None and node.right is None:
        print(f"{node.symbol} -> {code}")
        return
    # Traverse the left and right children
    if node.left:
        print_codes(node.left, code + "0")
    if node.right:
        print_codes(node.right, code + "1")

# Function to build the Huffman Tree and generate codes
def huffman_encoding(symbols, frequencies):
    # Priority queue to store nodes of the Huffman Tree
    heap = []
    
    # Step 1: Create initial nodes for each symbol and add them to the heap
    for i in range(len(symbols)):
        heapq.heappush(heap, Node(frequencies[i], symbols[i]))
    
    # Step 2: Build the Huffman Tree by combining nodes with the lowest frequencies
    while len(heap) > 1:
        # Remove two nodes with the lowest frequency
        left = heapq.heappop(heap)
        right = heapq.heappop(heap)

        # Create a new parent node with combined frequency
        parent = Node(left.freq + right.freq, '-', left, right)

        # Add the new node back to the heap
        heapq.heappush(heap, parent)

    # Step 3: Print the Huffman codes by traversing the Huffman Tree
    root = heapq.heappop(heap)  # The last remaining node is the root
    print_codes(root)

# Main program to take user input and generate Huffman codes
if __name__ == "__main__":
    # Taking user input for characters and frequencies
    n = int(input("Enter the number of characters: "))
    
    symbols = []
    frequencies = []
    
    print("Enter characters and their frequencies:")
    for i in range(n):
        symbol = input(f"Character {i + 1}: ")
        symbols.append(symbol)
        freq = int(input(f"Frequency of {symbol}: "))
        frequencies.append(freq)

    # Build Huffman Tree and print codes
    huffman_encoding(symbols, frequencies)
