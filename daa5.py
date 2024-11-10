def is_safe(board, row, col):
    # Check the column for other queens
    for i in range(row):
        if board[i][col] == 1:
            return False
    
    # Check upper-left diagonal
    for i, j in zip(range(row-1, -1, -1), range(col-1, -1, -1)):
        if board[i][j] == 1:
            return False
    
    # Check upper-right diagonal
    for i, j in zip(range(row-1, -1, -1), range(col+1, len(board))):
        if board[i][j] == 1:
            return False
    
    return True

def solve_n_queens(board, row):
    # If all queens are placed, return True
    if row >= len(board):
        return True
    
    for col in range(len(board)):
        # Check if the current position is safe for the queen
        if is_safe(board, row, col):
            board[row][col] = 1  # Place the queen
            
            # Recur to place the rest of the queens
            if solve_n_queens(board, row + 1):
                return True
            
            # If placing queen in current position doesn't lead to a solution, backtrack
            board[row][col] = 0  # Remove the queen (backtrack)
    
    return False

def print_board(board):
    for row in board:
        print(' '.join('Q' if x == 1 else '.' for x in row))
    print()

def main():
    # Initialize the board as a 8x8 matrix
    n = 8
    board = [[0 for _ in range(n)] for _ in range(n)]
    
    # Get the position of the first queen from the user
    row = int(input("Enter the row position (0-7) for the first queen: "))
    col = int(input("Enter the column position (0-7) for the first queen: "))
    
    # Place the first queen
    if not (0 <= row < n and 0 <= col < n):
        print("Invalid position for the first queen. Please enter values between 0 and 7.")
        return

    board[row][col] = 1

    # Now, solve the rest of the problem using backtracking
    if solve_n_queens(board, 0):
        print("Solution to the 8-Queens Problem:")
        print_board(board)
    else:
        print("No solution found!")

if __name__ == "__main__":
    main()
