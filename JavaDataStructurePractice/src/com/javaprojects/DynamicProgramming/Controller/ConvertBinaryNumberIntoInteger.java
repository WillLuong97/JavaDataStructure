package com.javaprojects.DynamicProgramming.Controller;

import com.javaprojects.DynamicProgramming.Model.ListNode;

/*Problem 1290. Convert Binary Number in a Linked List to Integer
Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

Example 1:

Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10

Example 2:

Input: head = [0]
Output: 0
Example 3:

Input: head = [1]
Output: 1

Example 4:

Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880

Example 5:

Input: head = [0,0]
Output: 0
Constraints:

The Linked List is not empty.
Number of nodes will not exceed 30.
Each node's value is either 0 or 1.

Approach: Using math:
we will traverse through the linked list in a linear fashion and at each node, we will perform this math operations:
resul += result * 2 + head.next.val

Time complexity: O(n), n is the number of node in the linked list that we need to go through
Space complexity: O(1), our program is not storing any extra spaces.

 */
public class ConvertBinaryNumberIntoInteger {
    //Function to convert the binary number in a linked list into an decimal value
    public int getDecimalValue(ListNode head) {
        int decimal = head.getVal();
        // traverse through the linked list to find the decimal values
        while(head.getNext()!= null){
            decimal = decimal * 2 + head.getNext().getVal();
            head = head.getNext();
        }
        return decimal;
    }
}
