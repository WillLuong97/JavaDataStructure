package com.javaprojects.DynamicProgramming.Controller.Tree;

import com.javaprojects.DynamicProgramming.Model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*Approach: we will BFS to look calculate the sum of all node in each level and then compare them together to find the
* level with the largest sum  */
public class MaximumLevelSumOfATree {
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        //queue to keep track of each node in the current level:
        Queue<TreeNode> queue = new LinkedList<>();
        //push the root node onto the queue:
        queue.add(root);

        int level = 0;
        int resLevel = 0, maxSum = Integer.MIN_VALUE;
        //if the queue is not empty so we will pop elemnt out of the loop
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            int sum = 0;
            //loop through all node currently in the list:
            for(int node = 0; node < size; node++){
                //getting the current node out from the queue:
                TreeNode curr_node = queue.poll();
                sum += curr_node.val;
                //add the children of the current node onto the queue again
                if(curr_node.left != null){
                    queue.add(curr_node.left);
                }
                if(curr_node.left != null){
                    queue.add(curr_node.right);
                }
            }
            //overried the level sum to make sure that we are always with the level with the highest sum
            if(sum > maxSum){
                maxSum = sum;
                resLevel = level;
            }

        }

        return resLevel;

    }

}

