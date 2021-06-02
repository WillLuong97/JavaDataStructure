package com.javaprojects.DynamicProgramming;

import com.javaprojects.DynamicProgramming.BackTracking.RestoreIPAddresses;
import com.javaprojects.DynamicProgramming.Controller.*;
import com.javaprojects.DynamicProgramming.Controller.BinarySearch.TimeMap;
import com.javaprojects.DynamicProgramming.Controller.DynamicProgrammingProblems.*;
import com.javaprojects.DynamicProgramming.Controller.Graph.CloneGraph;
import com.javaprojects.DynamicProgramming.Controller.Graph.GameOfLife;
import com.javaprojects.DynamicProgramming.Controller.Graph.NetworkDelayTime;
import com.javaprojects.DynamicProgramming.Controller.Graph.ProductGrouping;
import com.javaprojects.DynamicProgramming.Controller.Greedy.BinaryStringContiguosOne;
import com.javaprojects.DynamicProgramming.Controller.HeapProblem.SeatManager;
import com.javaprojects.DynamicProgramming.Controller.HeapProblem.TaskOrder;
import com.javaprojects.DynamicProgramming.Controller.Tree.BinaryTreeMinDepth;
import com.javaprojects.DynamicProgramming.Controller.Tree.MaximumLevelSumOfATree;
import com.javaprojects.DynamicProgramming.Model.GraphNode;
import com.javaprojects.DynamicProgramming.Model.ListNode;
import com.javaprojects.DynamicProgramming.Model.TreeNode;
import com.javaprojects.DynamicProgramming.View.GraphTraversal;
import com.sun.source.tree.Tree;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        System.out.println(Arrays.toString(findTheBall.findBall(grid)));
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
        System.out.println(Objects.toString(addTwoNumbers.addTwoNumbers(l1, l2)));

//        System.out.println("Depth First Search Traversal!");
//        creating a graph
//        String[][] matrix = {{"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"}};
//        GraphTraversal graphTraversal = new GraphTraversal();
//        graphTraversal.DFS(matrix);

        System.out.println("TESTING 733. Flood Fill");
        //Test case:
        int[][] image = {{1,1,1}, {1,1,0}, {1,0,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        //Create an instance of the flood fill class:
        FloodFill floodFill = new FloodFill();
        System.out.println(Arrays.toString(floodFill.floodFill(image,sr,sc,newColor)));

        System.out.println("TESTING OUT FIZZBUZZ");
        //test cases:
        int n_0 = 3;
        int n_1 = 5;
        int n_2 = 15;
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(n_0));
        System.out.println(fizzBuzz.fizzBuzz(n_1));
        System.out.println(fizzBuzz.fizzBuzz(n_2));
        System.out.println("TESTING SUDOKU SOLVER");
        Sudoku sudoku = new Sudoku();
        //test cases:
        char[][] boards = {{'5','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'}, {'.','9','8','.','.','.','.','6','.'}, {'8','.','.','.','6','.','.','.','3'}, {'4','.','.','8','.','3','.','.','1'}, {'7','.','.','.','2','.','.','.','6'}, {'.','6','.','.','.','.','2','8','.'}, {'.','.','.','4','1','9','.','.','5'}, {'.','.','.','.','8','.','.','7','9'}};
        sudoku.printBoard(sudoku.getSudokuBoard(boards));
        System.out.println("");
        System.out.println("TESTING 1784. Check if Binary String Has at Most One Segment of Ones");
        BinaryStringContiguosOne binaryStringContiguosOne = new BinaryStringContiguosOne();
        //Test case:
        String s = "1001";
        String s_1 = "110";
        System.out.println(Objects.toString(binaryStringContiguosOne.checkOnesSegment(s)));
        System.out.println(Objects.toString(binaryStringContiguosOne.checkOnesSegment(s_1)));

        System.out.println("TESTING 1845. Seat Reservation Manager");
        SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
        System.out.println(seatManager.reserve());   // All seats are available, so return the lowest numbered seat, which is 1.
        System.out.println(seatManager.reserve());    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
        seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
        System.out.println(seatManager.reserve());    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
        System.out.println(seatManager.reserve());    // The available seats are [3,4,5], so return the lowest of them, which is 3.
        System.out.println(seatManager.reserve());    // The available seats are [4,5], so return the lowest of them, which is 4.
        System.out.println(seatManager.reserve());    // The only available seat is seat 5, so return 5.
        seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].


        System.out.println("TESTING 981. Time Based Key-Value Store");
        TimeMap kv = new TimeMap();
        kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
        System.out.println(kv.get("foo", 1));  // output "bar"
        System.out.println(kv.get("foo", 3)); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"
        kv.set("foo", "bar2", 4);
        System.out.println(kv.get("foo", 4)); // output "bar2"
        System.out.println(kv.get("foo", 5)); //output "bar2"

        System.out.println("TESTING 121. Best Time to Buy and Sell Stock");
        BuyAndSellStock buyAndSellStock = new BuyAndSellStock();
        //test cases:
        int[] prices = {7,1,5,3,6,4};
        int[] prices_1 = {7,6,4,3,1};
        System.out.println(Objects.toString(buyAndSellStock.maxProfit(prices)));
        System.out.println(Objects.toString(buyAndSellStock.maxProfit(prices_1)));

        System.out.println("TESTING 111. Minimum Depth of Binary Tree");
        BinaryTreeMinDepth binaryTreeMinDepth = new BinaryTreeMinDepth();
        //test cases:
        //root = [3,9,20,null,null,15,7]
        TreeNode tRoot = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        tRoot.setLeft(nine);
        tRoot.setRight(twenty);
        twenty.setLeft(fifteen);
        twenty.setRight(seven);
        System.out.println(Objects.toString(binaryTreeMinDepth.minDepth(tRoot)));

        System.out.println("TESTING 743. Network Delay Time...");
        //Test case:
        int[][] times = {{2,1,1}, {2,3,1}, {3,4,1}};
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();

        System.out.println(Objects.toString(networkDelayTime.networkDelayTime(times, 4, 2)));

        System.out.println("TESTING 93. Restore IP Addresses...");
        String ip_1 = "25525511135";
        String ip_2 = "0000";
        String ip_3 = "1111";
        String ip_4 = "010010";
        String ip_5 = "101023";
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        System.out.println(Objects.toString(restoreIPAddresses.restoreIpAddresses(ip_1)));
        System.out.println(Objects.toString(restoreIPAddresses.restoreIpAddresses(ip_2)));
        System.out.println(Objects.toString(restoreIPAddresses.restoreIpAddresses(ip_3)));
        System.out.println(Objects.toString(restoreIPAddresses.restoreIpAddresses(ip_4)));
        System.out.println(Objects.toString(restoreIPAddresses.restoreIpAddresses(ip_5)));


        System.out.println("TESTING 32. Longest Valid Parentheses...");
        //TEST CASES:
        String valid_s = "(()";
        String valid_s_1 = ")()())";
        String valid_s_2 = "";

        LongestValidParenthese longestValidParenthese = new LongestValidParenthese();
        System.out.println(longestValidParenthese.longestValidParentheses(valid_s));
        System.out.println(longestValidParenthese.longestValidParentheses(valid_s_1));
        System.out.println(longestValidParenthese.longestValidParentheses(valid_s_2));


        //System.out.println("TESTING MAXIMUM LEVEL SUM OF A TREE...");
        //MaximumLevelSumOfATree maximumLevelSumOfATree = new MaximumLevelSumOfATree();
        System.out.println("TESTING 234. Palindrome Linked List...");
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        //Create a linked list:
        ListNode pal = new ListNode(1);
        ListNode pal_1 = new ListNode(2);
        ListNode pal_2 = new ListNode(2);
        ListNode pal_3 = new ListNode(1);
        pal.setNext(pal_1);
        pal_1.setNext(pal_2);
        pal_2.setNext(pal_3);
        System.out.println(palindromeLinkedList.isPalindrome(pal));

        System.out.println("TESTING FIND SMALLEST AND SECOND SMALLEST ELEMENT IN AN INTEGER ARRAY!");
        int[] test_1 = {12, 13, 1, 10, 3, 0};
        FindSmallestInArray findSmallestInArray = new FindSmallestInArray();
        System.out.println(findSmallestInArray.findFirstSmallest(test_1));
        System.out.println(findSmallestInArray.findSecondSmallest(test_1));


        System.out.println("TESTING 151. Reverse Words in a String");
        //test case:
        String test_str = "the sky is blue";
        String test_str_1 = "  hello world  ";
        String test_str_2 = "a good   example";
        String test_str_3 = "  Bob    Loves  Alice   ";
        String test_str_4 = "Alice does not even like bob";
        ReverseWordInAString reverseWordInAString = new ReverseWordInAString();
        System.out.println(reverseWordInAString.reverseWords(test_str));
        System.out.println(reverseWordInAString.reverseWords(test_str_1));
        System.out.println(reverseWordInAString.reverseWords(test_str_2));
        System.out.println(reverseWordInAString.reverseWords(test_str_3));
        System.out.println(reverseWordInAString.reverseWords(test_str_4));


        System.out.println("TESTING 133. Clone Graph...");
        //Test case:
        GraphNode node_1 = new GraphNode(1);
        GraphNode node_2 = new GraphNode(2);
        GraphNode node_3 = new GraphNode(3);
        GraphNode node_4 = new GraphNode(4);

        node_1.neighbors.add(node_2);
        node_1.neighbors.add(node_4);
        node_2.neighbors.add(node_1);
        node_2.neighbors.add(node_3);
        node_3.neighbors.add(node_2);
        node_3.neighbors.add(node_4);
        node_4.neighbors.add(node_1);
        node_4.neighbors.add(node_3);
        CloneGraph cloneGraph = new CloneGraph();
        System.out.println(cloneGraph.cloneGraph(node_1));

        System.out.println("TESTING 357. Count Numbers with Unique Digits...");
        //test case:
        int n_unique_1 = 2;
        int n_unique_2 = 0;
        CountNumberWithUniqueDigits countNumberWithUniqueDigits = new CountNumberWithUniqueDigits();
        System.out.println(countNumberWithUniqueDigits.countNumbersWithUniqueDigits(n_unique_1));
        System.out.println(countNumberWithUniqueDigits.countNumbersWithUniqueDigits(n_unique_2));
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        int[][] board_2 = new int[][]{{1,1},{1,0}};
        GameOfLife gameOfLife = new GameOfLife();
        //gameOfLife.gameOfLife(board);
        //System.out.println(board);
        //gameOfLife.gameOfLife(board_2);
        //System.out.println(board_2);

        System.out.println("TESTING 1641. Count Sorted Vowel Strings...");
        //test case:
        CountSortedVowelString countSortedVowelString = new CountSortedVowelString();
        System.out.println(countSortedVowelString.countVowelStrings(1));
        System.out.println(countSortedVowelString.countVowelStrings(2));
        System.out.println(countSortedVowelString.countVowelStrings(33));
        System.out.println("");
        System.out.println(countSortedVowelString.countVowelStrings_MEMOIZATION(1));
        System.out.println(countSortedVowelString.countVowelStrings_MEMOIZATION(2));
        System.out.println(countSortedVowelString.countVowelStrings_MEMOIZATION(33));

        System.out.println("TESTING PRODUCT ID GROUPING...");
        List<List<Integer>> test_input_1 = Arrays.asList(Arrays.asList(1,2), Arrays.asList(2,5), Arrays.asList(3,4), Arrays.asList(4,6), Arrays.asList(6,8), Arrays.asList(5,7), Arrays.asList(5,2), Arrays.asList(5,2));
        ProductGrouping productGrouping = new ProductGrouping();
        System.out.println(productGrouping.productGroups(test_input_1));

        System.out.println("TESTING 1834. Single-Threaded CPU...");
        //test case:
        //tasks = [[1,2],[2,4],[3,2],[4,1]]
        //tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]
        int[][] tasks_1 = new int[][]{{1,2}, {2,4}, {3,2}, {3,1}};
        int[][] tasks_2 = new int[][]{{7,10}, {7,12}, {7,5}, {7,4}, {7,2}};
        TaskOrder taskOrder = new TaskOrder();
        System.out.println(taskOrder.getOrder(tasks_1));
        System.out.println(taskOrder.getOrder(tasks_2));

        System.out.println("TESTING COUNT SUBMATRICES WITH ALL ONES...");
        //TEST Case:
        int[][] mat_1 = new int[][] {{1,0,1}, {1,1,0}, {1,1,0}};
        int[][] mat_2 = new int[][]{{0,1,1,0}, {0,1,1,1}, {1,1,1,0}};
        int[][] mat_3 = new int[][]{{1,1,1,1,1,1}};
        int[][] mat_4 = new int[][]{{1,0,1}, {0,1,0}, {1,0,1}};

        CountSubMatricesWithAllOnes countSubMatricesWithAllOnes = new CountSubMatricesWithAllOnes();
        System.out.println(countSubMatricesWithAllOnes.numSubmat(mat_1));
        System.out.println(countSubMatricesWithAllOnes.numSubmat(mat_2));
        System.out.println(countSubMatricesWithAllOnes.numSubmat(mat_3));
        System.out.println(countSubMatricesWithAllOnes.numSubmat(mat_4));

        System.out.println("TESTING 204. Count Primes...");
        //test cases:
        int limit_1 = 10;
        int limit_2 = 0;
        int limit_3 = 1;
        CountPrime countPrime = new CountPrime();
        System.out.println(countPrime.countPrimes(limit_1));
        System.out.println(countPrime.countPrimes(limit_2));
        System.out.println(countPrime.countPrimes(limit_3));
        System.out.println("END OF TESTING...");
    }
}
