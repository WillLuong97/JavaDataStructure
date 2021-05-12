package com.javaprojects.DynamicProgramming.Controller.Graph;

import java.awt.print.PrinterGraphics;
import java.util.*;

/* You are given a network of n nodes, labeled from 1 to n. You are also given times,
a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node,
vi is the target node, and wi is the time it takes for a signal to travel from source to target.
We will send a signal from a given node k.
Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
   1
 3 -> 4
 ^
1|
2 -> 1
  1

Output: 2
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi

Example 2:
Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

Example 3:
Input: times = [[1,2,1]], n = 2, k = 2
Output: -1

Constraints:
1 <= k <= n <= 100
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
Observable Conditions:
- times = [2,1,1] => node 2 sending signal node 1 that cost around 1 unit of time
- each network node is labeled as 1 to n. For example, if there are 4 nodes, then the node would be as: node_1 node_2 node_3 node_4
- a node can only send out a signal to its destination node
k_node would be the starting node of sending out the signal.
when a network node want to send out a signal to its destination nodes:
transit_time_to_destination_1 = time it takes to send a signal from the current_node to its neighbor
from the current node:
-> if the transit_time_to_destination_1 > transit_time_to_destination_2 or the transit_time_to_destination_1 < transit_time_to_destination_2:
    the total_time = sum(transit_time_to_destination_1 + transit_time_to_destination_2)
   otherwise, if the  transit_time_to_destination_1 == transit_time_to_destination_2:

Pseudocode:
 translate times into a hashmap,
 network_node_graph = {start_node: [(destination, time)]}
 create a visited array to keep track of the visited network_node so that we do not run into an infinite loop.
 int result = 0;
 create an array to store the time to get to each node from 1 to n, we only want to store time that are lesser than or equal to
 and update the each node in the time array accordingly. This is used to check that all the node are visited and at the
 end if there are any node that is not updated with the total_time, then we will return -1.

 create a private int dfs(int[][] network_node_graph, bool[] visited; int result, int node)

*  */
public class NetworkDelayTime {
    Map<Integer, Integer> transitTime;
    public int networkDelayTime(int[][] times, int n, int k) {
        //base case: invalid entry of input
        if(times.length == 0 && times[0].length == 0 && k <  1 && n < 1) {
            return -1;
        }
        //creating a hasmap to store the network node with its destination and time
        Map<Integer, List<int[]>> network_node_graph = new HashMap<>();

        //translating the times into an adjacency list
        for(int[] node: times){
            //if the network graph does not already contain the node so we will create a spot for it
            if(!network_node_graph.containsKey(node[0])){
                network_node_graph.put(node[0], new ArrayList<int[]>());
            }
            network_node_graph.get(node[0]).add(new int[]{node[2], node[1]});
        }
        //sort the graph based on the
        for(int node: network_node_graph.keySet()){
            Collections.sort(network_node_graph.get(node), (a,b) -> a[0] - b[0]);
        }
        transitTime = new HashMap<>();
        //adding the time into the transit
        for(int i = 1; i <= n; ++i){
            transitTime.put(i, Integer.MAX_VALUE);
        }

        dfs(network_node_graph, k, 0);
        int result = 0;

        for(int candidate: transitTime.values()){
            if (candidate == Integer.MAX_VALUE){
                return -1;
            }
            result = Math.max(result, candidate);
        }
        return result;
    }

    public void dfs(Map<Integer, List<int[]>> graph, int node, int cost){
        //if the two node have the same time, then the time would just be one of them
        if(cost >= transitTime.get(node)){
            return;
        }

        //otherwise, update the transit time with the cost from the previous transit
        transitTime.put(node, cost);
        if(graph.containsKey(node)){
            for(int[] edge: graph.get(node)){
                dfs(graph, edge[1], cost + edge[0]);
            }
        }
    }
}
