package com.javaprojects.DynamicProgramming.View;

import com.javaprojects.DynamicProgramming.Model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTreeTraversal {
    //level order traversal:
    /*
    Function to traverse a tree using level order traversal using a queue
    We will take push each tree node onto the queue and pop them out to print its value and
    pushing its children sub tree onto the queue for further processing unitl the end

    Time complexity: O(n) is our worst case as the algorithm will have to run through all element in the tree node to print element out
    Space complexity: O(n), we have to allocate space for a queue to store its current treenode element
   */

    public void printLevelOrderTraversal(TreeNode root){
        //base case:
        if(root == null){
            System.out.print("Invalid TreeNode: root is empty!");
        }
        //create a queue to store the node of the tree
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();

        //add the root of the tree onto the queue
        treeNodeQueue.add(root);

        //keep popping and adding node onto the queue until the queue is completely empty
        while(!treeNodeQueue.isEmpty()){
            //pop the current node out of the queue for processing
            TreeNode curr_node = treeNodeQueue.poll();
            System.out.println(curr_node.val + " ");
            //add the child subtree of the left and right node if they are not null onto the queue
            if(curr_node.left != null){
                treeNodeQueue.add(curr_node.left);
            }

            if(curr_node.right != null){
                treeNodeQueue.add(curr_node.right);
            }

        }
    }
}
