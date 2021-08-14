package com.javaprojects.DynamicProgramming.Controller.Tree;

import com.javaprojects.DynamicProgramming.Model.TreeNode;

public class BinaryTreeDiameter {
    int result;
    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        int x = height(root);
        return result;
    }
    //helper method to traverse the tree recrusively
    private int height(TreeNode root){
        if(root == null){
            //tree is empty or we cannot continue to go forward
            return 0;
        }

        int leftH = height(root.left);
        int rightH = height(root.right);
        result = Math.max(result, (leftH + rightH));

        return 1 + Math.max(leftH, rightH);
    }

}
