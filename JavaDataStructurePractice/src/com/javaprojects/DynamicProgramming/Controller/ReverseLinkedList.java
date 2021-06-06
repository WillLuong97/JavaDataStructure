package com.javaprojects.DynamicProgramming.Controller;

import com.javaprojects.DynamicProgramming.Model.ListNode;

public class ReverseLinkedList {
    //give the head of a linked list, print out the reverse of the linked list
    public ListNode reverseALinkedList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            curr = prev;
            prev = curr;
        }
        return prev.next;
    }
}
