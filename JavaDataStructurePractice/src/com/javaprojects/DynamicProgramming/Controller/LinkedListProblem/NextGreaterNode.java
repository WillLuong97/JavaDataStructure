package com.javaprojects.DynamicProgramming.Controller.LinkedListProblem;

import com.javaprojects.DynamicProgramming.Model.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.

Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.

Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).

Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.



Example 1:

Input: [2,1,5]
Output: [5,5,0]
Example 2:

Input: [2,7,4,3,5]
Output: [7,0,5,5,0]
Example 3:

Input: [1,7,5,1,9,2,5,1]
Output: [7,9,9,9,0,5,0,0]


Note:

1 <= node.val <= 10^9 for each node in the linked list.
The given list has length in the range [0, 10000].

 */
public class NextGreaterNode {
    public int[] nextLargerNodes(ListNode head) {
        if(head == null){
            throw new RuntimeException("Empty List!");
        }
        //convert the linked list into an array
        ListNode curr = head;
        //arraylist to store the node value into an array
        List<Integer> arrOfNode = new ArrayList<>();
        while(curr != null){
            arrOfNode.add(curr.val);
            curr = curr.next;
        }

        //create a stack to store the index of the element in the array of node
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arrOfNode.size()];
        //traverse through the list to find the next largest node by comparing its value with the value from the stack.
        for(int i = 0; i < arrOfNode.size(); i++){
            while(!(stack.isEmpty()) && (arrOfNode.get(stack.peek())) < arrOfNode.get(i)){
                result[stack.pop()] = arrOfNode.get(i);

            }
            stack.push(i);
        }

        return result;
    }
}
