package com.javaprojects.DynamicProgramming.Controller;

/*
Write a program to solve a Sudoku puzzle by filling the empty cells.
A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Example 1:
Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:
Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.

Requirements:
search space: (1-9) - every cell has a 1-9 options to put a number in, and this is also where we will run our recursion as well.
recursive function: takes in a number and check to see if that number would violate the conditions set out.
+ we only want to put value into a empty cell, "."
+ When we consider putting a number into a cell:
    - is this current 3x3 grid, contains the number already ?
     + otherwise, go back an pick another number
    - is this entire row, contains the number that we have in mine already?
     + otherwise, go back an pick another number
    - is this entire column, contains the number that we have in mine already?
    + otherwise, go back an pick another number
    => put the number into the empty cell
+ Move up to another cell and then repeat the process.

Algorithm: Backtracking:
loop through each number in the range(1-9), pick a number and then run it through the three requirements above
    loop through the board, if the current cell is a ".", the dive into it and look around its neighbors

Time complexty: O(mxn), where m and n is the dimension of the sudoku board
Space complexity:
*  */
public class Sudoku {
    //function to check if the number we picked cannot break the sukodu rules
    public boolean isSafe(char[][] board, char num, int row, int col){
        //traverse through the rest of the column to see if the current number has been seen or not
        for(int i = 0; i < 9; i++){
            if(board[row][i] == num){
                return false;
            }
        }

        //traverse through the rest of the row to check for the current number validity
        for(int i = 0; i < 9; i++){
            if(board[i][col] == num){
                return false;
            }
        }

        row = row - row %3; //getting the 1st row in a 3x3 sub-board
        col = col - col %3; //getting the 1st col in a 3x3 sub-board

        //traverse sub board to see if the number has been seen or not
        for(int i = row; i < row+3; i++){
            for(int j = col; j < col+3; j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }


        return true;


    }

    //function to solve the sudoku board recursively, we will traverse the board row by row and only look at any cell that are empty
    public boolean sudokuSolver(char[][] board, int row, int col){
        //base case: if the algorithm is already at the last row and col of the board, then just return true
        if(row == 8 && col == 9){
            return true;
        }

        //if the algorithm has run through the number of col available in the current row,
        //the increment the row number and rest column number to 0
        if(col == 9){
            row++;
            col = 0;
        }

        //if the current element in a grid cell is not empty, then there is nothing that we can do about it so we will move on to the next cell
        //in the sudoku board
        if(board[row][col] != '.'){
            return sudokuSolver(board, row, col+1);
        }

        //this is where we try to solve the sudoku
        //traverse through the rest of the column in the board
        for(int i = 1; i <= 9; i++){
            //converting the current selected number to a char
            char curr_selected_num = Character.forDigit(i, 10);
            //check to see if this number is good to be used
            if(isSafe(board, curr_selected_num, row, col)){ //backtracking happens here, if this "if" statement fails then we will back out of it and check for another number
                //if it is good to use, then we will assign it to the
                //current space on the board
                board[row][col] = curr_selected_num;
                //recursively check for the rest of the rows
                if(sudokuSolver(board, row, col+1)){
                    return true;
                }

            }

            board[row][col] = '.';
        }
        return false;
    }

    //function to print a board out:
    public static void printBoard(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.println(board[i][j]);
                System.out.println("");
            }
            System.out.println("\n");

            if((i+1) % (int)Math.sqrt(board.length) == 0){
                System.out.println("");
            }
        }
    }

    public char[][] getSudokuBoard(char[][] board){
        if(sudokuSolver(board, 0, 0)){
            return board;
        }

        return board;
    }

    public void solveSudoku(char[][] board) {
        sudokuSolver(board, 0, 0);

    }


}
