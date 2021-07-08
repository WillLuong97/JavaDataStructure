package com.javaprojects.DynamicProgramming.Controller.HeapProblem;

import java.util.PriorityQueue;

public class MaxProductOfTwoArrayElement {
    /* Approach using Priority Queue*/
    public int maxProduct(int[] nums) {
        //base case:
        if(nums.length < 2){
            throw new RuntimeException("Invalid Input: The Array does not contains enough element!");
        }

        //create a priority queue to store the element from the array
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        //build out the queue from the integer
        for(int num: nums){
            pq.offer(-num);
        }
        int firstNum = Math.abs(pq.poll());
        int secondNum = Math.abs(pq.poll());

        return (firstNum-1) * (secondNum-1);

    }

}
