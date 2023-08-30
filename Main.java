// Main class
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Connect 4 Game!");
          // Ask for player 1's name
        System.out.println("What is your name player 1?");
        String player1 = sc.nextLine();
      // Ask for player 2's name
        System.out.println("What is your name player 2?"); 
        String player2 = sc.nextLine();
      // Initialize variable to keep track of current player
        String personPlaying = "";
      // Create new Board object
        Board board = new Board();

       // Game loop
      //The loop continues until either a player wins the game or the board is full and the game ends in a draw. 
        while (!board.checkForWin() && !board.isBoardFull()) {
            // Set current player
            if( board.getCurrentPlayer() == 'X')
                personPlaying = player1;
            else
              personPlaying = player2;
          // Display current state of board
            System.out.println("Current board: ");
            board.displayBoard();

            // Tells current player to choose a column
            System.out.print(personPlaying + " = "+board.getCurrentPlayer() + ", choose your column(1-7): ");
            int col = sc.nextInt();

            // Validate player's move to ensure it is a valid move. 
            while (!board.isValidMove(col)) {
                System.out.print("Column full. Choose another: ");
                col = sc.nextInt();
            }
          // Drop piece in chosen column
            board.dropPiece(col);
          // Change current player
            board.changePlayer();
        }
      // Check for draw or winner
        if (board.isBoardFull() && !board.checkForWin()) {
            System.out.println("Draw game.");
        } else {
            System.out.println(personPlaying + " lost!");
        }
    }
}