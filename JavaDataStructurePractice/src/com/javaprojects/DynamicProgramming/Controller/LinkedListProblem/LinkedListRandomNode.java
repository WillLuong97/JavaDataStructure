package com.javaprojects.DynamicProgramming.Controller.LinkedListProblem;

import com.javaprojects.DynamicProgramming.Model.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Example 1:
Input
["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 3, 2, 2, 3]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.getRandom(); // return 1
solution.getRandom(); // return 3
solution.getRandom(); // return 2
solution.getRandom(); // return 2
solution.getRandom(); // return 3
// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.

Constraints:

The number of nodes in the linked list will be in the range [1, 104].
-104 <= Node.val <= 104
At most 104 calls will be made to getRandom.

Approach 1:

1-d array conversion,
Convert the linked list into a 1 d array, which would help us know the size of pool of elements that we are pulling out of
and we know the index of each element, therefore, the selection process would cost constant time complexity

Time complexity
    LinkedListRandomNode(ListNode head) => O(n), to covert the linked list into an array
    getRandom() => O(1), constant time complexity
Space complexity: O(n), where n is the size of the converted array

-> Equation:  1 / arrSize

Follow up:

What if the linked list is extremely large and its length is unknown to you?
Could you solve this efficiently without using extra space?
*  */
public class LinkedListRandomNode {
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node.
     The constructor will create an array that can store all element from the linked list
     O(n)
     */
    private List<Integer> converted_array = new ArrayList<>();
    public LinkedListRandomNode(ListNode head) {
        //convert the linked list into the arrary
        while(head != null){
            this.converted_array.add(head.val);
            head = head.next;
        }
    }

    /** Returns a random node's value.
     * Take the converted array size and caluclate the probabilty of selecting an element
     * O(1) */
    public int getRandom() {
        int pick = (int) (Math.random() * this.converted_array.size());
        return this.converted_array.get(pick);
    }
}
