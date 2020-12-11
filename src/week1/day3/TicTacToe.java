package week1.day3;

import java.util.Scanner;

public class TicTacToe {

    public static final int GAME_FIELD_SIZE = 3;
    public static final char X = '\u0058';
    public static final char Z = '\u004F';
    public static final int MAX_NUMBER_OF_MOVES = 9;
    public boolean TURN = true;
    public int AMOUNT = 0;

    public static class Table {
        public int POSITION_X = 0;
        public int POSITION_Y = 0;
        public char[][] MAP = new char[GAME_FIELD_SIZE][GAME_FIELD_SIZE];

        public Table() {
        }

        public int getPositionX() {
            return POSITION_X;
        }

        public void setPositionX(int positionX) {
            POSITION_X = positionX;
        }

        public int getPositionY() {
            return POSITION_Y;
        }

        public void setPositionY(int positionY) {
            POSITION_Y = positionY;
        }

        public char[][] getMAP() {
            return MAP;
        }

        public void setMAP(char[][] MAP) {
            this.MAP = MAP;
        }
    }

    Table table = new Table();

    public void initialMap() {
        for (int i = 0; i < GAME_FIELD_SIZE; i++) {
            for (int j = 0; j < GAME_FIELD_SIZE; j++) {
                table.MAP[i][j] = '_';
            }
        }
        table.setMAP(table.MAP);
    }

    public void printMap() {
        for (int i = 0; i < GAME_FIELD_SIZE; i++) {
            for (int j = 0; j < GAME_FIELD_SIZE; j++) {
                System.out.print(table.getMAP()[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void replaceCell() {
        Scanner sc = new Scanner(System.in);
        table.POSITION_X = sc.nextInt();
        table.POSITION_Y = sc.nextInt();
        table.MAP[table.POSITION_X][table.POSITION_Y] = checkTurn();
        table.setMAP(table.MAP);
        printMap();
    }

    public char checkTurn() {
        if(TURN) {
            table.MAP[table.POSITION_X][table.POSITION_Y] = X;
            TURN = false;
            return X;
        } else {
            TURN = true;
            return Z;
        }
    }

    public void game() {
        initialMap();
        printMap();
        do {
            replaceCell();
            checkWin();
        } while (AMOUNT++ < MAX_NUMBER_OF_MOVES - 1);
    }

    public void checkWin() {
        if(checkLinesX() || checkDiagonalX()) {
            System.out.println("Win X");
            System.exit(0);
        } else if (checkLinesZ() || checkDiagonalZ()) {
            System.out.println("Win O");
            System.exit(0);
        } else if (AMOUNT == MAX_NUMBER_OF_MOVES - 1) {
            System.out.println("DRAW");
            System.exit(0);
        }
    }

    public boolean checkDiagonalX() {
        return checkDiagonals(X);
    }

    public boolean checkDiagonalZ() {
        return checkDiagonals(Z);
    }

    public boolean checkDiagonals(char x) {
        boolean right = true;
        boolean left = true;
        for(int i = 0; i < GAME_FIELD_SIZE; i++) {
            right &= (table.MAP[i][i] == x);
            left &= (table.MAP[GAME_FIELD_SIZE - i - 1][i] == x);
        }
        if(right || left) {
            return true;
        }
        return false;
    }

    public boolean checkLinesZ() {
        return checkLines(Z);
    }

    public boolean checkLinesX() {
        return checkLines(X);
    }

    private boolean checkLines(char x) {
        boolean rows;
        boolean columns;
        for(int i = 0; i < GAME_FIELD_SIZE; i++) {
            columns = true;
            rows = true;
            for(int j = 0; j < GAME_FIELD_SIZE; j++) {
                columns &= table.MAP[i][j] == x;
                rows &= table.MAP[j][i] == x;
            }
            if (columns || rows) return true;
        }
        return false;
    }

}
