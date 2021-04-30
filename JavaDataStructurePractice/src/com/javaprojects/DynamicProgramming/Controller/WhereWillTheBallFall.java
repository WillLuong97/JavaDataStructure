package com.javaprojects.DynamicProgramming.Controller;

/* 1706. Where Will the Ball Fall
Medium
257
22

Add to List

Share
You have a 2-D grid of size m x n representing a box, and you have n balls. The box is open on the top and bottom sides.

Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right or to the left.

A board that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented in the grid as 1.
A board that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented in the grid as -1.
We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom. A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall of the box.

Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom after dropping the ball from the ith column at the top, or -1 if the ball gets stuck in the box.

Example 1:
Input: grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
Output: [1,-1,-1,-1,-1]
Explanation: This example is shown in the photo.
Ball b0 is dropped at column 0 and falls out of the box at column 1.
Ball b1 is dropped at column 1 and will get stuck in the box between column 2 and 3 and row 1.
Ball b2 is dropped at column 2 and will get stuck on the box between column 2 and 3 and row 0.
Ball b3 is dropped at column 3 and will get stuck on the box between column 2 and 3 and row 0.
Ball b4 is dropped at column 4 and will get stuck on the box between column 2 and 3 and row 1.
Example 2:

Input: grid = [[-1]]
Output: [-1]
Explanation: The ball gets stuck against the left wall.
Example 3:

Input: grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
Output: [0,1,2,3,4,-1]
Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100

Solution: traverse the grid to determine to find where the V can happen, then return -1, otherwise, keep moving
down the grid left and right diagonally based on the position of the board.

Approach: we will traverse the graph and build out path of each ball, we build out this path using DP to keep track
of whether or each ball can

grid[i][j] is 1 or -1.
0  1 2  3  4
[1,1,1,-1,-1]
[1,1,1,-1,-1]
[-1,-1,-1,1,1]
[1,1,1,1,-1]
[-1,-1,-1,-1,-1]

len(grid) == 5
if current_ball == 6: exit and return the previous cell that it was at.

How do we move left or right?
- Move left when: if it is a current cell  == -1, then move left down diagonally
- Move right when: if the current cell == 1, then we move right down diagonally
so basically we toggle the ball left and right based on the value in the current cell, 1 to right and -1 to left

how do we catch the V? V exit when the current cell and the cell right next to it are 1 and -1 or vice versa.
exit state: when the current iterator has made it out the boundary limit.
*  */
public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        //extract the dimension of the grid:
        int rows = grid.length;
        int cols = grid[0].length;
        //this is the return array but it is also
        //the dp array to keep track of all sub problem solutions
        int[] result = new int[cols];
        int backup = 0;

        //loop through the grid to check for the movement of the balls
        //go through each column:
        for(int i = 0; i < cols; i++){
            int row = 0;
            int col = i;
            backup = i;
            //ensure that the iterator are traversing inside of the grid
            while(row < rows && col < cols && row >= 0 && col >= 0){
                //if the current cell has a 1, check to see if it has a V with the adjacent cell
                //otherwise, move left and right diagonally based on the position of the internal board
                if(grid[row][col] == 1){
                    //check if there is a V
                    if(col == col -1 || grid[row][col+1] == -1){
                        result[i] = -1;
                        break;
                    }
                    //if no V and this is a 1 board, we diagonally right by 1
                    else{
                        row ++;
                        col ++;
                    }
                }
                //board to go down left
                if(grid[row][col] == -1){
                    //check if there is a V:
                    if(col == 0 || grid[row][col-1] == 1){
                        result[i] = -1;
                        break;
                    }
                    else{
                        col--;
                        row++;
                    }

                }
                //if we are able to traverse all the way out of the grid, then store the previous cell, where it was saved
                backup = col;
            }
            if(result[i] == 0){
                result[i] = backup;
            }

        }
        return result;

    }
}
