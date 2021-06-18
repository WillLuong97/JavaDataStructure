package com.javaprojects.DynamicProgramming.Controller.Graph;

public class TwoDimnestionArrSummation {
    public int hourGlassSummation(int[][] array){
        //base case:
        if(array.length == 0 || array[0].length == 0) {
            throw new RuntimeException("Empty matrix");
        }
        //create a result 2d array to store the sums
        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;
        //traverse through the matrix by its row and column, but each time go by a set of 3 element
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                //adding the sum of the top of the hour glass
                curr_sum = array[i][j] + array[i][j+1] + array[i][j+2];
                //adding to the sum the mid element of the hour glass
                curr_sum += array[i+1][j+1];
                //the bottom of the hour glass
                curr_sum += array[i+2][j] + array[i+2][j+1] + array[i+2][j+2];
                //find the max sum:
                if(max_sum < curr_sum){
                    max_sum = curr_sum;
                }
            }
        }

    return max_sum;
    }
}
