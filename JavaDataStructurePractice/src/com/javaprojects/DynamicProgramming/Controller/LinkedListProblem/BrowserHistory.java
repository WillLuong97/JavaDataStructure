package com.javaprojects.DynamicProgramming.Controller.LinkedListProblem;

import com.javaprojects.DynamicProgramming.Model.ListNode;

/*
You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.

Implement the BrowserHistory class:

BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
void visit(string url) Visits url from the current page. It clears up all the forward history.
string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
Example:

Input:
["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
Output:
[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

Explanation:
BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"

Constraints:

1 <= homepage.length <= 20
1 <= url.length <= 20
1 <= steps <= 100
homepage and url consist of  '.' or lower case English letters.
At most 5000 calls will be made to visit, back, and forward.
*  */
public class BrowserHistory {
    //Doubly linked list class:
    class DoublyListNode {
        public String val;
        //next node pointer
        public DoublyListNode next;
        //prev node pointer
        public DoublyListNode prev;

        //constructor
        public DoublyListNode(String val, DoublyListNode next, DoublyListNode prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
    DoublyListNode curr;
    /* --- TODO: Initialize a doubly linked list object with the homepage being the head */
    public BrowserHistory(String homepage) {
        //create the head of the linked list
        DoublyListNode head = new DoublyListNode(homepage, null, null);
        //init a pointer to point at the current element in the linked list
        curr = head;
    }
    //adding the new visited url into the linked list, by adding it into the tails
    public void visit(String url) {
        //init the url into a linked list object, have it pointed to back to the curr node
        DoublyListNode visited_url = new DoublyListNode(url, null, curr);
        //adding it onto the linked list
        curr.next = visited_url;
        //update the current pointer to the newly visited node
        curr = curr.next;
    }
    // **** TODO: backtrack to the previous page from the current pointer based on the number of steps *******
    public String back(int steps) {
        //iterate through the list backward until we have walked through all the steps
        while(curr != null && steps --> 0){
            curr = curr.prev;
            steps--;
        }
        return curr.val;
    }

    // **** TODO: moving forward to the next page from the current pointer based on the number of steps *******
    public String forward(int steps) {
        //iterate through the next element in the array until we hvae
        while(curr.next != null && steps --> 0){
            curr = curr.next;
        }
        return curr.val;
    }

}
