package com.javaprojects.DynamicProgramming.Controller.HeapProblem;

import java.util.PriorityQueue;

/*
* A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.

Given three integers a, b and c, return any string s, which satisfies following conditions:

s is happy and longest possible.
s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b' and at most c occurrences of the letter 'c'.
s will only contain 'a', 'b' and 'c' letters.
If there is no such string s return the empty string "".

Example 1:

Input: a = 1, b = 1, c = 7
Output: "ccaccbcc"
Explanation: "ccbccacc" would also be a correct answer.
Example 2:

Input: a = 2, b = 2, c = 1
Output: "aabbc"
Example 3:

Input: a = 7, b = 1, c = 0
Output: "aabaa"
Explanation: It's the only correct answer in this case.

Constraints:

0 <= a, b, c <= 100
a + b + c > 0
*
*
* Approach: Greedy + Priority Heao
 */
public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        //base case: all three elements cannot be repeated in the string so return an empty string
        if(a == 0 && b == 0 && c == 0){
            return "";
        }

        //0 = 'a'' 1 = 'b', 2 = 'c'
        //create a max_heap to keep track of the number of occurences for each of the character
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((arr1, arr2) -> arr2[0] - arr1[0]);
        //push the the element and its occurences onto the queue, we only want to push non-zero occurences of character onto the queue
        if(a != 0){
            pq.offer(new int[] {a, 0});
        }
        if(b != 0){
            pq.offer(new int[] {b, 1});
        }
        if(c != 0){
            pq.offer(new int[] {c, 2});
        }
        StringBuilder result = new StringBuilder();
        // this is the previous set of character that we wer building in the array
        int[] prev = new int[] {0,0};
        while(!(pq.isEmpty())){
            //get the current set of character and put it into the string
            int[] current = pq.poll();
            //before adding this into the array, check to see if we have seen them 2 times before this or not
            if(current[1] == prev[1] && prev[0] == 2){
                if(pq.isEmpty()){
                    //if the queue is already empty, then return the result
                    return result.toString();
                }
                //otherwise, we will put it back onto the heap and trade it with another element
                int[] next = pq.poll();
                pq.offer(current);
                current = next;
            }
            //put the word onto the string
            result.append((char) (current[1] + 'a'));
            prev[0] = current[1] == prev[1] ? prev[0] + 1 : 1;
            prev[1] = current[1];

            //check to see if the current number of occurences in this element has been reached
            if(--current[0] > 0){
                pq.offer(current);
            }
        }
        return result.toString();
    }

}
