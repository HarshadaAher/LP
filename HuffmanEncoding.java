import java.util.PriorityQueue;
import java.util.Scanner;

// Huffman tree node
class Node {
    int freq; // Frequency of the symbol
    char symbol; // Symbol (character)
    Node left; // Left child
    Node right; // Right child

    // Constructor for leaf node
    Node(int freq, char symbol) {
        this.freq = freq;
        this.symbol = symbol;
        this.left = null;
        this.right = null;
    }

    // Constructor for internal node
    Node(int freq, Node left, Node right) {
        this.freq = freq;
        this.symbol = '-'; // Internal nodes don't represent a character
        this.left = left;
        this.right = right;
    }
}

// Comparator for priority queue based on frequency
class NodeComparator implements java.util.Comparator<Node> {
    public int compare(Node n1, Node n2) {
        return n1.freq - n2.freq;
    }
}

public class HuffmanEncoding {

    // Function to print the Huffman codes by traversing the Huffman Tree
    public static void printCodes(Node root, String code) {
        // If it's a leaf node, print the character and its code
        if (root.left == null && root.right == null) {
            System.out.println(root.symbol + " -> " + code);
            return;
        }
        // Traverse the left and right children
        if (root.left != null) printCodes(root.left, code + "0");
        if (root.right != null) printCodes(root.right, code + "1");
    }

    // Function to build the Huffman Tree and generate codes
    public static void huffmanEncoding(char[] symbols, int[] frequencies) {
        // Priority queue to store nodes of the Huffman Tree
        PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());

        // Step 1: Create initial nodes for each symbol and add them to the queue
        for (int i = 0; i < symbols.length; i++) {
            queue.add(new Node(frequencies[i], symbols[i]));
        }

        // Step 2: Build the Huffman Tree by combining nodes with the lowest frequencies
        while (queue.size() > 1) {
            // Remove two nodes with the lowest frequency
            Node left = queue.poll();
            Node right = queue.poll();

            // Create a new parent node with combined frequency
            Node parent = new Node(left.freq + right.freq, left, right);

            // Add the new node back to the queue
            queue.add(parent);
        }

        // Step 3: Print the Huffman codes by traversing the Huffman Tree
        Node root = queue.poll(); // The last remaining node is the root
        printCodes(root, "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for characters and frequencies
        System.out.print("Enter the number of characters: ");
        int n = scanner.nextInt();

        char[] symbols = new char[n];
        int[] frequencies = new int[n];

        System.out.println("Enter characters and their frequencies:");
        for (int i = 0; i < n; i++) {
            System.out.print("Character " + (i + 1) + ": ");
            symbols[i] = scanner.next().charAt(0);

            System.out.print("Frequency of " + symbols[i] + ": ");
            frequencies[i] = scanner.nextInt();
        }

        // Build Huffman Tree and print codes
        huffmanEncoding(symbols, frequencies);

        scanner.close();
    }
}
