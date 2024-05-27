/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package borrador;

import java.util.Random;

public class borrador {
    private static final int tamaño = 9;
    private int[][] board;
    private Random random;

    public borrador() {
        board = new int[tamaño][tamaño];
        random = new Random();
    }

    public void generateBoard() {
        fillBoard(0, 0);
        removeNumbers();
    }

    private boolean fillBoard(int row, int col) {
        if (row == tamaño) {
            return true;
        }

        if (col == tamaño) {
            return fillBoard(row + 1, 0);
        }

        for (int num = 1; num <= tamaño; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;
                if (fillBoard(row, col + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int row, int col, int num) {
        for (int i = 0; i < tamaño; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private void removeNumbers() {
        int emptyCells = tamaño * tamaño * 2 / 3;
        while (emptyCells > 0) {
            int row = random.nextInt(tamaño);
            int col = random.nextInt(tamaño);
            if (board[row][col] != 0) {
                board[row][col] = 0;
                emptyCells--;
            }
        }
    }

    public void solveBoard() {
        if (solve(0, 0)) {
            System.out.println("Solucion encontrada:");
            printBoard();
        } else {
            System.out.println("No hay solucion.");
        }
    }

    private boolean solve(int row, int col) {
        if (row == tamaño) {
            return true;
        }

        if (col == tamaño) {
            return solve(row + 1, 0);
        }

        if (board[row][col] != 0) {
            return solve(row, col + 1);
        }

        for (int num = 1; num <= tamaño; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;
                if (solve(row, col + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }

        return false;
    }

    public void printBoard() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        borrador sudoku = new borrador();
        sudoku.generateBoard();
        System.out.println("Tablero generado:");
        sudoku.printBoard();
        sudoku.solveBoard();
    }
}