package com.javaprojects.DynamicProgramming;

import com.javaprojects.DynamicProgramming.Controller.*;
import com.javaprojects.DynamicProgramming.Model.ListNode;
import com.javaprojects.DynamicProgramming.Model.TreeNode;
import com.javaprojects.DynamicProgramming.View.GraphTraversal;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

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

        System.out.println("TESTING 1290. Convert Binary Number in a Linked List to Integer... ");
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(1);
        head.setNext(head1);
        head1.setNext(head2);
        ConvertBinaryNumberIntoInteger convertBinaryNumberIntoInteger = new ConvertBinaryNumberIntoInteger();
        System.out.println(convertBinaryNumberIntoInteger.getDecimalValue(head));

        System.out.println("TESTING 2. Add Two Numbers...");
        ListNode l1 = new ListNode(2);
        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l2_1 = new ListNode(6);
        ListNode l2_2 = new ListNode(4);
        l1.setNext(l1_1);
        l1_1.setNext(l1_2);
        l2.setNext(l2_1);
        l2_1.setNext(l2_2);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        System.out.println(addTwoNumbers.addTwoNumbers(l1, l2));

        System.out.println("Depth First Search Traversal!");
        //creating a graph
        String[][] matrix = {{"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"}};
        GraphTraversal graphTraversal = new GraphTraversal();
        graphTraversal.DFS(matrix);
        System.out.println("TESTING 733. Flood Fill");
        //Test case:
        int[][] image = {{1,1,1}, {1,1,0}, {1,0,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        //Create an instance of the flood fill class:
        FloodFill floodFill = new FloodFill();
        System.out.println(Arrays.toString(floodFill.floodFill(image,sr,sc,newColor)));
        System.out.println("END OF TESTING...");
    }
}

