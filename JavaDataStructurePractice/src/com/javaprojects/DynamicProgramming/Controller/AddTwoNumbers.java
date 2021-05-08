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

        //create a dummy node to keep track of the result
        ListNode dummyHead = new ListNode(0);
        //pointers to point at the two linekd list and the result linked list
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode curr = dummyHead;
        //carry variable to keep track of the carried over
        int carry = 0;
        int sum;

        //traverse through the two linked list
        while(p1 != null || p2 != null){
            int x = (p1 != null) ? p1.getVal() : 0;
            int y = (p2 != null) ? p2.getVal() : 0;

            sum = carry + x + y;
            carry = (sum / 10);
//            ListNode newHead = new ListNode(sum %10)
            curr.setNext(new ListNode(sum %10));
            curr = curr.getNext();

            if(p1 != null){
                p1 = p1.getNext();
            }

            if(p2 != null){
                p2 = p2.getNext();
            }
        }
        if (carry > 0){
            curr.setNext(new ListNode(carry));
        }
        return dummyHead.getNext();
    }
}
