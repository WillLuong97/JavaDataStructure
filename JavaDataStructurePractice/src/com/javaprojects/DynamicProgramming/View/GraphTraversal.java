package com.javaprojects.DynamicProgramming.View;

import com.javaprojects.DynamicProgramming.Model.Graph;

import java.util.LinkedList;

//This file will store basic graph traversal algorithm such as BFS and DFS in java
public class GraphTraversal {
    //creating a graph
    Graph graph = new Graph(4);
    //adding edges into the graph



//    //Function to traverse the node recursively using dfs
//    public void DFS_UTIL(String s, boolean[][] visited, int i, int j, String[][] matrix){
//        //if it has not been visited, mark it as true and add the value into the string array
//        visited[i][j] = true;
//        System.out.println(s);
//
//        //determine the right moves for the algorithm to branch out to the right neighbor
//        int[]dx = {1,-1,0,0};
//        int[]dy = {0,0,1,-1};
//
//        for(int move = 0; move < dx.length; move++){
//            int new_dx = i + dx[move];
//            int new_dy = j + dy[move];
//            //branch out to valid neighbor
//            if(isValid(new_dx,new_dy, visited, matrix)){
//                DFS_UTIL(matrix[new_dx][new_dy], visited, new_dx, new_dy, matrix);
//            }
//        }
//    }
//    //Function to traverse the graph in a DFS approach:
//    public void DFS(String[][] matrix){
////        //base case: making sure that the matrix is not empty
////        if (matrix == null && matrix.length == 0){
////            return null;
////        }
//        //extracting the row and col of the matrix
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        //Creating a visited 2-d array to keep track of visited nodes
//        boolean[][] visited = new boolean[m][n];
//
//        //result array
//        String[] result = new String[0];
//
//        //traverse through the graph and print out nodes in a dfs format
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                if(visited[i][j] == false){
//                    DFS_UTIL(matrix[i][j], visited, i, j, matrix);
//                }
//            }
//        }
//    }

    //Function to make sure that the algorithm is branching out to the right neighbors:
    public boolean isValid(int move_x, int move_y, boolean[][] visited, String[][]matrix){
        if(move_x >= 0 && move_x < matrix.length && move_y >= 0 && move_y < matrix[0].length && visited[move_x][move_y] != true){
            return true;
        }
        return false;
    }


    /* The BFS approach aims to mark all vertices of the graph to be visited without a a cycle

    pseudocode:
    create a queue and a visited array
    mark the beginning vertex to be visited and then put them onto a queue
    as long as the queue is not empty
    pop the top node out of the queue and add it to the visited list
    create a list of the current node adjacent nodes, if they are not yet visited, so we will add them onto the queue
    keep repeating step 2 and 3 until the queue is empty
    * */
    //Function to traverse a graph using BFS:
//    public void BFS(int node){
//        LinkedList<Integer> queue = new LinkedList<>();
//        //boolean array to keep track of the visited node:
//        boolean[] visited = new boolean[4];
//        visited[node] = true;
//        queue.add(node);
//        while(!queue.isEmpty()){
//            node = queue.poll();
//            System.out.println(node + " ");
//            //looping through the neigbor node of the current node using
//            for(int i: adjLst[node]){
//                if(!visited[node]){
//                    visited[i] = true;
//                    queue.add(i);
//                }
//            }
//        }
//    }
//
//    //function traverse through a graph using dfs
//    public void dfs(int node){
//        //boolean array to keep track of the visited node
//        boolean[] visited = new boolean[4];
//        System.out.println(node + " ");
//        for(int neighbor : adLst[node]){
//            //if the neighbor node has not been visited so we will add it into the
//            if (!visited[neighbor]){
//                visited[neighbor] = true;
//                dfs(neighbor);
//            }
//        }
//
//
//    }

}
