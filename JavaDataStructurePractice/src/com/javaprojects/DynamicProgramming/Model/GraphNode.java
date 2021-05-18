package com.javaprojects.DynamicProgramming.Model;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    //attribute:
    public int val;
    public List<GraphNode> neighbors;
    public GraphNode(){
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val){
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int _val, List<GraphNode> _neighbors){
        val = _val;
        neighbors = _neighbors;
    }

}
