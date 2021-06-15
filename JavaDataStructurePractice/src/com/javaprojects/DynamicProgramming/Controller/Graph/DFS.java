package com.javaprojects.DynamicProgramming.Controller.Graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS {
    /* Function to print out all element in a 2d matrix using DFS
    * Constraints: we can only branch out with up down left and right*/
    public void printDFS(int[][] matrix){
        //base case:
        if(matrix.length == 0 || matrix[0].length == 0){
            throw new RuntimeException("EMPTY INPUT");
        }

        //visited array to keep track of all visited node
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        //loop through the matrix to create the graph
//        for(int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix[0].length; j++){
//                //if the node has not been visited so we will send it into the dfs method
//            }
//        }
        dfs(0,0, matrix, visited);

    }

    //Helper method to traverse through the 2d matrix using recursively
    private void dfs(int i, int j, int[][] matrix, boolean[][] visited){
        //check to see if the node has been visited or not
        if(!visited[i][j]){
            visited[i][j] = true;
            //print out the node
            System.out.println(matrix[i][j]);
            //list of valid move
            int[] dx = new int[]{-1, 0, 1, 0};
            int[] dy = new int[]{0, 1, 0, -1};

            //loop through the list of valid move to obtain the new move
            for(int move = 0; move < dx.length; move++){
                int new_i = i + dx[move];
                int  new_j = j +  dy[move];
                //before we branch out to its neighbor, we want to check to see if the elemnt is valid to continue
                if(isValidNode(new_i, new_j, matrix, visited)){
                    dfs(new_i, new_j, matrix, visited);
                }
            }
        }
    }

    //Helper method to check if a node has been visited or not
    private boolean isValidNode(int i, int j, int[][] matrix, boolean[][] visited){
        if(i < 0 || j < 0 || i > matrix.length - 1 || j > matrix[0].length - 1){
            return false;
        }

        if(visited[i][j] != false){
            return false;
        }


        return true;
    }
}
