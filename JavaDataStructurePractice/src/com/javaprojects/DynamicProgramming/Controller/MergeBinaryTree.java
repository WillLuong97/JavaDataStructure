package com.javaprojects.DynamicProgramming.Controller;

import com.javaprojects.DynamicProgramming.Model.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Stack;

/*
You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.
Example 1:
Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
Output: [3,4,5,5,4,null,7]
Example 2:

Input: root1 = [1], root2 = [1,2]
Output: [2,2]
Constraints:

The number of nodes in both trees is in the range [0, 2000].
-104 <= Node.val <= 104

Approach using recursion:
We will traverse the two tree using the preorder traversal algorithm, and use tree 1 to be updated and returned at the end.
As we go through both tree, if the two nodes are both not null, then sum them up and updated the current node in tree one with the sum. On
the other hand, if one of them is null then we will update the current node with the other children that is not null

Time complexity: O(n), where n is the number of tree node needed to be traversed
Space complexity: O(n), where n is the depth of the recursion stack
* */
public class MergeBinaryTree {
    //Recursive approach:
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //checking if the current node is null or not
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        root1.val += root2.val;
        root1.setLeft(mergeTrees(root1.getLeft(), root2.getLeft()));
        root1.setRight(mergeTrees(root1.getRight(), root2.getRight()));

        return root1;
    }

    //Iterative approach:
    /* Create a stack to store a pair of tree node from both tree. Then at each iteration
    * we will take turn popping the pair and compare them, if they both have values then we will
    * sum them up and update the node in tree 1, otherwise, if one of them is null so we will mark the
    * children of tree 1 to be the node that is not null
    * Time complexity: O(n), where n is the number of tree node needed to be traversed
       Space complexity: O(n), where n is the sizes of the stack we created.
 */
    public TreeNode mergeTrees_ITERATIVE(TreeNode root1, TreeNode root2){
        if(root1 == null){
            return root2;
        }

        //create a stack to keep track of the node from the preorder traversal in both trees
        Stack<TreeNode[]> stack = new Stack<>();
        //push the two new elements onto the stack:
        stack.push(new TreeNode[]{root1, root2});
        //if the stack is not empty, keep popping element from the list and
        //comparing them
        while(!stack.isEmpty()){
            TreeNode[] t = stack.pop();
            if(t[0] == null || t[1] == null){
                continue;
            }
            //if bot the element are not null, then we will sum them up
            t[0].val += t[1].val;
            if(t[0].getLeft() == null){
                t[0].setLeft(t[1].getLeft());
            } else {
                //pushing a new pairs of left nodes from tree 1 and 2
                stack.push(new TreeNode[]{t[0].getLeft(), t[1].getLeft()});
            }
            if(t[1].getLeft() == null){
                t[1].setLeft(t[0].getLeft());
            } else {
                //pushing a new pairs of left nodes from tree 1 and 2
                stack.push(new TreeNode[]{t[0].getRight(), t[1].getRight()});
            }
        }
        return root1;
    }
}
