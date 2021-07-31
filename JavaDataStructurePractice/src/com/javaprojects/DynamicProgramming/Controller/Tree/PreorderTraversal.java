package com.javaprojects.DynamicProgramming.Controller.Tree;

import com.javaprojects.DynamicProgramming.Model.TreeNode;

import java.util.*;

/*
Given the root of a binary tree, return the preorder traversal of its nodes' values.



Example 1:


Input: root = [1,null,2,3]
Output: [1,2,3]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:


Input: root = [1,2]
Output: [1,2]
Example 5:


Input: root = [1,null,2]
Output: [1,2]


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100


Follow up: Recursive solution is trivial, could you do it iteratively?
*  */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        //base case: empty tree
        if(root == null){
            return new ArrayList<Integer>();
        }
        //create a queue to keep track of the processing tree node
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<Integer>();

        if(root != null){
            stack.add(root);
        }

        while(!(stack.isEmpty())){
            TreeNode curr_node = stack.pop();
            result.add(curr_node.val);
            if(curr_node.right != null){
                stack.add(curr_node.right);
            }
            if(curr_node.left != null){
                stack.add(curr_node.left);
            }
        }

        return result;
    }

}
