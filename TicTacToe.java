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

    // UC5: Validate move
    public static boolean isValidMove(char[][] board, int row, int col) {

        // Check bounds
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // Check if cell is empty
        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // UC1
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // UC2
        Random rand = new Random();
        boolean userTurn = rand.nextInt(2) == 0;

        char userSymbol = userTurn ? 'X' : 'O';

        System.out.println(userTurn ? "User starts" : "Computer starts");

        // Display board
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        // UC3 + UC4
        int slot = getUserInput();
        int[] pos = getPosition(slot);
        int row = pos[0];
        int col = pos[1];

        // UC5 validation
        if (isValidMove(board, row, col)) {
            System.out.println("Valid move ✅");
        } else {
            System.out.println("Invalid move ❌");
        }
    }
}