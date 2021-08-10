package com.javaprojects.DynamicProgramming.Controller.Graph;

import com.javaprojects.DynamicProgramming.Model.GraphNode;
import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

/* Given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
class Node {
    public int val;
    public List<Node> neighbors;
}

Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.


Example 1:


Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
Example 2:


Input: adjList = [[]]
Output: [[]]
Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
Example 3:

Input: adjList = []
Output: []
Explanation: This an empty graph, it does not have any nodes.
Example 4:


Input: adjList = [[2],[1]]
Output: [[2],[1];
Constraints:

The number of nodes in the graph is in the range [0, 100].
1 <= Node.val <= 100
Node.val is unique for each node.
There are no repeated edges and no self-loops in the graph.
The Graph is connected and all nodes can be visited starting from the given node.
Approach:
We will use DFS to solve this problem. We will create a hashmap that can  store the value of the node as the key (for easier querying
of the data) and the copy of the node as the value.

We will go through each node in the original graph, create a new node as its copy assign it to the
map, then we will go through its neighbor in the recursion process until there are no more node, and we just need
to return the array.
*  */
public class CloneGraph {
    public GraphNode cloneGraph(GraphNode node) {
        //create the map to store the new node of the graph
        Map<Integer, GraphNode> nodeMap = new HashMap<>();

        return dfs(nodeMap, node);
    }

    //function to traverse the node map via dfs
    public GraphNode dfs(Map<Integer, GraphNode> nodeMap, GraphNode node){
        //if the node we found is empty, so we will return it to the previous recursion
        if(node == null){
            return node;
        }

        //check if the node is already on the map or not
        if(nodeMap.containsKey(node.val)){
            return nodeMap.get(node.val);
        }


        //if the node is new, then make a copy of it and add it onto the map
        GraphNode newNode = new GraphNode(node.val);
        nodeMap.put(node.val, newNode);
        //loop through the neighbor of the original node to make a copy of them
        for(GraphNode neighbor: node.neighbors){
            newNode.neighbors.add(dfs(nodeMap, neighbor));
        }

        return newNode;
    }

    //Clone graph using Queue + BFS
    public GraphNode cloneGraphWithQueue(GraphNode node){
        throw new RuntimeException("NOT YET IMPLEMENTED!");
    }

}
