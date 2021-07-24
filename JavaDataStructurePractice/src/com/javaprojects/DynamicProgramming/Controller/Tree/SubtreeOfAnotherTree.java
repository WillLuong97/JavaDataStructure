package com.javaprojects.DynamicProgramming.Controller.Tree;

import com.javaprojects.DynamicProgramming.Model.TreeNode;

/*
* Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

Example 1:

Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

* Example 2:

Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104
*
*
* Approach: we will traverse the 2 tree using dfs recursively to check if they are both equals to each other or not.
* 2 recursive function:
*   1. outer recursion is to traverse the super tree to find the node that is equal to the sub_tree
*   2. once we have found the node that are equals to the sub_tree root, the second recursion is used to
* find all descendant element from the super tree and compare it with all the child from the subtree, to see if they are equals to each other
*  We return false, if any point during the traversal in the 2nd recursion that we found a mismatch. Otherwise, return true if we can make it to
* end of both traversal.
*
*
*
*  */

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //base case: the super tree is empty or there are not element to compare
        if(root == null){
            return false;
        }

        //if we have found the equal node in both tree, pass it into the 2nd recursion
        if(isIdentical(root, subRoot)){
            return true;
        }
        //otherwise, traverse the super tree both left and right to find the node that is equal to the root of the sub tree
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));

    }
    //2nd recursive function to compare each node in the sub tree of both tree
    private boolean isIdentical(TreeNode curr_root, TreeNode curr_sub_root){

        //correct case: both tree can make it to the end without hitting a false case.
        //each elements are equal and the number of child node between each tree is the same.
        if(curr_root == null && curr_sub_root == null) {
            return true;
        }

        if(curr_root == null || curr_sub_root == null){
            //Found a mismatch in the number of node in each of the subtree
            return false;
        }

        if(curr_root.val != curr_sub_root.val){
            return false;
        }

        //recursively check for all other element in the left and right sub tree
        return isIdentical(curr_root.left, curr_sub_root.left) && isIdentical(curr_root.right, curr_sub_root.right);
    }
}
