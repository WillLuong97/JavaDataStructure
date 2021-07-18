package com.javaprojects.DynamicProgramming.Controller.ExpediaInterview;

import com.javaprojects.DynamicProgramming.Model.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Consider lines of slope -1 passing between nodes. Given a Binary Tree,
print all diagonal elements in a binary tree belonging to the same line.
all root.left element will be checked for the next level

Observation: every root.right would help us generate the diagonal line of the current tree nodes

Approach: we will create a hash map with the key being the level of each diagonal line and the value is the array of all node that are in the diagonal line.
While building the map, we will put all root.right element in the hashmap and for root.left we will increase to the next level
 */
public class DiagonalTraversalOfBinaryTree {
    public void diagonalPrint(TreeNode root){
        //BASE CASE: the tree is empty:
        if(root == null){
            throw new RuntimeException("Invalid Input: Tree is empty!");
        }

        //create a hashmap to store all diagonal element in the array
        HashMap<Integer, List<Integer>> diagonalNode = new HashMap<>();

        diagonalPrintUtil(root, 0, diagonalNode);

        System.out.println("The diagonal node in the tree is: ");

        //loop through the hashmap and display the diagonal line found
        for(Map.Entry<Integer, List<Integer>> diagonalFound : diagonalNode.entrySet()){
            System.out.println(diagonalFound.getValue());
        }

    }

    //helper method to build out the map
    private void diagonalPrintUtil(TreeNode node, int level, HashMap<Integer, List<Integer>> diagonalMap){
        //check to see if the current node is valid or not
        if(node == null){
            return;
        }

        //build out the hashmap:
        //array to store the diagonal nodes
        //extracting the current set of diagonal node from the map first
        List<Integer> diagonal_nodes = diagonalMap.get(level);
        //if the current diagonal node is null, meaning that there are no diagonal element found for this
        //
        if(diagonal_nodes == null){
            diagonal_nodes = new ArrayList<>();
            diagonal_nodes.add(node.val);
        }
        //if it already have element, then we append new element into it
        else{
            diagonal_nodes.add(node.val);
        }
        //put it into the hashmap
        diagonalMap.put(level, diagonal_nodes);

        //branch out to the next level, if the current node has a left element
        diagonalPrintUtil(node.left, level + 1, diagonalMap);

        //if the current element has a right, just keep moving right
        diagonalPrintUtil(node.right, level, diagonalMap);

    }
}
