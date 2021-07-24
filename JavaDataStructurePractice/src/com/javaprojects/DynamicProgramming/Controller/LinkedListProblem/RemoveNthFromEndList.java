package com.javaprojects.DynamicProgramming.Controller.LinkedListProblem;

import com.javaprojects.DynamicProgramming.Model.ListNode;

public class RemoveNthFromEndList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //base case:
        if(head == null){
            throw new RuntimeException("Invalid Inputs: Tree is empty!");
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //create a 2 pointer to keep track of each node in the tree
        ListNode curr = dummy;
        ListNode prev = dummy;

        //traverse the linked list until we find the nth node
        for(int i = 0; i <= n; i++){
            curr = curr.next;
        }

        //after the for loop, the curr node should be in the nth node
        //moving the curr node to the end of the list to expand the gap
        while(curr != null){
            curr = curr.next;
            prev = prev.next;
        }
        //remove the node
        prev.next = prev.next.next;
        return dummy.next;
    }

}
