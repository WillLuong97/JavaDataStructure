package com.javaprojects.DynamicProgramming.Controller.AmazonOA;

import java.util.*;

/*
Your team at amazon is overseeing the design of a new high-efficiency data center at HQ2. A power grid need to be generated for supplying power to N servers. All servers in the grid have to be connected such that they have access to power. The cost of connections between different servers varies.

Assume that there are no ties, names of servers are unique, connections are directionless, there is at most one connection between a pair of servers, all costs are greater than zero, and a server does not connect to itself.

Write an algorithm to minimize the cost of connecting all servers in the power grid.

Input
two arguments - num, an Integer representing number of connections.
connectons, representing a list of connections where each element of the list consists of two servers and the cost of connection between the servers.

Note
The cost of connection between the servers is always greater than 0.

Priority Queue  + BFS approach:

*  */
public class MinCostOfConnectionForAllNodes {
    //A connection class to represent the connections and its cost between the nodes
    class Connections{
        public char start;
        public char destination;
        public int cost;
        //constructor
        public Connections(char start, char destination, int cost) {
            this.start = start;
            this.destination = destination;
            this.cost = cost;
        }
    }

    //main caller for testing
    public void findMinCostToConnectNodes_MAIN_CALLER(){
        List<Connections> connections = new ArrayList<>();
        //building out the current connections
        connections.add(new Connections('A', 'B', 1));
        connections.add(new Connections('B', 'C', 4));
        connections.add(new Connections('B', 'D', 6));
        connections.add(new Connections('D', 'E', 5));
        connections.add(new Connections('C', 'E', 1));
        int numsOfServer = 5;

        List<Connections> result = findMinCostToConnectNodes(numsOfServer, connections);

        for(Connections c: result) {
            System.out.println(c.start + ", " + c.destination + " , " + c.cost);
        }
    }


    //Function to find the cost
    private List<Connections> findMinCostToConnectNodes(int serverNums, List<Connections> connections){
        //build a adjacency list from the connections using the hashmap
        HashMap<Character,List<Connections>> adjList = buildMap(connections);
        //run bfs through the adjList to find the new connections set with minimal cost
        return bfsHelper(serverNums, connections.get(0), adjList);
    }


    //helper method to run bfs through the connections
    private static List<Connections> bfsHelper(int nums, Connections startConnectionSet, HashMap<Character, List<Connections>> hashMap){
        HashSet<Character> visited = new HashSet();
        List<Connections> result = new ArrayList<>();
        //create a priority queue to store the processing connections based on its cost with priority given the minimum ones
        Queue<Connections> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);

        //push the current connecting point onto the queue to begin the bfs process
        pq.add(startConnectionSet);

        while(!pq.isEmpty()){
            int size = pq.size();
            for(int i = 0; i <= size; i++){
                //extracting the connection set that has minimum cost
                Connections curr_conn = pq.poll();
                //check to see if the connection set has been visited or not
                if(visited.contains(curr_conn.start)){
                    continue;
                }
                result.add(curr_conn);
                visited.add(curr_conn.start);
                List<Connections> nextConnectionSet = hashMap.get(curr_conn.destination);
                //traverse through the each sets of new connections and add it onto the queue
                for(Connections next_conn : nextConnectionSet){
                    pq.add(next_conn);
                }

            }
        }
        return result;

    }

    //helper method to build the map that represent the current server connections
    /* A: ['A', 'B', 1] */
    private static HashMap<Character, List<Connections>> buildMap(List<Connections> connections){
        HashMap<Character, List<Connections>> retMap = new HashMap<>();

        //init a new array list for each starting node
        for(char c = 'A'; c <= 'E'; c++){
            retMap.put(c, new ArrayList<>());
        }

        //add the destination point to each starting point currently stored as the key in the hashmap
        for(int i = 0; i < connections.size(); i++){
            Connections conn = connections.get(i); //connections = ['A', 'B', 1] -> conn = [start = 'A', destination = 'B', cost = '1']
            //connect each node together via a adj list
            retMap.get(conn.start).add(conn);
            retMap.get(conn.destination).add(conn);
        }

        return retMap;
    }
}
