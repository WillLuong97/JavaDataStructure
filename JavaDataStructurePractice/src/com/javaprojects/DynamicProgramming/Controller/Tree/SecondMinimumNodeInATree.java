package com.javaprojects.DynamicProgramming.Controller.Tree;

import com.javaprojects.DynamicProgramming.Model.TreeNode;

import java.util.HashSet;
import java.util.Set;

/* Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:

Input: root = [2,2,5,null,null,5,7]
Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.

Example 2:
Input: root = [2,2,2]
Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
Constraints:

The number of nodes in the tree is in the range [1, 25].
1 <= Node.val <= 231 - 1
root.val == min(root.left.val, root.right.val) for each internal node of the tree.

Approach: traverse through the graph using preorder and add each value of the tree into a Set (to ensure no duplication), sort the set and return the second smallest element
from the set

*  */
public class SecondMinimumNodeInATree {
    public int findSecondMinimumValue(TreeNode root) {
        //create a a new set to store all element from the tree
        Set<Integer> nodeSet = new HashSet<>();
        //dfs through the tree and add element from the tree into a set
        dfs(root, nodeSet);
        long answer = Long.MAX_VALUE;
        int min = root.val;
        //loop through the set to find the second smallest element from the set with root.val being the current smallest element
        for(int i: nodeSet) {
            if (i < min && i < answer) {
                answer = i;
            }
        }

        return answer < Long.MAX_VALUE ? (int) answer : -1;
    }
    //function to traverse the tree using preorder add element into a set
    public void dfs(TreeNode node, Set<Integer> set){
        if (node != null){
            set.add(node.val);
            dfs(node.left, set);
            dfs(node.right, set);
        }
    }

}
