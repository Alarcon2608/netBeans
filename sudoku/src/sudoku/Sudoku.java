/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sudoku;

 import java.util.Random;



    for i in range(9):
        if sudoku[row][i] == num or sudoku[i][col] == num:
            return False
    start_row, start_col = 3 * (row // 3), 3 * (col // 3)
    for i in range(3):
        for j in range(3):
            if sudoku[i + start_row][j + start_col] == num:
                return False
    return True

def solve_sudoku(sudoku):
    empty_cell = find_empty_cell(sudoku)
    if not empty_cell:
        return True
    row, col = empty_cell
    for num in range(1, 10):
        if is_valid_move(sudoku, row, col, num):
            sudoku[row][col] = num
            if solve_sudoku(sudoku):
                return True
            sudoku[row][col] = 0
    return False

def find_empty_cell(sudoku):
    for i in range(9):
        for j in range(9):
            if sudoku[i][j] == 0:
                return (i, j)
    return None

def generate_sudoku():
    sudoku = [[0 for _ in range(9)] for _ in range(9)]
    solve_sudoku(sudoku)
    return sudoku

