package com.javaprojects.DynamicProgramming.Controller.Greedy;

/*
There is a city composed of n x n blocks, where each block contains a single building shaped like a vertical square prism. You are given a 0-indexed n x n integer matrix grid where grid[r][c] represents the height of the building located in the block at row r and column c.

A city's skyline is the the outer contour formed by all the building when viewing the side of the city from a distance. The skyline from each cardinal direction north, east, south, and west may be different.

We are allowed to increase the height of any number of buildings by any amount (the amount can be different per building). The height of a 0-height building can also be increased. However, increasing the height of a building should not affect the city's skyline from any cardinal direction.

Return the maximum total sum that the height of the buildings can be increased by without changing the city's skyline from any cardinal direction.

Example 1:


Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
Output: 35
Explanation: The building heights are shown in the center of the above image.
The skylines when viewed from each cardinal direction are drawn in red.
The grid after increasing the height of buildings without affecting skylines is:
gridNew = [ [8, 4, 8, 7],
            [7, 4, 7, 7],
            [9, 4, 8, 7],
            [3, 3, 3, 3] ]
Example 2:

Input: grid = [[0,0,0],[0,0,0],[0,0,0]]
Output: 0
Explanation: Increasing the height of any building will result in the skyline changing.


Constraints:

n == grid.length
n == grid[r].length
2 <= n <= 50
0 <= grid[r][c] <= 100

Approach: We will apply greedy algorithm to  increase the height of each building
by the min between the max height of the building that is on the same row and column
with the current building

Intuition:
We will loop through the matrix by the row and column
and at each building, we will find the right number of increased height
by the building height surrounding it


Time complexity: O(n^2)
Space complexity: O(n), the space to store the max city in each row and column
*  */
public class CitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        //base case:  the grid is empty!
        if(grid.length == 0 || grid[0].length == 0){
            return 0;   //grid is empty, no sum can be found
        }
        //array to store the max heihght of each city in the row and column]
        int[] maxRows = new int[grid.length];
        int[] maxCols = new int[grid.length];
        //loop through the rows and columns to find the maxes
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                maxRows[i] = Math.max(maxRows[i], grid[i][j]);
                maxCols[j] = Math.max(maxCols[j], grid[i][j]);
            }
        }

        int result = 0;
        //loop through the grid again and start comparing the element to see which height can we add too
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                result += Math.min(maxRows[i], maxCols[j]) - grid[i][j];
            }
        }

        return result;
    }

}
