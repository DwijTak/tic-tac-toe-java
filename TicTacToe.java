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
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // UC5
    public static boolean isValidMove(char[][] board, int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-');
    }

    // UC6
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7: Computer move
    public static void computerMove(char[][] board, char symbol) {

        int slot, row, col;

        while (true) {

            slot = rand.nextInt(9) + 1; // 1–9
            int[] pos = getPosition(slot);
            row = pos[0];
            col = pos[1];

            if (isValidMove(board, row, col)) {
                placeMove(board, row, col, symbol);
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // Print board
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
        boolean userTurn = rand.nextInt(2) == 0;

        char userSymbol = userTurn ? 'X' : 'O';
        char computerSymbol = userTurn ? 'O' : 'X';

        System.out.println(userTurn ? "User starts" : "Computer starts");

        printBoard(board);

        // User move
        int slot = getUserInput();
        int[] pos = getPosition(slot);

        if (isValidMove(board, pos[0], pos[1])) {
            placeMove(board, pos[0], pos[1], userSymbol);
        }

        printBoard(board);

        // Computer move (UC7)
        computerMove(board, computerSymbol);

        printBoard(board);
    }
}