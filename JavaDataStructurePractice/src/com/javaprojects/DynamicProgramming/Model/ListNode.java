package com.javaprojects.DynamicProgramming.Model;

//Contanining the data model for a node in a linked list
public class ListNode {
    int val;
    ListNode next;
    //constructor
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    //setter and getter
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
