package com.javaprojects.DynamicProgramming.Controller.LinkedListProblem;

import com.javaprojects.DynamicProgramming.Model.ListNode;

public class MergeInBetweenLinkedList {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2){
        //create a variable to keep track of the final updated list1
        ListNode head = list1;
        //create a counter to keep track of the index position of linked list
        int counter = 0;
        //traverse through list1 until we reach the ath position:
        while(list1.next != null && counter < a - 1){
            list1 = list1.next;
            counter++;
        }

        //create a temp variable to keep track of the ath -> bth position:
        ListNode temp = list1;
        while(temp != null && counter < b){
            temp = temp.next;
            counter++;
        }
        //connect the list1 to list2 at the ath position:
        list1.next = list2;

        //traverse to the tail of the updated list1 and connect it to temp
        while(list1.next != null){
            list1 = list1.next;
        }

        list1.next = temp.next;

        return head;

    }
}
