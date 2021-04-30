package com.javaprojects.DynamicProgramming.Model;
//Definition of a tree node:
public class TreeNode {
    //declaring attributes for a tree node:
    //value of the node
    public int val;
    //left and right pointer to the next nodes
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getRight() {
        return right;
    }
}

