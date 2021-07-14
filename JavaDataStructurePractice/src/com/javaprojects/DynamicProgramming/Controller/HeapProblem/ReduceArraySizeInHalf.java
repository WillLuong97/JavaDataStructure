package com.javaprojects.DynamicProgramming.Controller.HeapProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.

Example 1:

Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half of the size of the old array.

Example 2:

Input: arr = [7,7,7,7,7,7]
Output: 1
Explanation: The only possible set you can choose is {7}. This will make the new array empty.

Example 3:

Input: arr = [1,9]
Output: 1

Example 4:

Input: arr = [1000,1000,3,7]
Output: 1

Example 5:

Input: arr = [1,2,3,4,5,6,7,8,9,10]
Output: 5

Constraints:

1 <= arr.length <= 105
arr.length is even.
1 <= arr[i] <= 105


Heap + Hashmap
we will use the hashmap to count how many times an element occur in the array and use hashmap
to order it from smallest to highest and pulll out the highest element each time from the priority queue and substract it from
the lenght until the length of the array is lesser than or equal to half of the array length.

*  */
public class ReduceArraySizeInHalf {
    public int minSetSize(int[] arr) {
        //base case:
        if(arr.length == 0){
            throw new RuntimeException("Invalid Input: The array is empty!");
        }

        //create a hashmap and heap to store the element
        Map<Integer, Integer> mapOfNum = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;
        int curr_length = 0;
        int n = arr.length;
        //calculate the occurences of each number in the array
        Arrays.stream(arr).forEach(num -> mapOfNum.put(num, mapOfNum.getOrDefault(num, 0) + 1));

        //loop through the map and add element into the pq
        for(Integer num: mapOfNum.values()){
            pq.offer(-num);
        }
        //pull element out of the queue and substract it from the current length;
        while(curr_length < n/2){
            curr_length += Math.abs(pq.poll());
            result++;
        }

        return result;
    }

}
