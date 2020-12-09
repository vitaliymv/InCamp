package week1.day2.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

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
                System.out.print(array[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static boolean checkDiagonalX(String[][] array) {
        boolean right = true;
        boolean left = true;
        for(int i = 0; i < array.length; i++) {
            right &= (array[i][i] == "X");
            left &= (array[array.length - i - 1][i] == "X");
        }
        if(right || left) {
            return true;
        }
        return false;

    }

    public static boolean checkLinesX(String [][] array) {
        boolean rows;
        boolean columns;
        for(int i = 0; i < array.length; i++) {
            columns = true;
            rows = true;
            for(int j = 0; j < array.length; j++) {
                columns &= array[i][j] == "X";
                rows &= array[j][i] == "X";
            }
            if (columns || rows) return true;
        }
        return false;
    }

    public static boolean checkDiagonalO(String[][] array) {
        boolean right = true;
        boolean left = true;
        for(int i = 0; i < array.length; i++) {
            right &= (array[i][i] == "O");
            left &= (array[array.length - i - 1][i] == "O");
        }
        if(right || left) return true;
        return false;

    }

    public static boolean checkLinesO(String [][] array) {
        boolean rows;
        boolean columns;
        for(int i = 0; i < array.length; i++) {
            columns = true;
            rows = true;
            for(int j = 0; j < array.length; j++) {
                columns &= array[i][j] == "O";
                rows &= array[j][i] == "O";
            }
            if (columns || rows) return true;
        }
        return false;
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
            System.out.println("WIN X");
            state = false;
        } else if(checkDiagonalO(array) || checkLinesO(array)) {
            System.out.println("WIN O");
            state = false;
        } else if(!checkAllCell(array, array2)) {
            System.out.println("DRAW");
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
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++) {
                if(array[i][j].equalsIgnoreCase(String.valueOf(one))) {
                    if(array[i][j].equalsIgnoreCase("X") || array[i][j].equalsIgnoreCase("O")) {
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
                System.out.print("Please write number again: ");
            }
        } while (checkWin(array, array2));
    }
}
