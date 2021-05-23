package com.javaprojects.DynamicProgramming.Controller;
import com.javaprojects.DynamicProgramming.Model.ListNode;
import java.util.List;
/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

Approach: traverse the two linked list to get the value out and assign it into two different string, reverse those two string, convert them into two int
add them up, then convert the result into a string, reverse that string and create a new linked list with the reversed string.

Time complexity: O(max(m,n)), where m and n are the length of the list 1 and list 2.
Space complexity: O(max(m,n)), we are storing the length of the list 1 and list 2
*/

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //base case:
        if(l1 == null && l2 == null){
            return null;
        }

        //setting up pointer to point at both tree
        ListNode p = l1;
        ListNode q = l2;
        //dummy node to keep track of the result tree
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        //variable to keep track of the carray over number
        int carry = 0;
        //traverse both tree
        while(p != null || q != null){
            //getting the x and y value to add for the sum
            int x = (p != null) ? p.getVal() : 0;
            int y = (q != null) ? q.getVal() : 0;
            int sum = x + y + carry;
            carry = sum / 10; //the carried over from the addition
            //setting the new tree to have the value of the value
            curr.setNext(new ListNode(sum % 10));
            curr = curr.getNext();
            //getting the next value in the linked list
            if(p != null){
                p = p.getNext();
            }
            if(q != null){
                q = q.getNext();
            }
        }
        //if at the end of the tree, we still have the values left in the carried over, then assign it to a new node
        if(carry > 0){
            curr.setNext(new ListNode(carry));
        }

        return dummyNode.getNext();
    }
}
