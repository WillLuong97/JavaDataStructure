package com.javaprojects.DynamicProgramming.Controller.DynamicProgrammingProblems;

/*
Given a rows * columns matrix mat of ones and zeros, return how many submatrices have all ones.
Example 1:
Input: mat = [[1,0,1],
              [1,1,0],
              [1,1,0]]
Output: 13
Explanation:
There are 6 rectangles of side 1x1.
There are 2 rectangles of side 1x2.
There are 3 rectangles of side 2x1.
There is 1 rectangle of side 2x2.
There is 1 rectangle of side 3x1.
Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
Example 2:

Input: mat = [[0,1,1,0],
              [0,1,1,1],
              [1,1,1,0]]
Output: 24
Explanation:
There are 8 rectangles of side 1x1.
There are 5 rectangles of side 1x2.
There are 2 rectangles of side 1x3.
There are 4 rectangles of side 2x1.
There are 2 rectangles of side 2x2.
There are 2 rectangles of side 3x1.
There is 1 rectangle of side 3x2.
Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.
Example 3:

Input: mat = [[1,1,1,1,1,1]]
Output: 21
Example 4:

Input: mat = [[1,0,1],[0,1,0],[1,0,1]]
Output: 5

Constraints:

1 <= rows <= 150
1 <= columns <= 150
0 <= mat[i][j] <= 1

*   */
public class CountSubMatricesWithAllOnes {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        //creating a second submatrices to store the number 1 of each cell in the previous matrix
        int[][] numOfOnesMat = new int[m][n];
        //looping throught the original matrix to find the number of 1:
        // these are the loops for making a matrix brr[][]
        // where index brr[i][j] will contain continous number of 1
        //starting from index j to n-1
        for(int i = 0; i < m; ++i){
            numOfOnesMat[i][0] = mat[i][0];
            for(int j = 1; j < n; ++j){
                if(mat[i][j] == 1){
                    numOfOnesMat[i][j] = numOfOnesMat[i][j-1] + 1;
                }
            }
        }
        int noOfSubMatrices = 0;
        // these are the loops for finding number of submatrices of all 1
        // starting from a perticular fixed index (i,j) and adding it to answer
        // we do this step for all i,j
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                noOfSubMatrices += numOfOnesMat[i][j];
                int min = numOfOnesMat[i][j];
                for(int z = i+1; z < m; ++z){
                    min = Math.min(min, numOfOnesMat[z][j]);
                    noOfSubMatrices += min;
                }
            }
        }

        return noOfSubMatrices;

    }


}
