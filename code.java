import java.util.Scanner;

public class code {
    static char[][] board=new char[3][3];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("=======================================");
        System.out.println("     Welcome to Tic Tac Toe Game!      ");
        System.out.println("=======================================");
        System.out.println("Instructions:");
        System.out.println("1. The game is for two players: X and O.");
        System.out.println("2. Players will take turns entering row and column numbers (0, 1, or 2).");
        System.out.println("3. Example: Entering '1 2' means row 1, column 2.");
        System.out.println("4. The first player uses 'X', and the second player uses 'O'.");
        System.out.println("Have fun!\n");

        boolean playagain=true;

        while (playagain) 
        {
            initializeboard();
            char curplayer = 'X';
            boolean gameend = false;

            while (!gameend) {
                printboard();
                System.out.println("Player " + curplayer + ", it's your turn.");
                int row, col;

                // Loop until a valid move is entered
                while (true) {
                    System.out.print("Enter row and column (0 1 2): ");
                    row = sc.nextInt();
                    col = sc.nextInt();

                    if (row < 0 || col < 0 || row > 2 || col > 2) {
                        System.out.println("Invalid position! Try again.");
                    } else if (board[row][col] != '-') {
                        System.out.println("Cell already taken! Try again.");
                    } else {
                        break; // Valid move
                    }
                }

                // Place the player's symbol
                board[row][col] = curplayer;

                // Check for a winner or draw
                if (checkwinner(curplayer)) {
                    printboard();
                    System.out.println("🎉 Player " + curplayer + " wins! 🎉");
                    gameend = true;
                } else if (isboardfull()) {
                    printboard();
                    System.out.println("🤝 It's a draw!");
                    gameend = true;
                } else {
                    // Switch player
                    curplayer = (curplayer == 'X') ? 'O' : 'X';
                }
            }

            // Ask to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = sc.next().toLowerCase();
            playagain = response.equals("yes");
        }

        System.out.println("Thank you for playing Tic Tac Toe! Goodbye! 👋");
        sc.close();
    }

    // Initialize the board with - (empty)
    public static void initializeboard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Print the board
    public static void printboard() {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if a player has won
    public static boolean checkwinner(char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;
            // Check columns
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player)
                return true;
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }

    // Check if the board is full (draw)
    public static boolean isboardfull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-')
                    return false;
            }
        }
        return true;
    }
}
