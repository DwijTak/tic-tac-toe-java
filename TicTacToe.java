import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();

    // UC3
    public static int getUserInput() {
        System.out.print("Enter a slot (1-9): ");
        return input.nextInt();
    }

    // UC4
    public static int[] getPosition(int slot) {
        return new int[]{(slot - 1) / 3, (slot - 1) % 3};
    }

    // UC5
    public static boolean isValidMove(char[][] board, int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
    }

    // UC6
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7
    public static void computerMove(char[][] board, char symbol) {
        while (true) {
            int slot = rand.nextInt(9) + 1;
            int[] pos = getPosition(slot);

            if (isValidMove(board, pos[0], pos[1])) {
                placeMove(board, pos[0], pos[1], symbol);
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // Check if board full (draw condition)
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '-')
                    return false;
        return true;
    }

    // Print board
    public static void printBoard(char[][] board) {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // Initialize board
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '-';

        // Toss
        boolean userTurn = rand.nextInt(2) == 0;

        char userSymbol = userTurn ? 'X' : 'O';
        char computerSymbol = userTurn ? 'O' : 'X';

        System.out.println(userTurn ? "User starts" : "Computer starts");

        // 🔥 UC8 GAME LOOP
        while (true) {

            printBoard(board);

            if (userTurn) {
                System.out.println("\nUser Turn");

                int slot = getUserInput();
                int[] pos = getPosition(slot);

                if (isValidMove(board, pos[0], pos[1])) {
                    placeMove(board, pos[0], pos[1], userSymbol);
                    userTurn = false; // switch turn
                } else {
                    System.out.println("Invalid move! Try again.");
                }

            } else {
                System.out.println("\nComputer Turn");

                computerMove(board, computerSymbol);
                userTurn = true; // switch turn
            }

            // Stop if board full (draw for now)
            if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("\nGame Draw!");
                break;
            }
        }
    }
}