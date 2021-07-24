package com.javaprojects.DynamicProgramming.Controller.LinkedListProblem;

import com.javaprojects.DynamicProgramming.Model.ListNode;
/*
* Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

* Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

* Example 3:

Input: head = [1], pos = -1
Output: false

* Explanation: There is no cycle in the linked list.

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.


Follow up: Can you solve it using O(1) (i.e. constant) memory?
*
* Approach: slow and fast pointer
*   1. create two pointers, slow and fast and they are both init to be the head of the list
*   2.Fast pointer will move up 2 node while slow pointer will move up 1 node
*   3. At any point during the traversal and the two elements meet with each other, return true as the cycle is found
*
*
* Time complexity: O(n)
* Space complexity: O(1), no extra space, everything is checked in place
*  */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        //base case:
        if(head == null){
            return false;
        }

        //init the fast and slow pointer
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        //traverse the list with the slow and fast pointer
        while(fastPtr != null && fastPtr.next!= null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if(slowPtr == fastPtr){
                return true;
            }
        }

        return false;


    }
}
