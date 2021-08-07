package com.javaprojects.DynamicProgramming;

import com.javaprojects.DynamicProgramming.Controller.AmazonOA.DynamicProgramming.AssemblyLineScheduling;
import com.javaprojects.DynamicProgramming.Controller.AmazonOA.DynamicProgramming.UniquePath;
import com.javaprojects.DynamicProgramming.Controller.AmazonOA.MinCostOfConnectionForAllNodes;
import com.javaprojects.DynamicProgramming.Controller.BackTracking.*;
import com.javaprojects.DynamicProgramming.Controller.*;
import com.javaprojects.DynamicProgramming.Controller.BinarySearch.FindPeakElement;
import com.javaprojects.DynamicProgramming.Controller.BinarySearch.TimeMap;
import com.javaprojects.DynamicProgramming.Controller.BitProblem.CircularPermutation;
import com.javaprojects.DynamicProgramming.Controller.DynamicProgrammingProblems.*;
import com.javaprojects.DynamicProgramming.Controller.ExpediaInterview.DeliveryManagementSystem;
import com.javaprojects.DynamicProgramming.Controller.ExpediaInterview.DiagonalTraversalOfBinaryTree;
import com.javaprojects.DynamicProgramming.Controller.Graph.*;
import com.javaprojects.DynamicProgramming.Controller.Greedy.*;
import com.javaprojects.DynamicProgramming.Controller.HeapProblem.*;
import com.javaprojects.DynamicProgramming.Controller.LinkedListProblem.*;
import com.javaprojects.DynamicProgramming.Controller.Tree.*;
import com.javaprojects.DynamicProgramming.Model.GraphNode;
import com.javaprojects.DynamicProgramming.Model.ListNode;
import com.javaprojects.DynamicProgramming.Model.TreeNode;
import com.javaprojects.DynamicProgramming.View.LevelOrderTreeTraversal;
import com.sun.source.tree.Tree;
//import com.sun.java.accessibility.util.TopLevelWindowListener;
//import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

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
//        //Creating a binary tree:
//        TreeNode root1;
//        TreeNode root2;
//        TreeNode child_1_1;
//        TreeNode child_1_2;
//        TreeNode child_1_3;
//
//        TreeNode child_2_1;
//        TreeNode child_2_2;
//        TreeNode child_2_3;
//        TreeNode child_2_4;
//
//        root1 = new TreeNode(1);
//        root2 = new TreeNode(2);
//
//        child_1_1 = new TreeNode(3);
//        child_1_2 = new TreeNode(2);
//        child_1_3 = new TreeNode(5);
//
//        child_2_1 = new TreeNode(1);
//        child_2_2 = new TreeNode(3);
//        child_2_3 = new TreeNode(4);
//        child_2_4 = new TreeNode(7);
        //the first tree
//        root1.setLe(child_1_1);
//        root1.setRight(child_1_2);
//        child_1_1.setLeft(child_1_3);
//        //the second tree:
//        root2.setLeft(child_2_1);
//        root2.setRight(child_2_2);
//        child_2_1.setRight(child_2_3);
//        child_2_2.setRight(child_2_4);

//        System.out.println("TESTING  Merge Two Binary Trees...");
//        MergeBinaryTree mergeBinaryTree = new MergeBinaryTree();
//        System.out.println(mergeBinaryTree.mergeTrees(root1, root2));
//        System.out.println("TESTING MERGE TWO BINARY TREES ITERATIVE...");
//        MergeBinaryTree mergeBinaryTreeIterative = new MergeBinaryTree();
//        System.out.println(mergeBinaryTreeIterative.mergeTrees_ITERATIVE(root1, root2));
//
        System.out.println("TESTING 1290. Convert Binary Number in a Linked List to Integer... ");
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(1);
        head.next = head1;
        head1.next = head2;
        ConvertBinaryNumberIntoInteger convertBinaryNumberIntoInteger = new ConvertBinaryNumberIntoInteger();
        System.out.println(convertBinaryNumberIntoInteger.getDecimalValue(head));

        System.out.println("TESTING 2. Add Two Numbers...");
        ListNode l1 = new ListNode(2);
        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l2_1 = new ListNode(6);
        ListNode l2_2 = new ListNode(4);
        l1.next = l1_1;
        l1_1.next = l1_2;
        l2.next = l2_1;
        l2_1.next = l2_2;
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

//        System.out.println("TESTING 111. Minimum Depth of Binary Tree");
//        BinaryTreeMinDepth binaryTreeMinDepth = new BinaryTreeMinDepth();
//        //test cases:
//        //root = [3,9,20,null,null,15,7]
//        TreeNode tRoot = new TreeNode(3);
//        TreeNode nine = new TreeNode(9);
//        TreeNode twenty = new TreeNode(20);
//        TreeNode fifteen = new TreeNode(15);
//        TreeNode seven = new TreeNode(7);
//        tRoot.setLeft(nine);
//        tRoot.setRight(twenty);
//        twenty.setLeft(fifteen);
//        twenty.setRight(seven);
//        System.out.println(Objects.toString(binaryTreeMinDepth.minDepth(tRoot)));

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
        pal.next = pal_1;
        pal_1.next = pal_2;
        pal_2.next = pal_3;
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

        System.out.println("TESTING 322. Coin Change");
        int[] coins = new int[]{1,2,5};
        int amount = 11;

        int[] coins_2 = new int[]{2};
        int amount_2 = 3;

        int[] coins_3 = new int[]{1};
        int amount_3 = 1;

        int[] coins_4 = new int[]{1};
        int amount_4 = 2;

        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins, amount));
        System.out.println(coinChange.coinChange(coins_2, amount_2));
        System.out.println(coinChange.coinChange(coins_3, amount_3));
        System.out.println(coinChange.coinChange(coins_4, amount_4));

        //TESTING Inorder Successor In a BST
        System.out.println("TESING INORDER SUCCESSOR OF A TARGET IN A BINARY SEARCH TREE...");
        //test tree
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        InorderSuccessor inorderSuccessor = new InorderSuccessor();
        System.out.println(inorderSuccessor.inorderSuccessor(root, 8));

        //TESING Merge in between linked list:
        System.out.println("TESTING MERGE IN BETWEEN LINKED LIST...");
        //creating a linked list:
        ListNode merge_0 = new ListNode(0);
        ListNode merge_1 = new ListNode(1);
        ListNode merge_2 = new ListNode(2);
        ListNode merge_3 = new ListNode(3);
        ListNode merge_4 = new ListNode(4);
        ListNode merge_5 = new ListNode(5);
        merge_0.next = merge_1;
        merge_1.next = merge_2;
        merge_3.next = merge_4;
        merge_4.next = merge_5;
        ListNode list_0 = new ListNode(1000000);
        ListNode list_1 = new ListNode(1000001);
        ListNode list_2 = new ListNode(1000002);
        list_0.next = list_1;
        list_1.next = list_2;

        MergeInBetweenLinkedList mergeInBetweenLinkedList = new MergeInBetweenLinkedList();
//        System.out.println(mergeInBetweenLinkedList.mergeInBetween(merge_0, 3, 4, list_0));

        System.out.println("TESTING ROTATE IMAGE...");
        RotateImage rotateImage = new RotateImage();

        //test cases:
        int[][] matrix_1 = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix_2 = new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        int[][] matrix_3 = new int[][]{{1}};
        int[][] matrix_4 = new int[][]{{1,2}, {3,4}};


        rotateImage.rotate(matrix_1);
        System.out.println(Arrays.deepToString(matrix_1));
        rotateImage.rotate(matrix_2);
        System.out.println(Arrays.deepToString(matrix_2));
        rotateImage.rotate(matrix_3);
        System.out.println(Arrays.deepToString(matrix_3));
        rotateImage.rotate(matrix_4);
        System.out.println(Arrays.deepToString(matrix_4));

        System.out.println("TESTING PERMUTATIONS...");
        //TEST CASE:
        int[] perm_test_1 = new int[]{1,2,3};
        int[] perm_test_2 = new int[]{0,1};
        int[] perm_test_3 = new int[]{1};
//        GeneratePermutation generatePermutation = new GeneratePermutation();
//        System.out.println(generatePermutation.permute(perm_test_1));
//        System.out.println(generatePermutation.permute(perm_test_2));
//        System.out.println(generatePermutation.permute(perm_test_3));

        System.out.println("TESTING 887. 1884. Egg Drop With 2 Eggs and N Floors...");
        //Generate test cases:
        int floor_1 = 2;
        int floor_2 = 100;
        EggDrop eggDrop = new EggDrop();
        System.out.println(eggDrop.twoEggDrop(floor_1));
        System.out.println(eggDrop.twoEggDrop(floor_2));

//        //TESTING INORDER SUCCESSOR OF A BINARY SEARCH TREE
//        System.out.println("TESTING Inorder Successor in Binary Search Tree...");
//        //create a test tree:
//        TreeNode bst_root = new TreeNode(20);
//        bst_root.right = new TreeNode(22);
//        bst_root.left = new TreeNode(8);
//        bst_root.left.left = new TreeNode(4);
//        bst_root.left.right = new TreeNode(12);
//        bst_root.left.right.left = new TreeNode(10);
//        bst_root.left.right.right = new TreeNode(14);
//        InorderSuccessorInBST inorderSuccessorInBST = new InorderSuccessorInBST();
//        System.out.println(inorderSuccessorInBST.inorderSuccessor(bst_root, 8).val);
//        System.out.println(inorderSuccessorInBST.inorderSuccessor(bst_root, 10).val);
//        System.out.println(inorderSuccessorInBST.inorderSuccessor(bst_root, 14).val);

        System.out.println("TESTING 1019. Next Greater Node In Linked List...");
        //Test case:
        ListNode greaterNode = new ListNode(2);
        greaterNode.next = new ListNode(1);
        greaterNode.next = new ListNode(5);
        NextGreaterNode nextGreaterNode = new NextGreaterNode();
        System.out.println(nextGreaterNode.nextLargerNodes(greaterNode));


        ListNode greaterNode_1 = new ListNode(2);
        greaterNode_1.next = new ListNode(1);
        greaterNode_1.next = new ListNode(5);
        System.out.println(nextGreaterNode.nextLargerNodes(greaterNode_1));


        ListNode greaterNode_2 = new ListNode(2);
        greaterNode_2.next = new ListNode(1);
        greaterNode_2.next = new ListNode(5);
        System.out.println(nextGreaterNode.nextLargerNodes(greaterNode_2));

        //TESTING PRODUCT OF ARRAY EXCEPT FOR ITSELF
        System.out.println("TESTING 238. Product of Array Except Self...");
        //test case:
        int[] prodNum_1 = new int[]{1,2,3,4};
        int[] prodNums_2 = new int[]{-1,1,0,-3,3};
        ProductOfArrayWithoutItself productOfArrayWithoutItself = new ProductOfArrayWithoutItself();
        System.out.println(Arrays.toString(productOfArrayWithoutItself.productExceptSelf(prodNum_1)));
        System.out.println(Arrays.toString(productOfArrayWithoutItself.productExceptSelf(prodNums_2)));
        System.out.println("TESTING THE FUNCTION WITH O(1) CONSTANT SPACE...");
        System.out.println(Arrays.toString(productOfArrayWithoutItself.productExceptSelf_NO_EXTRA_SPACE(prodNum_1)));
        System.out.println(Arrays.toString(productOfArrayWithoutItself.productExceptSelf_NO_EXTRA_SPACE(prodNums_2)));


        System.out.println("********Graph DFS Practice Problem ****************");
        System.out.println("Printing out all word in a 2d matrix using DFs.....");
//        char[][] word_arr = new char[][] {{'A', 'B', 'C', 'F'}, {'D', 'E', 'O', 'P'}, {'Q', 'U', 'E','T'}, {'Y', 'I', 'X', 'L'}};
        int [][] int_matrix = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        DFS dfs = new DFS();
        dfs.printDFS(int_matrix);

        System.out.println("TESTING 17. Letter Combinations of a Phone Number...");
        //test cases:
        String digits = "23";
        String digits_1 = "";
        LetterCombinationsOFAPhoneNumber letterCombinationsOFAPhoneNumber = new LetterCombinationsOFAPhoneNumber();
        System.out.println(letterCombinationsOFAPhoneNumber.letterCombinations(digits));
        System.out.println(letterCombinationsOFAPhoneNumber.letterCombinations(digits_1));

        //Sorting algorithm using a HEAP
        System.out.println("TESTING SORTING ALGORITHM USING A HEAP...");
        //TEST CASES:
        int[] sort_1 = new int[]{5,1,7,8,2,0};
        int[] sort_2 = new int[]{};
        int[] sort_3 = new int[]{5,1,1,8,2,0};
        SortThroughHeap sortThroughHeap = new SortThroughHeap();
        sortThroughHeap.sortWithHeap(sort_1);
        sortThroughHeap.sortWithHeap(sort_2);
        sortThroughHeap.sortWithHeap(sort_3);
        System.out.println(Arrays.toString(sort_1));
        System.out.println(Arrays.toString(sort_2));
        System.out.println(Arrays.toString(sort_3));

        System.out.println("TESTING FIND PEAK ELEMENT...");
        System.out.println("FIND PEAK ELEMENT IN A 2D GRID: ");
        //TEST CASES:
        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.findPeakGrid(new int[][] {{1,4}, {3,2}}));
        System.out.println(findPeakElement.findPeakGrid(new int[][] {{10,20,15}, {21,30,14}, {7,16,32}}));

        System.out.println("TESTING FIND SQUARE...");
        Test test = new Test();
        System.out.println(test.findSquare(5));
        System.out.println(test.findSquare(-1));


        System.out.println("TESTING 2D array summation under hour glass....");
        //test case:
        int[][] hourGlassTest = new int[][]{{-9, -9, -9,  1, 1, 1, }, {0, -9,  0,  4, 3, 2}, {-9, -9, -9,  1, 2, 3}, {0,  0,  8,  6, 6, 0}, {0,  0,  0, -2, 0, 0}, { 0,  0,  1,  2, 4, 0}};
        TwoDimnestionArrSummation twoDimnestionArrSummation = new TwoDimnestionArrSummation();
        System.out.println(twoDimnestionArrSummation.hourGlassSummation(hourGlassTest));

//        System.out.println("TESTING 1718. Construct the Lexicographically Largest Valid Sequence...");
        System.out.println("TESTING LEVEL ORDER TRAVERSAL...");
        LevelOrderTreeTraversal levelOrderTreeTraversal = new LevelOrderTreeTraversal();
        levelOrderTreeTraversal.printLevelOrderTraversal(root);

        System.out.println("TESTING BROWSER HISTORY...");
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));

        System.out.println("TESTING 1466. Reorder Routes to Make All Paths Lead to the City Zero...");
        //test case:
        int routes = 6;
        int[][] connection_1 = new int[][]{{0,1}, {1,3}, {2,3}, {4,0}, {4,5}};

        int routes_2 = 5;
        int[][] connection_2 = new int[][]{{1,0}, {1,2}, {3,2}, {3,4}};

        int routes_3 = 3;
        int[][] connection_3 = new int[][]{{1,0}, {2,0}};
        int routes_4 = 3;
        int[][] connection_4 = new int[][]{{1,2}, {2,0}};

        ReorderRoutes reorderRoutes = new ReorderRoutes();
        System.out.println(reorderRoutes.minReorder(routes, connection_1));
        System.out.println(reorderRoutes.minReorder(routes_2, connection_2));
        System.out.println(reorderRoutes.minReorder(routes_3, connection_3));
        System.out.println(reorderRoutes.minReorder(routes_4, connection_4));

        System.out.println("TESTING 491. Increasing Subsequences...");
        int[] test_num_sequence = new int[]{4,6,7,7};
        int[] test_num_sequence_2 = new int[]{4,4,3,2,1};

        IncreasingSubsequence increasingSubsequence = new IncreasingSubsequence();
        System.out.println(increasingSubsequence.findSubsequences(test_num_sequence));
        System.out.println(increasingSubsequence.findSubsequences(test_num_sequence_2));

        System.out.println("TESTING FIBONACCI SEQUENCE...");
        FibonacciSequence fibonacciSequence = new FibonacciSequence();

        System.out.println("********Brute force + Recursive Approach ********");
        System.out.println(fibonacciSequence.fib_RECURSION(2));
        System.out.println(fibonacciSequence.fib_RECURSION(3));
        System.out.println(fibonacciSequence.fib_RECURSION(4));

        System.out.println("*****Bottom Up Approach********");
        System.out.println(fibonacciSequence.fib_BOTTOM_UP(2));
        System.out.println(fibonacciSequence.fib_BOTTOM_UP(3));
        System.out.println(fibonacciSequence.fib_BOTTOM_UP(4));


//        System.out.println("TESTING PASCAL TRIANGLE...");
//
//        PascalTriangle pascalTriangle = new PascalTriangle();
//        System.out.println(pascalTriangle.generate(5));
//        System.out.println(pascalTriangle.generate(1));


        System.out.println("TESTING 110. Balanced Binary Tree...");

        //Test tree
        TreeNode balanced_root = new TreeNode(3);
        balanced_root.left = new TreeNode(9);
        balanced_root.right = new TreeNode(20);
        balanced_root.right.left = new TreeNode(15);
        balanced_root.right.right = new TreeNode(7);
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        System.out.println(balancedBinaryTree.isBalanced(balanced_root));


        System.out.println("TESTING MINIMUM COST TO CONNECT ALL SERVER TOGETHER...");
        MinCostOfConnectionForAllNodes minCostOfConnectionForAllNodes = new MinCostOfConnectionForAllNodes();
        minCostOfConnectionForAllNodes.findMinCostToConnectNodes_MAIN_CALLER();

//        findMinCostToConnectNodes_MAIN_CALLER();

        System.out.println("TESING 1238. Circular Permutation in Binary Representation...");

        int bitN = 2;
        int start = 3;

        int bitN_1 = 3;
        int start_1 = 2;

        CircularPermutation circularPermutation = new CircularPermutation();
        System.out.println(circularPermutation.circularPermutation(bitN, start));
        System.out.println(circularPermutation.circularPermutation(bitN_1, start_1));

        System.out.println("TESTING 1464. Maximum Product of Two Elements in an Array...");

        int[] test_nums_1 = new int[]{3,4,5,2};
        int[] test_nums_2 = new int[]{1,5,4,5};
        int[] test_nums_3 = new int[]{3,7};

        MaxProductOfTwoArrayElement maxProductOfTwoArrayElement = new MaxProductOfTwoArrayElement();
        System.out.println(maxProductOfTwoArrayElement.maxProduct(test_nums_1));
        System.out.println(maxProductOfTwoArrayElement.maxProduct(test_nums_2));
        System.out.println(maxProductOfTwoArrayElement.maxProduct(test_nums_3));

        System.out.println("TESTING RELATIVE RANKS...");
        RelativeRanks relativeRanks = new RelativeRanks();
        int[] score_1 = new int[]{5,4,3,2,1};
        int[] score_2 = new int[]{10,3,8,9,4};

        System.out.println(relativeRanks.findRelativeRanks(score_1).toString());
        System.out.println(relativeRanks.findRelativeRanks(score_2).toString());

        System.out.println("Testing Rotated Digits...");
        int rotated_digit_num = 10;
        RotatedDigits rotatedDigits = new RotatedDigits();
        System.out.println(rotatedDigits.rotatedDigits(rotated_digit_num));

        System.out.println("TESTING N-th Tribonacci Number...");
        int trib_n = 4;
        NthTribonacciNumber nthTribonacciNumber = new NthTribonacciNumber();
        System.out.println(nthTribonacciNumber.tribonacci(trib_n));
        System.out.println(nthTribonacciNumber.tribonacci(25));

        System.out.println("TESTING DEEPEST LEAVES SUM...");


        System.out.println("TESTING HASHSET DESIGN...");

         MyHashSet obj = new MyHashSet();
         obj.add(1);
         obj.add(2);
         obj.add(3);
         obj.remove(3);
         boolean param_3 = obj.contains(3);
        System.out.println(param_3);

        System.out.println("TESTING 547. Number of Provinces...");
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        //test case:
        int[][] test_graph_1 = new int[][]{{1,1,0}, {1,1,0}, {0,0,1}};
        int[][] test_graph_2 = new int[][]{{1,0,0}, {0,1,0}, {0,0,1}};

        System.out.println(numberOfProvinces.findCircleNum(test_graph_1));
        System.out.println(numberOfProvinces.findCircleNum(test_graph_2));

        System.out.println("TESTING 638. Shopping Offers...");
        List<Integer> shopping_price = new ArrayList<>();
        shopping_price.add(2);
        shopping_price.add(5);

        List<List<Integer>> store_offers = new ArrayList<>();
        List<Integer> offer_1 = new ArrayList<>();
        List<Integer> offer_2 = new ArrayList<>();
        offer_1.add(3);
        offer_1.add(0);
        offer_1.add(5);

        offer_2.add(1);
        offer_2.add(2);
        offer_2.add(10);

        store_offers.add(offer_1);
        store_offers.add(offer_2);

        List<Integer> needs = new ArrayList<>();
        needs.add(3);
        needs.add(2);

        ShoppingOffer shoppingOffer = new ShoppingOffer();
        System.out.println(shoppingOffer.shoppingOffers(shopping_price, store_offers, needs));

        System.out.println("TESTING 1323. Maximum 69 Number...");

        Maximum69Number maximum69Number = new Maximum69Number();
        System.out.println(maximum69Number.maximum69Number(9669));
        System.out.println(maximum69Number.maximum69Number(9996));
        System.out.println(maximum69Number.maximum69Number(9999));

        System.out.println("TESTING 942. DI String Match...");

        DIStringMatch diStringMatch = new DIStringMatch();
        System.out.println(diStringMatch.diStringMatch("IDID"));
        System.out.println(diStringMatch.diStringMatch("III"));
        System.out.println(diStringMatch.diStringMatch("DDI"));

        System.out.println("TESTING 1338. Reduce Array Size to The Half...");
        ReduceArraySizeInHalf reduceArraySizeInHalf = new ReduceArraySizeInHalf();
        System.out.println(reduceArraySizeInHalf.minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
        System.out.println(reduceArraySizeInHalf.minSetSize(new int[]{7,7,7,7,7,7}));
        System.out.println(reduceArraySizeInHalf.minSetSize(new int[]{1,9}));

        System.out.println("TESTING 1646. Get Maximum in Generated Array...");

        MaximumInGeneratedArray maximumInGeneratedArray = new MaximumInGeneratedArray();
        System.out.println(maximumInGeneratedArray.getMaximumGenerated(7));
        System.out.println(maximumInGeneratedArray.getMaximumGenerated(2));
        System.out.println(maximumInGeneratedArray.getMaximumGenerated(3));

        System.out.println("TESTING DIAGONAL TRAVERSAL OF A BINARY TREE...");

        //build a tree
        TreeNode root_dia = new TreeNode(8);
        root_dia.left = new TreeNode(3);
        root_dia.right = new TreeNode(10);
        root_dia.left.left = new TreeNode(1);
        root_dia.right.left = new TreeNode(6);
        root_dia.right.left.left = new TreeNode(4);
        root_dia.right.left.right= new TreeNode(7);
        root_dia.right.right= new TreeNode(14);
        root_dia.right.right.left= new TreeNode(13);

        DiagonalTraversalOfBinaryTree diagonalTraversalOfBinaryTree = new DiagonalTraversalOfBinaryTree();
        diagonalTraversalOfBinaryTree.diagonalPrint(root_dia);

        System.out.println("TESTING Delivery Management System...");

        DeliveryManagementSystem deliveryManagementSystem = new DeliveryManagementSystem();

        System.out.println(deliveryManagementSystem.path(5, new int[]{1,2,2}, new int[]{2,3,4}, 1));
        System.out.println(deliveryManagementSystem.path(5, new int[]{1,1,2,3,1}, new int[]{2,3,4,5,5}, 1));
//        deliveryManagementSystem.path(5, new int[]{1,1,2,3,1}, new int[]{2,3,4,5,5}, 1);

        System.out.println("TESTING 947. Most Stones Removed with Same Row or Column...");
        System.out.println("ONGOING!!!");
//        MostStonesRemoved mostStonesRemoved = new MostStonesRemoved();
//        int[][] stones_1 = new int[][]{{0,0}, {0,1}, {1,0}, {1,2}, {2,1}, {2,2}};
//        int[][] stones_2 = new int[][]{{0,0}, {0,2}, {1,1}, {2,0}, {2,2}};
//        int[][] stones_3 = new int[][]{{0,0}};
//        System.out.println(mostStonesRemoved.removeStones(stones_1));
//        System.out.println(mostStonesRemoved.removeStones(stones_2));
//        System.out.println(mostStonesRemoved.removeStones(stones_3));

        System.out.println("TESTING 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts...");

        //test cases:
        MaximumAreaAfterCuts maximumAreaAfterCuts = new MaximumAreaAfterCuts();
        System.out.println(maximumAreaAfterCuts.maxArea(5,4,new int[] {1,2,4}, new int[] {1,3}));
        System.out.println(maximumAreaAfterCuts.maxArea(5,4,new int[] {3,1}, new int[] {1}));
        System.out.println(maximumAreaAfterCuts.maxArea(5,4,new int[] {3}, new int[] {3}));

        System.out.println("TESTING 1094. Car Pooling...");
        CarPooling carPooling = new CarPooling();
        System.out.println(carPooling.carPooling(new int[][] {{2,1,5}, {3,3,7}}, 4));
        System.out.println(carPooling.carPooling(new int[][] {{2,1,5}, {3,3,7}}, 5));
        System.out.println(carPooling.carPooling(new int[][] {{2,1,5}, {3,5,7}}, 3));
        System.out.println(carPooling.carPooling(new int[][] {{3,2,7}, {3,7,9},{8,3,9}}, 11));


        System.out.println("TESTING Assembly Line Scheduling...");

        AssemblyLineScheduling assemblyLineScheduling = new AssemblyLineScheduling();
        int a[][] = {{4, 5, 3, 2},
                   {2, 10, 1, 4}};
        int t[][] = {{0, 7, 4, 5},
                {0, 9, 2, 8}};
        int e[] = {10, 12}, x[] = {18, 7};

        System.out.println(assemblyLineScheduling.carAssembly(a, t, e, x, 4));

        System.out.println("TESTING 572. Subtree of Another Tree...");

        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
        //tests tree
        //Main Root
        TreeNode main_root = new TreeNode(3);
        main_root.left = new TreeNode(4);
        main_root.right = new TreeNode(5);
        main_root.left.left = new TreeNode(1);
        main_root.left.right = new TreeNode(2);

        //Sub root:
        TreeNode sub_root = new TreeNode(4);
        sub_root.left = new TreeNode(1);
        sub_root.right = new TreeNode(2);

        System.out.println(subtreeOfAnotherTree.isSubtree(main_root, sub_root));

        System.out.println("TESTING 141. Linked List Cycle...");

        ListNode cycle_head = new ListNode(3);
        ListNode index_1 = new ListNode(2);
        cycle_head.next = index_1;
        cycle_head.next = new ListNode(0);
        cycle_head.next = new ListNode(-4);
        cycle_head.next = index_1;

        LinkedListCycle linkedListCycle = new LinkedListCycle();
        System.out.println(linkedListCycle.hasCycle(cycle_head));

        System.out.println("TESTING 19. Remove Nth Node From End of List...");

        //TEST CASE:
        ListNode hTR = new ListNode(1);
        hTR.next = new ListNode(2);
        hTR.next = new ListNode(3);
        hTR.next = new ListNode(4);
        hTR.next = new ListNode(5);
        hTR.next = new ListNode(6);

        RemoveNthFromEndList rm = new RemoveNthFromEndList();
        System.out.println(rm.removeNthFromEnd(hTR, 2));

        System.out.println("TESTING ALIEN DICTIONARY...");
        AlienDictionary alienDictionary = new AlienDictionary();

        System.out.println(alienDictionary.alienOrder(new String[]{  "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        }));

        System.out.println(alienDictionary.alienOrder(new String[]{  "z",
                "x"
        }));

        System.out.println(alienDictionary.alienOrder(new String[]{  "z",
                "x",
                "z"
        }));

        System.out.println("1718. Construct the Lexicographically Largest Valid Sequence...");

        //Test cases:
        int n_lexi_1 = 3;
        int n_lexi_2 = 5;
//
//        ConstructLexicoLargestValidSequence constructLexicoLargestValidSequence = new ConstructLexicoLargestValidSequence();
//
//        System.out.println(Arrays.toString(constructLexicoLargestValidSequence.constructDistancedSequence(n_lexi_1)));
//        System.out.println(constructLexicoLargestValidSequence.constructDistancedSequence(n_lexi_2));

        System.out.println("TESTING 1405. Longest Happy String\n");

        LongestHappyString longestHappyString = new LongestHappyString();
        System.out.println(longestHappyString.longestDiverseString(1,1,7));
        System.out.println(longestHappyString.longestDiverseString(2,2,1));
        System.out.println(longestHappyString.longestDiverseString(7,1,0));


        System.out.println("TESTING LONGEST INCREASING SUBSEQUENCES...\n");

        //test cases:

        System.out.println("TESTING BINARY TREE POSTORDER TRAVERSAL...");

        TreeNode post_root = new TreeNode(1);
        post_root.right = new TreeNode(2);
        post_root.right.left = new TreeNode(3);
        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        System.out.println(postOrderTraversal.postorderTraversal(post_root));

        System.out.println("TESTING BINARY TREE PREORDER TRAVERSAL...");
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        System.out.println(preorderTraversal.preorderTraversal(post_root));

        System.out.println("382. Linked List Random Node...");
        ListNode head_randome = new ListNode(1);
        head_randome.next = new ListNode(2);
        head_randome.next = new ListNode(3);
        LinkedListRandomNode linkedListRandomNode = new LinkedListRandomNode(head_randome);
        System.out.println(linkedListRandomNode.getRandom());

        System.out.println("TESTING UNIQUE PATH...");

        //test case:
        UniquePath uniquePath = new UniquePath();
        System.out.println(uniquePath.uniquePaths(3,7));
        System.out.println(uniquePath.uniquePaths(3,2));
        System.out.println(uniquePath.uniquePaths(3,3));

        System.out.println("TESTING DIAMETER OF BINARY TREE...");
        TreeNode dia_1 = new TreeNode(1);
        dia_1.left = new TreeNode(2);
        dia_1.right = new TreeNode(3);
        dia_1.left.left = new TreeNode(4);
        dia_1.left.right = new TreeNode(5);

        BinaryTreeDiameter binaryTreeDiameter = new BinaryTreeDiameter();

        System.out.println(binaryTreeDiameter.diameterOfBinaryTree(dia_1));

        System.out.println("END OF TESTING...");
    }
}
