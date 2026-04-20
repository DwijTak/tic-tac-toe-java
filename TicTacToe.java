import java.util.Random;

public class TicTacToe {

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // UC1: Initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // UC2: Toss logic
        Random rand = new Random();

        int toss = rand.nextInt(2); // 0 or 1

        char userSymbol, computerSymbol;
        boolean userTurn;

        if (toss == 0) {
            userSymbol = 'X';
            computerSymbol = 'O';
            userTurn = true;
            System.out.println("User won the toss!");
        } else {
            userSymbol = 'O';
            computerSymbol = 'X';
            userTurn = false;
            System.out.println("Computer won the toss!");
        }

        System.out.println("User Symbol: " + userSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);

        if (userTurn) {
            System.out.println("User will play first.");
        } else {
            System.out.println("Computer will play first.");
        }

        // Display board
        System.out.println("\nTic Tac Toe Board:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}