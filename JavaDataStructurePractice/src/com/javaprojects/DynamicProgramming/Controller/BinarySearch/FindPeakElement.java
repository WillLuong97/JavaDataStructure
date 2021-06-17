package com.javaprojects.DynamicProgramming.Controller.BinarySearch;

public class FindPeakElement {
    public int[] findPeakGrid(int[][] mat) {
        //variable to keep track of the begining and ending column of the matrix
        int startCol = 0;
        int endCol = mat[0].length - 1;
        //within the boundary of the column, we will use binary seach to find the
        //peak element
        while(startCol <= endCol){
            int midCol = startCol + (endCol - startCol) / 2;
            int curr_max_in_row = 0;
            //loop through the entire column row by row to find the max row number
            for(int i = 0; i < mat.length; i++){
                curr_max_in_row = mat[i][midCol] >= mat[curr_max_in_row][midCol] ? i : curr_max_in_row;
            }
            //boolean to keep track of whether or not the left and right element of the current max row is larger than it
            boolean isLeftNodeBigger = midCol -1 >= startCol && mat[curr_max_in_row][midCol-1] > mat[curr_max_in_row][midCol];
            boolean isRightNodeBigger = midCol + 1 <= endCol && mat[curr_max_in_row][midCol+1] > mat[curr_max_in_row][midCol];

            //check to see if we have found the peak element, otherwise, branch out the col with the more appropriate candidate
            if(!isLeftNodeBigger && !isRightNodeBigger){
                return new int[]{curr_max_in_row, midCol};
            } else if(isRightNodeBigger){
                startCol = midCol + 1;
            } else {
                endCol = midCol - 1;
            }
        }
        return null;
    }
}
