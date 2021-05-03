package com.javaprojects.DynamicProgramming.View;

//This file will store basic graph traversal algorithm such as BFS and DFS in java
public class GraphTraversal {

    //Function to traverse the node recursively using dfs
    public void DFS_UTIL(String s, boolean[][] visited, int i, int j, String[][] matrix){
        //if it has not been visited, mark it as true and add the value into the string array
        visited[i][j] = true;
        System.out.println(s);

        //determine the right moves for the algorithm to branch out to the right neighbor
        int[]dx = {1,-1,0,0};
        int[]dy = {0,0,1,-1};

        for(int move = 0; move < dx.length; move++){
            int new_dx = i + dx[move];
            int new_dy = j + dy[move];
            //branch out to valid neighbor
            if(isValid(new_dx,new_dy, visited, matrix)){
                DFS_UTIL(matrix[new_dx][new_dy], visited, new_dx, new_dy, matrix);
            }
        }
    }
    //Function to traverse the graph in a DFS approach:
    public void DFS(String[][] matrix){
//        //base case: making sure that the matrix is not empty
//        if (matrix == null && matrix.length == 0){
//            return null;
//        }
        //extracting the row and col of the matrix
        int m = matrix.length;
        int n = matrix[0].length;

        //Creating a visited 2-d array to keep track of visited nodes
        boolean[][] visited = new boolean[m][n];

        //result array
        String[] result = new String[0];

        //traverse through the graph and print out nodes in a dfs format
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] == false){
                    DFS_UTIL(matrix[i][j], visited, i, j, matrix);
                }
            }
        }
    }

    //Function to make sure that the algorithm is branching out to the right neighbors:
    public boolean isValid(int move_x, int move_y, boolean[][] visited, String[][]matrix){
        if(move_x >= 0 && move_x < matrix.length && move_y >= 0 && move_y < matrix[0].length && visited[move_x][move_y] != true){
            return true;
        }
        return false;
    }
}
