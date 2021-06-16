package com.javaprojects.DynamicProgramming.Controller.HeapProblem;

import java.util.PriorityQueue;

/*
    If I do not remember a sorting algorithm, we can use the
    heap (min_heap) to store each element in the array and then pop them out
    the popped element will always be the current smallest elemnet in the heao


    time complexity: O(n)
    space complexity: O(n), n is the size of the input array
*  */
public class SortThroughHeap {
    public void sortWithHeap(int[] array){
        //base case:
        if(array.length == 0){
            return;
        }

        //create a min_heap to store all element in the array
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        //loop through all elment in the current array, take them out and add them into the heap
        for(int i = 0; i < array.length; i++){
            int curr_number = array[i];
            min_heap.add(curr_number);
            array[i] = 0;
        }

        //loop through the list again to store the popped value from the min_heap
        for(int i = 0; i < array.length; i++){
            int popped_num = min_heap.poll();
            array[i] = popped_num;
        }
    }
}
