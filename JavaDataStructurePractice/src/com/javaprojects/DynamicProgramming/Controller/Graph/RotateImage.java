package com.javaprojects.DynamicProgramming.Controller.Graph;

/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Example 3:
Input: matrix = [[1]]
Output: [[1]]

Example 4:
Input: matrix = [[1,2],[3,4]]
Output: [[3,1],[4,2]]


Constraints:

matrix.length == n
matrix[i].length == n
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000


Transpose, or swap the two cell in a matrix around a diagonal line
after that we will reverse the transposed matrix to get the answer

*  */
public class RotateImage {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    //helper method to transpose a matrix
    private void transpose(int[][] matrix){
        //the matrix has equal dimension: so we just need to extract n
        int n = matrix.length;
        //traverse through the matrix to swap the cell
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){ //j = i, because we want to swap, for example, (0,2) with (2,0)
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    //Helper method to reverse a matrix:
    private void reverse(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n / 2; j++){
                //to reveres a matrix, we will swap the first element in a row with the last element in that same row;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }

}