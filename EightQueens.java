import java.util.Scanner;

public class EightQueens {
    
    // Function to check if it's safe to place a queen at board[row][col]
    public static boolean isSafe(int[][] board, int row, int col, int N) {
        // Check the column for other queens
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        
        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        
        return true;
    }
    
    // Function to solve the N-Queens problem using backtracking
    public static boolean solveNQueens(int[][] board, int row, int N) {
        // If all queens are placed
        if (row >= N) {
            return true;
        }
        
        // Try all columns for the current row
        for (int col = 0; col < N; col++) {
            // If it's safe to place the queen at (row, col)
            if (isSafe(board, row, col, N)) {
                board[row][col] = 1; // Place queen
                
                // Recur to place the rest of the queens
                if (solveNQueens(board, row + 1, N)) {
                    return true;
                }
                
                // If placing queen doesn't lead to a solution, backtrack
                board[row][col] = 0; // Remove queen (backtrack)
            }
        }
        
        return false; // If no place is found, return false
    }
    
    // Function to print the board
    public static void printBoard(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = 8; // Size of the chessboard (8x8)
        int[][] board = new int[N][N];
        
        // Get the position of the first queen from the user
        System.out.print("Enter the row position (0-7) for the first queen: ");
        int row = scanner.nextInt();
        System.out.print("Enter the column position (0-7) for the first queen: ");
        int col = scanner.nextInt();
        
        if (row < 0 || row >= N || col < 0 || col >= N) {
            System.out.println("Invalid position. Please enter values between 0 and 7.");
            return;
        }
        
        // Place the first queen
        board[row][col] = 1;
        
        // Solve the rest of the problem using backtracking
        if (solveNQueens(board, 0, N)) {
            System.out.println("Solution to the 8-Queens problem:");
            printBoard(board, N);
        } else {
            System.out.println("No solution found.");
        }
        
        scanner.close();
    }
}
