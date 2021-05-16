package com.javaprojects.DynamicProgramming.Controller;

/* Given the head of a singly linked list, return true if it is a palindrome.
Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false


Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9


Follow up: Could you do it in O(n) time and O(1) space?

Approach: using an array list to store all node from the linked list and then
pop them out from the from the back compare it with each element in the linked list

*  */

import com.javaprojects.DynamicProgramming.Model.ListNode;

import java.util.ArrayList;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head){

        //base case:
        if(head == null){
            return false;
        }
        //create an array list to keep track of all node from the linked list
        ArrayList nodeVal = new ArrayList();
        ListNode current = head;
        while(current != null){
            nodeVal.add(current.getVal());
            current = current.getNext();
        }

        //traverse through the arraylist backward and check to see if element in the reversed linked list is the same
        current = head;
        int index = nodeVal.size() - 1;

        while(current != null){
            if(current.getVal() != (int) nodeVal.get(index)){
                return false;
            }

            current = current.getNext();
            index--;
        }

    return true;
    }
}
