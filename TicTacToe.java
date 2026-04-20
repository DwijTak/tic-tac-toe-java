import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    // UC3: Method to get user input
    public static int getUserInput() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a slot (1-9): ");
        int slot = input.nextInt();

        return slot;
    }

    public static void main(String[] args) {

        char[][] board = new char[3][3];

        // UC1: Initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // UC2: Toss
        Random rand = new Random();
        int toss = rand.nextInt(2);

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

        // Display board
        System.out.println("\nTic Tac Toe Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        // UC3: Take input
        int userSlot = getUserInput();

        System.out.println("You selected slot: " + userSlot);
    }
}