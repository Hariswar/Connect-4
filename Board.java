class Board {
  // Board is a 2D array of type char that represents the game board.
    private char[][] board;           
    private char currentPlayer;       
    private final int ROWS = 7;       
    private final int COLS = 8;       

    public Board() {
      // A constructor that initializes the board by creating a new 2D array of size ROWS and COLS empty spaces. 
      board = new char[ROWS][COLS]; 
        currentPlayer = 'X';         
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '-';  
              // fill the board with empty spaces
            }
        }
    }

    public char getCurrentPlayer() {
      // returns the current player
        return currentPlayer;  
    }

    public void changePlayer() {
        // change the current player from 'X' to 'O' or vice versa
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    public boolean isValidMove(int col) {
        // checks if a move to a specific column is valid
        if (col >=  1 && col < COLS) {
            // checks if the column is within the boundaries of the board
            for (int i = ROWS - 1; i >= 0; i--) {
                if (board[i][col] == '-') {
                    // if there is an empty space in the column, the move is valid
                    return true;
                }
            }
        }
        // if the column is not within the boundaries of the board or if it's full, the move is invalid
        return false;
    }

    public void dropPiece(int col) {
        // drops a piece into the specified column for the current player
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][col] == '-') {
                board[i][col] = currentPlayer;
                break;
            }
        }
    }

    public boolean checkForWin() {
        // checks if the current player has won the game
        // check for horizontal win
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                // check if four pieces in a row are equal to the current player
                if (board[i][j] == currentPlayer && board[i][j + 1] == currentPlayer && board[i][j + 2] == currentPlayer && board[i][j + 3] == currentPlayer) {
                    return true;
                }
            }
        }
      // check for vertical win
        for (int i = 0; i < ROWS - 3; i++) {
          for (int j = 0; j < COLS; j++) {
            if (board[i][j] == currentPlayer && board[i + 1][j] == currentPlayer && board[i + 2][j] == currentPlayer && board[i + 3][j] == currentPlayer) {
                return true;
            }
        }
    }
      // Check for a win in a downward diagonal direction
    for (int i = 0; i < ROWS - 3; i++) {
        for (int j = 0; j < COLS - 3; j++) {
            if (board[i][j] == currentPlayer && board[i + 1][j + 1] == currentPlayer && board[i + 2][j + 2] == currentPlayer && board[i + 3][j + 3] == currentPlayer) {
                return true;
            }
        }
    }
    for (int i = 3; i < ROWS; i++) {
        for (int j = 0; j < COLS - 3; j++) {
            if (board[i][j] == currentPlayer && board[i - 1][j + 1] == currentPlayer && board[i - 2][j + 2] == currentPlayer && board[i - 3][j + 3] == currentPlayer) {
                return true;
            }
        }
    }
    return false;
}
  // Check if the board is full
public boolean isBoardFull() {
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS; j++) {
            if (board[i][j] == '-') {
                return false;
            }
        }
    }
    return true;
}
  // Display the board
public void displayBoard() {
    for (int i = 1; i < ROWS; i++) {
        System.out.print("|");
        for (int j = 1; j < COLS; j++) {
            System.out.print(board[i][j] + "|");
        }
        System.out.println();
    }
    System.out.println("---------------");
}
}