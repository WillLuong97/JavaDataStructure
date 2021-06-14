package com.javaprojects.DynamicProgramming.Controller;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)


*  */
public class ProductOfArrayWithoutItself {
    /*
    Time complexity: O(n)
    Space complexity: O(n)
     */
    public int[] productExceptSelf(int[] nums) {
        //create array that can keep track of the element in the left and right side of a number in the array
        int[] before_i = new int[nums.length];
        int[] after_i = new int[nums.length];
        int[] result = new int[nums.length];

        //finding the product of all element in the before the current i
        before_i[0] = 1;
        for(int i = 1; i < nums.length; i++){
            //since we want to find the product of the sum before the curr elemnt so we have to do i-1
            before_i[i] = before_i[i-1] * nums[i-1];
        }

        //finding the sum of all element after the current i in the array
        after_i[nums.length-1] = 1;
        for(int i = after_i.length - 2; i >= 0; i--){
            after_i[i] = after_i[i+1] * nums[i+1];
        }
        //multiple all product from the left side and the right side
        for(int i = 0; i < result.length; i++){
            result[i] = after_i[i] * before_i[i];
        }

        return result;
    }
    /*
    Time complexity: O(n)
    Space complexity: O(1), the output array does not count as extra space for space complexity analysis, to maintain this, we can
    only have a result array.
     */
    public int[] productExceptSelf_NO_EXTRA_SPACE(int[] nums){
        int[] result = new int[nums.length];
        result[0] = 1;
        //finding the product of all the element on the left side of the current index
        for(int i = 1; i < nums.length; i++){
            result[i] = nums[i-1] * result[i-1];
        }
        //pointer to store all current element in the nums array looping in from the end of the array
        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            //multiple the current product with element from the right side
            result[i] = result[i] * right;
            right = right * nums[i];
        }

        return result;

    }
}
