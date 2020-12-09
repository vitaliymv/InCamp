package week1.day2.tictactoe;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Write size your map: ");
        int size = sc.nextInt();
        String[][] array = new String[size][size];
        String[][] array2 = new String[size][size];
        boolean turn = false;
        int one = 0;
        TicTacToeGame.initialArray(array, array2);
        TicTacToeGame.game(sc, one, array, turn, array2);
        sc.close();
    }
}
