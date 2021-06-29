package com.javaprojects.DynamicProgramming.Controller.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given an integer array nums, return all the different possible increasing subsequences of the given array with at least two elements. You may return the answer in any order.
The given array may contain duplicates, and two equal integers should also be considered a special case of increasing sequence.

Example 1:
Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

Example 2:
Input: nums = [4,4,3,2,1]
Output: [[4,4]]


Constraints:

1 <= nums.length <= 15
-100 <= nums[i] <= 100


Time complexity: O(n)
Space Complexity: O(n), the recursion stack will have to run all the way to the
*  */
public class IncreasingSubsequence {
    //create a set to keep track of duplicated sequencs
    private Set<List<Integer>> set = new HashSet();
    public List<List<Integer>> findSubsequences(int[] nums) {
        //base case:
        if(nums.length == 0){
            throw new RuntimeException("Invalid Input: Empty Array of Integer!");
        }

        //result array that store all increasing subsequences from the original array
        List<List<Integer>> result = new ArrayList<>();
        //calling the backtracking method to find the increasing subsequences
        backtracking(result, 0, nums, new ArrayList<>(), set);
        return result;
    }

    //helper method to run backtracking on the array to generate the subsequences
    private void backtracking(List<List<Integer>> result, int index, int[] nums, List<Integer> currList, Set<List<Integer>> set){
        //add the current list into the final result list if it has length from 2 to up and the currList is not alreddy in the set
        if(currList.size() > 1 && set.add(new ArrayList<>(currList))){
            result.add(new ArrayList<>(currList));
        }

        //keep looking at the next element in the original array to find the next subsequnces
        for(int i = index; i < nums.length; i++){
            if(currList.size() == 0 || currList.get(currList.size() - 1) <= nums[i]){
                //add the element into the array
                currList.add(nums[i]);
                //check for the next element in the array
                backtracking(result, i + 1, nums, currList, set);
                currList.remove(currList.size() - 1);
            }
        }

    }
}
