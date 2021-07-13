package com.javaprojects.DynamicProgramming.Controller.Graph;

/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

Example 1:

Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

Example 2:

Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3


Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1 => the graph will always contains 1 diagonally. Meaning the graph will begin with 1
isConnected[i][j] == isConnected[j][i]


Approach: We will treat this problem as connected island problem
we will traverse through the graph to specifically look for any node that contains 1 as the value, then use dfs to look for its immediate, which is left, right,
up and down to see if they are another 1 or not, if so dfs into that node until they are no more node with value 1 as its neighbor, we will backtrack and
look for the next node in the graph to see if they are a 1 or not and repeat the process

a group of cities is counted as 1 province if all cities within the group has been visited and no more extra cities can be included into the group.

* */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        //base case: the board is empty:
        if(isConnected.length == 0 || isConnected[0].length == 0){
            throw new RuntimeException("Invalid Graph: Received an empty board!");
        }
        //getting the dimension of the graph:
        int m = isConnected.length;
        int counter = 0;
        //visited array to keep track of which nodes has been visited
        //this visited array will all be false at the beginning
        boolean[] visited = new boolean[m];

        //traverse through the graph to count the number of connected provinces
        for(int i = 0; i < m; i++){
            //if the graph has not been visited, so we will pass them into the dfs and check to see if it is a city
            if(visited[i] == false){
                counter++;
                dfs(isConnected, visited, i);
            }
        }
        return counter;

    }

    //helper method to run dfs through the graph
    private void dfs(int[][] grid, boolean[] visited, int node){
        visited[node] = true;
        for(int j = 0; j < grid.length; j++){
            if(grid[node][j] == 1 && visited[j] == false){
                dfs(grid, visited, j);
            }
        }
    }

}
