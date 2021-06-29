package com.javaprojects.DynamicProgramming.Controller.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
*There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree).
* Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.

Example 1:
Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
*
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 2:
Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 3:
Input: n = 3, connections = [[1,0],[2,0]]
Output: 0

Constraints:

2 <= n <= 5 * 104
connections.length == n - 1
connections[i].length == 2
0 <= ai, bi <= n - 1
ai != bi

*
* Approach: we will traverse through the connections list using dfs and if we come across a forward direction, then we
* will want to reroute it to the previous node, thus, counting it as one rerouting operations
*/
public class ReorderRoutes {
    public int minReorder(int n, int[][] connections) {
        //a 2d array to represent the connections as the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        //initialize the adjacency list
        for(int i = 0; i < n; i++){
            graph.add(new LinkedList<>());
        }

        // fill out the adjacency list with the connections
        for(int[] connection:connections){
            //forwarding relationship
            graph.get(connection[0]).add(connection[1]);
            //backward relationship: represented as -
            graph.get(connection[1]).add(-connection[0]);
        }
        //create a visited array to keep track of the city that has been visited
        boolean[] visited = new boolean[n];
        //traverse through each city to start rerouting
        return dfs(graph, 0, visited);
    }

    //helper method to traverse through the graph using dfs
    private int dfs(List<List<Integer>> graph, int city, boolean[] visited){
        //counter to keep track of the current
        int result = 0;
        //the current city has been visited
        visited[city] = true;
        //check to see if this current can reach other city that has been visited as well or not
        //otherwise, we will reroute them and increment the counter
        List<Integer> neighbor_city = graph.get(city);
        for(Integer new_city: neighbor_city){
            if(!visited[Math.abs(new_city)]){
                result += dfs(graph, Math.abs(new_city), visited) + (new_city > 0 ? 1:0);
            }
        }
        return result;
    }

}
