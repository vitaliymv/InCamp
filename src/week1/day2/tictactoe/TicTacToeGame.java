package week1.day2.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

    public static final String O = "O";
    public static final String X = "X";

    public static void initialArray(String[][] array, String[][] array2) {
        int data = 1;
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = String.valueOf(data);
                array2[i][j] = String.valueOf(data);
                data++;
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void replaceElement(String [][] array, int one, boolean turn) {
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i][j].equalsIgnoreCase(String.valueOf(one))) {
                    if(turn) {
                        array[i][j] = "X";
                    } else {
                        array[i][j] = "O";
                    }
                }
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean checkDiagonalX(String[][] array) {
        return checkDiagonal(array, X);
    }

    private static boolean checkDiagonal(String[][] array, String x) {
        boolean right = true;
        boolean left = true;
        for(int i = 0; i < array.length; i++) {
            right &= (array[i][i].equals(x));
            left &= (array[array.length - i - 1][i].equals(x));
        }
        return right || left;
    }

    public static boolean checkLinesX(String [][] array) {
        return checkLine(array, X);
    }

    private static boolean checkLine(String[][] array, String x) {
        boolean rows;
        boolean columns;
        for(int i = 0; i < array.length; i++) {
            columns = true;
            rows = true;
            for(int j = 0; j < array.length; j++) {
                columns &= array[i][j].equals(x);
                rows &= array[j][i].equals(x);
            }
            if (columns || rows) return true;
        }
        return false;
    }

    public static boolean checkDiagonalO(String[][] array) {
        return checkDiagonal(array, O);
    }

    public static boolean checkLinesO(String [][] array) {
        return checkLine(array, O);
    }

    public static boolean checkAllCell(String[][] array, String[][] array2) {
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++) {
                if(array[i][j].contentEquals(array2[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkWin(String[][] array, String[][] array2) {
        boolean state = true;
        if(checkDiagonalX(array) || checkLinesX(array)) {
            System.err.println("WIN X");
            state = false;
        } else if(checkDiagonalO(array) || checkLinesO(array)) {
            System.err.println("WIN O");
            state = false;
        } else if(!checkAllCell(array, array2)) {
            System.err.println("DRAW");
            state = false;
        }
        return state;
    }

    public static void checkTurn(boolean turn) {
        if (!turn) {
            System.out.print("Write number cell for turn ZERO: ");
        } else {
            System.out.print("Write number cell for turn CROSSES: ");
        }
    }

    public static boolean checkCellOnBusy(String[][] array, int one) {
        for (String[] strings : array) {
            for (int j = 0; j < array.length; j++) {
                if (strings[j].equalsIgnoreCase(String.valueOf(one))) {
                    if (strings[j].equalsIgnoreCase(X) || strings[j].equalsIgnoreCase(O)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void game(Scanner sc, int one, String[][] array, boolean turn, String[][] array2) {
        do {
            checkTurn(turn);
            one = sc.nextInt();
            if (one > 0 && one <= Math.pow(array.length, 2) && !checkCellOnBusy(array, one)) {
                replaceElement(array, one, turn);
                turn = !turn;
                checkWin(array, array2);
            } else {
                System.err.print("\n Please write number again: ");
            }
        } while (checkWin(array, array2));
    }
}
