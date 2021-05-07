package com.javaprojects.DynamicProgramming.Controller.Tree;

import com.javaprojects.DynamicProgramming.Model.TreeNode;

import static java.lang.Math.min;

/*Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000

Approach:
use DFS - Preorder to traverse both left and right side of the tree, if the current node is empty so we will back out of the current recursion
and set them to the next recursion.
*  */
public class BinaryTreeMinDepth {
    int minDepthFound = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        //base case:
        if (root == null){
            return 0;
        }
        traverse(root, 0);
        return minDepthFound;
    }

    //function to traverse the tree using dfs
    public void traverse(TreeNode node, int depth){
        //base case: if the current node is empty so we will, so we will backout of this recursion
        if (node == null){
            return;
        }

        depth++;
        //if the current node is empty, the we compare to see which path is shorter and take that path
        if(node.getLeft() == null && node.getRight() == null){
            minDepthFound = min(minDepthFound, depth);
            return;
        }
        //traverse both left and right side of the tree
        traverse(node.getLeft(), depth);
        traverse(node.getRight(), depth);

    }


}
