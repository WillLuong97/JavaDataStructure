package com.javaprojects.DynamicProgramming.Controller;

public class FindSmallestInArray {
    public int findFirstSmallest(int[] array){
        //base case: empty array
        if(array.length == 0){
            return -1;
        }

        int smallest = Integer.MAX_VALUE;
        //loop through the array and compare each values to the smallest element
        for(int i = 0; i < array.length; i++){
            if(array[i] < smallest){
                smallest = array[i];
            }
        }

        return smallest;
    }

    public int findSecondSmallest(int[] array){
        //base case: empty array
        if(array.length == 0){
            return -1;
        }

        int smallest = Integer.MAX_VALUE;
        int second_smallest = Integer.MAX_VALUE;
        //loop through the array and compare each values to the smallest element
        for(int i = 0; i < array.length; i++){
            if(array[i] < smallest){
                smallest = array[i];
            }
        }
        //loop through the array again to find second smallest by comparing it with the smallest and each element in the array
        for(int j = 0; j < array.length; j++){
            if( array[j] > smallest && array[j] < second_smallest){
                second_smallest = array[j];
            }
        }
        return second_smallest;
    }

}
