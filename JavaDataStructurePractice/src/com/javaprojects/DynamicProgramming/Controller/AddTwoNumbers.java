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
        //Init the two string that would store the integer value of list 1 and list 2
        StringBuilder num_1_str = new StringBuilder();
        StringBuilder num_2_str = new StringBuilder();

        //traverse list 1 and append its value to the string 1
        while (l1 != null){
            num_1_str.append(l1.getVal());
            l1 = l1.getNext();
        }
        //traverse list 2 and append its value to string 2:
        while(l2 != null){
            num_2_str.append(l2.getVal());
            l2 = l2.getNext();
        }
        //reverse each string and then convert them into an int
        int num_1 = Integer.parseInt(String.valueOf(num_1_str.reverse()));
        int num_2 = Integer.parseInt(String.valueOf(num_2_str.reverse()));

        //add the two number together
        int result = num_1 + num_2;

        //convert the result into a string to reverse it
        StringBuilder result_str = new StringBuilder(String.valueOf(result));
        StringBuilder result_str_rev = result_str.reverse();

        //we will create a new linked list with the updated result
        ListNode newHead = null;
        ListNode current = null;
        for(int i = 0; i < result_str_rev.length(); i++){
            //if the head is empty so we will add the first element of the resut string into the head of the new linked list
            if(newHead == null){
                newHead = new ListNode(Integer.parseInt(String.valueOf(result_str_rev.charAt(0))));
                current = newHead;
            }
            else{
                current.setNext(new ListNode(Integer.parseInt(String.valueOf(result_str_rev.charAt(i)))));
                current = current.getNext();
            }
        }
        return newHead;

    }
}
