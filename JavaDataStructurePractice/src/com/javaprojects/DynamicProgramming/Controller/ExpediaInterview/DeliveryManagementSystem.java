package com.javaprojects.DynamicProgramming.Controller.ExpediaInterview;


/*
Question name:
https://www.chegg.com/homework-help/questions-and-answers/java-complete-method-find-route-method-definition-static-int-path-int-citynodes-int-cityfr-q68135997*


Approach: BFS + PriorityQueue
 */

import java.util.*;

public class DeliveryManagementSystem {
    public List<Integer> path(int cityNodes, int[] cityFrom, int[] cityTo, int company){
        //base case:
        if(cityFrom.length == 0 || cityTo.length == 0){
            //error check: invalid input:
            throw new RuntimeException("Invalid Input: The lenght of city array is 0!");
        }

        //create a priority quque to store all processing city node
        Queue<Integer> pq = new LinkedList<>();

        //create a visted array to keep track of visited node so we do not end up running into
        //same city twice
        List<Integer> visited = new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        //build out hashmap to store the from and to relationship of citites
        Map<Integer, List<Integer>> cityMap = new HashMap<>();

        //build out the map
        for(int i = 0; i < cityFrom.length; i++){
            if(!cityMap.containsKey(cityFrom[i])){
                cityMap.put(cityFrom[i], new ArrayList<>());
            }

            cityMap.get(cityFrom[i]).add(cityTo[i]);
        }

        pq.offer(company);
        visited.add(company);


        //begin bfs
        while(!pq.isEmpty()){
            //keeping track of each level in the quue
            for(int i = 0; i < pq.size(); i++){
                //since this is a min heap, we will always get back the current smallest element from the queue out
                int curr_city = pq.poll();
                //do not include the company onto the final order
                if(curr_city != company){
                    result.add(curr_city);
                }
                //find the immediate cities that is connected to this current node
                if(cityMap.get(curr_city) != null){
                    for(int next_city : cityMap.get(curr_city)){
                        //check to see if the neihboring city has been visited or not
                        if(!visited.contains(next_city)){
                            visited.add(next_city);
                            pq.offer(next_city);
                        }
                    }
                }

            }
        }
        return result;
    }
}
