import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static Scanner input = new Scanner(System.in);

    // UC3
    public static int getUserInput() {
        System.out.print("Enter a slot (1-9): ");
        return input.nextInt();
    }

    // UC4
    public static int[] getPosition(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // UC5
    public static boolean isValidMove(char[][] board, int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
    }

    // UC6: Place move
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Helper to print board
    public static void printBoard(char[][] board) {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // UC1
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '-';

        // UC2
        Random rand = new Random();
        boolean userTurn = rand.nextInt(2) == 0;

        char userSymbol = userTurn ? 'X' : 'O';

        System.out.println(userTurn ? "User starts" : "Computer starts");

        printBoard(board);

        // UC3 + UC4
        int slot = getUserInput();
        int[] pos = getPosition(slot);
        int row = pos[0];
        int col = pos[1];

        // UC5 + UC6
        if (isValidMove(board, row, col)) {

            placeMove(board, row, col, userSymbol);

            System.out.println("Move placed ✅");

        } else {
            System.out.println("Invalid move ❌");
        }

        // Show updated board
        printBoard(board);
    }
}