package com.javaprojects.DynamicProgramming.Controller.Tree;

import com.javaprojects.DynamicProgramming.Model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the root of a binary tree, return the sum of values of its deepest leaves.

Example 1:

Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15

Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100


BFS + Queue
*  */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        //base case: the input tree is empty
        if(root == null){
            return 0;
        }

        //create a queue to keep track of each element in the tree until we find the deepest node
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        //push the root node onto the queue to initialize its value
        q.add(root);
        int result = 0;
        while(!q.isEmpty()){
            //getting the current level of the queue to know how many elements left in the queue that we must pull out of it
            int size = q.size();
            result = 0;

            while(size > 0){
                size--;
                TreeNode curr_node = q.poll();
                result += curr_node.val;

                if(curr_node.left != null){
                    q.add(curr_node.left);
                }

                if(curr_node.right != null){
                    q.add(curr_node.right);
                }
            }

        }
        return result;
    }



}
