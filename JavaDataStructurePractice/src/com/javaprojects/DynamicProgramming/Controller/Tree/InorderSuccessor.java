package com.javaprojects.DynamicProgramming.Controller.Tree;

import com.javaprojects.DynamicProgramming.Model.TreeNode;

/*
In Binary Tree, Inorder successor of a node is the next node in Inorder traversal of the Binary Tree. Inorder Successor is NULL for the last node in Inorder traversal.
In Binary Search Tree, Inorder Successor of an input node can also be defined as the node with the smallest key greater than the key of the input node. So, it is sometimes important to find next node in sorted order.


                20
               /  \
              8   22
             / \
             4 12
               / \
               10 14
In the above diagram, inorder successor of 8 is 10, inorder successor of 10 is 12 and inorder successor of 14 is 20.

*  */
public class InorderSuccessor {
    public int inorderSuccessor(TreeNode root, int target){
        //Find the target value in the tree:
        TreeNode node_target = findTreeNodeFromInt(target, root);
        //Case 1: the target node has a right subtree, and since this is a bst, therefore the right successor would be the
        //lowest key in this right subtree.
        if(node_target.right != null){
            return minValue(node_target.right);
        }

        //CASE 2: if the target node does not have right child subtree, so we will start from the
        //root and traverse down the tree to find the potential successor.
        TreeNode succ = null;
        while(root != null){
            if(root.val > target){
                succ = root;
                root = root.left;
            }
            else if(root.val < target){
                root = root.right;
            }
            else{
                break;
            }
        }
        return succ.val;
    }

    //helper method to find the tree node  version of the int target
    private TreeNode findTreeNodeFromInt(int target, TreeNode root){
        while(root != null){
            if(root.left != null){
                root = root.left;
            }
            if(root.val == target){
                return root;
            }

            if(root.right != null){
                root = root.right;
            }
        }

        return null;
    }

    private int minValue(TreeNode node){
        TreeNode curr_node = node;
        //loop down the tree to the leftmost node
        while(curr_node.left != null){
            curr_node = curr_node.left;
        }

        return curr_node.val;
    }


}
