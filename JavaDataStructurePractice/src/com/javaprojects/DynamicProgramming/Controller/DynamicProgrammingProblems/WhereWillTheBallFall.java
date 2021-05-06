package com.javaprojects.DynamicProgramming.Controller.DynamicProgrammingProblems;

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

dfs with dp memoization:
create a memoization 2-d list with the same dimension as the original grid. for optimization
create a with result 1-d list
dfs would be used to run through the grid and check for the number in the two adjacent column cell.
base case: if the ball is at the end of the row, then just return the column
Logic: if the grid[row][col] == 1 and grid[row][col+1] == 1 and the column is still within the grid: then we will traverse down the grid, but the ball
will land at location col+1 and row+1 => call dfs recursively on the next row and column, but at each dfs,
we want to update the memo[row][col] => the dfs function return value

==> dfs will return the column where the ball will fall down (0, 1,2,3,4,....) and the memo[row][col]


Time complexity: O(mxn)
Space complexity: O(mxn), we are storing the a memo 2-d array with the same dimension as original grid
*  */
public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        //create variable:
        //getting the dimension of the grid
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];
        Integer[][] memo = new Integer[m][n];
        //base case:
        if (grid.length == 0 && grid[0].length == 0){
            return result;
        }

        //traverse through the grid and use dfs to track the ball position
        for(int i = 0; i < n; i++){
            result[i] = dfs(grid, i, 0, memo);
        }

        return result;
    }

    //function to dfs through the grid
    public int dfs(int[][] grid, int col, int row,  Integer[][] memo){
        //base case:
        if(row == grid.length){
            return col;
        }
        if(memo[row][col] != null){
            return memo[row][col];
        }
        //condition to move a ball
        //the board spanning from top left to bottom right corner of the grid
        if(grid[row][col] == 1 && col + 1 < grid[0].length && grid[row][col+1] == 1){
            // then the ball will fall down to the next row in the left
            memo[row][col] = dfs(grid, col + 1, row + 1, memo);
        }
        //if the board is moving from right to left, then the ball will move down to the next row and prev col - 1:
        else if(grid[row][col] == -1 && col - 1 >= 0 && grid[row][col-1] == -1){
            memo[row][col] = dfs(grid, col - 1, row + 1, memo);

        }
        else{
            memo[row][col] = -1;
        }
        return memo[row][col];
    }
}
