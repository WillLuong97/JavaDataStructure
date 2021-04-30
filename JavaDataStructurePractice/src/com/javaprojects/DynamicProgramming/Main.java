package com.javaprojects.DynamicProgramming;

import com.javaprojects.DynamicProgramming.Controller.DivisorGame;
import com.javaprojects.DynamicProgramming.Controller.MergeBinaryTree;
import com.javaprojects.DynamicProgramming.Controller.WhereWillTheBallFall;
import com.javaprojects.DynamicProgramming.Model.TreeNode;

public class Main {
    public static void main(String[] args) {
        System.out.println("TESTING DIVISOR GAME...");
        //Test cases:
        int n = 2;
        DivisorGame divisorGame;
        divisorGame = new DivisorGame();
        System.out.println(divisorGame.divisorGame(n));
        System.out.println(divisorGame.divisorGame(3));
        System.out.println("");
        System.out.println("TESTING WHERE WILL THE BALL FALL...");
        //[[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
        WhereWillTheBallFall findTheBall;
        findTheBall = new WhereWillTheBallFall();
        int[][] grid = {{-1}};
        System.out.println(findTheBall.findBall(grid));
        System.out.println("END OF TESTING...");

        System.out.println("Creating a Binary Tree...");
        //Creating a binary tree:
        TreeNode root1;
        TreeNode root2;
        TreeNode child_1_1;
        TreeNode child_1_2;
        TreeNode child_1_3;

        TreeNode child_2_1;
        TreeNode child_2_2;
        TreeNode child_2_3;
        TreeNode child_2_4;

        root1 = new TreeNode(1);
        root2 = new TreeNode(2);

        child_1_1 = new TreeNode(3);
        child_1_2 = new TreeNode(2);
        child_1_3 = new TreeNode(5);

        child_2_1 = new TreeNode(1);
        child_2_2 = new TreeNode(3);
        child_2_3 = new TreeNode(4);
        child_2_4 = new TreeNode(7);
        //the first tree
        root1.setLeft(child_1_1);
        root1.setRight(child_1_2);
        child_1_1.setLeft(child_1_3);
        //the second tree:
        root2.setLeft(child_2_1);
        root2.setRight(child_2_2);
        child_2_1.setRight(child_2_3);
        child_2_2.setRight(child_2_4);

        System.out.println("TESTING  Merge Two Binary Trees...");
        MergeBinaryTree mergeBinaryTree = new MergeBinaryTree();
        System.out.println(mergeBinaryTree.mergeTrees(root1, root2));
        System.out.println("TESTING MERGE TWO BINARY TREES ITERATIVE...");
        MergeBinaryTree mergeBinaryTreeIterative = new MergeBinaryTree();
        System.out.println(mergeBinaryTreeIterative.mergeTrees_ITERATIVE(root1, root2));
        System.out.println("END OF TESTING...");
    }
}

