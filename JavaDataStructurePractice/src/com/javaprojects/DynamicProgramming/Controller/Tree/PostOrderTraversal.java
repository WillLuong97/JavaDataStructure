package com.javaprojects.DynamicProgramming.Controller.Tree;

import com.javaprojects.DynamicProgramming.Model.TreeNode;

import java.util.*;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        //base case: empty tree, would return an emty list
        if(root == null){
            return new ArrayList<>();
        }

        //Create a queue to store the node that we would need to process each time
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();

        //pass the current node onto to the queue to start the traversal
        if(root != null){
            stack.add(root);
        }
        while(!(stack.isEmpty())){
            TreeNode curr_node = stack.peek();
            //check to see if the current node has a left or right subtree or not
            if(curr_node.left != null){
                stack.add(curr_node.left);
                curr_node.left = null;
            }
            else if(curr_node.right != null){
                stack.add(curr_node.right);
                curr_node.right = null;
            }
            else{
                stack.pop();
                result.add(curr_node.val);
            }
        }

        return result;

    }

}
