package com.javaprojects.DynamicProgramming.Model;

import java.util.LinkedList;

//class to create a graph data structure
public class Graph {
    private int V;
    private LinkedList<Integer> adjLst[];

    //Function to create a graph, that takes in the number of vertices in a graph:
    public Graph(int v){
        V = v;
        for(int i = 0; i < v; i++){
            adjLst[i] = new LinkedList();
        }

    }
    //add edges to the graph:
    void addEdge(int v, int w){
        adjLst[v].add(w);

    }


}
