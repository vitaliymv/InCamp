package week1.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static week1.day3.TicTacToe.GAME_FIELD_SIZE;
import static week1.day3.TicTacToe.X;

class TicTacToeTest {

    TicTacToe.Table table = new TicTacToe.Table();
    @Test
    void initialMap() {
        for (int i = 0; i < GAME_FIELD_SIZE; i++) {
            for (int j = 0; j < GAME_FIELD_SIZE; j++) {
                table.MAP[i][j] = '_';
            }
        }
        table.setMAP(table.MAP);
        char[][] testMap = {{'_', '_', '_'},
                            {'_', '_', '_'},
                            {'_', '_', '_'}};
        assertArrayEquals(testMap, table.getMAP());
    }

    @Test
    void replaceCell() {
        char[][] testMap = {{'X', 'X', 'X'},
                            {'X', 'X', 'X'},
                            {'X', 'X', 'X'}};
        table.MAP[0][0] = X;
        table.setMAP(table.MAP);
        assertArrayEquals(testMap, table.getMAP());
    }

    @Test
    void checkTurn() {
    }

    @Test
    void game() {
    }

    @Test
    void checkWin() {
    }

    @Test
    void checkDiagonalX() {
    }

    @Test
    void checkDiagonalZ() {
    }

    @Test
    void checkDiagonals() {
    }

    @Test
    void checkLinesZ() {
    }

    @Test
    void checkLinesX() {
    }
}