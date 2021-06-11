package com.javaprojects.DynamicProgramming.Controller.Tree;

import com.javaprojects.DynamicProgramming.Model.TreeNode;

/*
In Binary Search Tree, Inorder Successor of an input node can also be defined as the node with the smallest key greater than the key of the input node. So, it is sometimes important to find next node in sorted order.
Create a function to return inorder successor from the target value


Approach: we will use parent pointer

Since this is a BST, there are 2 case:
Case 1: if the target node has a right subtree, then the inorder successor would be the element on the leftmost
node

Case 2: if the target node does not have a left subtree, then the inorder successor would be the nearest
ancestor

*  */

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, int target){
        //create a function to find the target in the tree
        TreeNode target_node = findTarget(root, target);
        //base case: if the target node is not in the tree, then return the value
        if(target_node == null){
            //cant find target in the tree
            return null;
        }

        // ----CASE 1: The target node has a right subtree, therefore we will try to find the leftmost element in the right subtree
        if(target_node.right != null){
            return getLeftMost(target_node.right);
        }

        // ----CASE 2: The target node does not have a right subtree, so we will have to traverse up its ancestor to find the inorder successor
        else{
            //we will traverse from the root node down to the target node and at each iteration, we will check to see if the current
            //root node is the neareset greater than the root node
            TreeNode successor = null;
            TreeNode ancestor = root;
            while(ancestor != target_node){
                if(target_node.val < ancestor.val){
                    //then the inorder successor of the target should be on the right
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }
    }
    //helper method to find the left most node in a tree
    private TreeNode getLeftMost(TreeNode node){
        TreeNode tmp = node;
        while(tmp.left != null){
            tmp = tmp.left;
        }

        return tmp;

    }
    //helper method to find the tree node in a tree
    private TreeNode findTarget(TreeNode root, int target){
        if(root == null){
            return null;
        }
        //find the target in the tree
        if(root.val == target){
            return root;
        }
        //if the target is greater then the current node, then it should be on the right side of the current node
        else if(root.val < target){
            return findTarget(root.right, target);
        } else {
            return findTarget(root.left, target);
        }
    }
}
