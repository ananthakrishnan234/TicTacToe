import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        char board [][] = new char[3][3]; // setting up the board

        // filling the board with empty spaces initially
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char currPlayer = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while(!gameOver) {
            printBoard(board);
            System.out.println("Player " + currPlayer + " enter row and column:");

            int row = sc.nextInt(); // input row
            int col = sc.nextInt(); // input col

            // basic bounds checking
            if(row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid input! Try values between 0 and 2.");
                continue;
            }

            // if that place is empty
            if(board[row][col] == ' ') {
                board[row][col] = currPlayer;

                gameOver = haveWon(board, currPlayer);
                if(gameOver) {
                    printBoard(board);
                    System.out.println("Player " + currPlayer + " wins!");
                } else {
                    // switch player
                    if(currPlayer == 'X') {
                        currPlayer = 'O';
                    } else {
                        currPlayer = 'X';
                    }
                }
            } else {
                System.out.println("That cell is already filled. Try again.");
            }
        }

        sc.close(); // good practice to close Scanner
    }

    // function to check if player has won
    public static boolean haveWon(char board[][], char player) {
        // rows
        for(int row = 0; row < board.length; row++) {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // columns
        for(int col = 0; col < board[0].length; col++) {
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // diagonals
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if(board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    // function to print the board
    public static void printBoard(char[][] board) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
                if(col < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if(row < 2) {
                System.out.println("--+---+--");
            }
        }

    }
}
