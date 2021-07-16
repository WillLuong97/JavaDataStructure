package com.javaprojects.DynamicProgramming.Controller.BinarySearch;

import java.util.Arrays;

/*
* Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.

The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.

Example 1:
Input: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
Output: 2
Explanation:
For arr1[0]=4 we have:
|4-10|=6 > d=2
|4-9|=5 > d=2
|4-1|=3 > d=2
|4-8|=4 > d=2
For arr1[1]=5 we have:
|5-10|=5 > d=2
|5-9|=4 > d=2
|5-1|=4 > d=2
|5-8|=3 > d=2
For arr1[2]=8 we have:
|8-10|=2 <= d=2
|8-9|=1 <= d=2
|8-1|=7 > d=2
|8-8|=0 <= d=2
Example 2:

Input: arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
Output: 2
Example 3:

Input: arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
Output: 1


Constraints:

1 <= arr1.length, arr2.length <= 500
-10^3 <= arr1[i], arr2[j] <= 10^3
0 <= d <= 100
*
*
*
* Approach: apply binary search to find the number in arr2 that would give us the solution closest to the
* d. We will loop through each element in arr1 and then pass it into the binary search algorithm that we created, which can help us
* pick out the right number in arr2 that would sastisfy |arr1[i]-arr2[j]| <= d.
*
* time complexity: o(nlogn)
 */
public class DistanceValue {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        //base case: the arrays are empty:
        if(arr1.length == 0 || arr2.length == 0){
            throw new RuntimeException("Invalid Inputs: arr1 and arr2 are empty!");
        }
        int counter = 0;
        Arrays.sort(arr2); //pre sort the second array to perform our binary search
        //loop through each element in the first array and compare it with the binary search
        for(int i = 0; i < arr1.length; i++){
            if(binarySearch(arr2, d, arr1[i])){
                counter++;
            }

        }
        return counter;
    }

    //helper method to run binary search on the arr2
    private boolean binarySearch(int[] arr2, int d, int curr_arr1){
        //setting up the boundary for binary search:
        int low = 0;
        int high = arr2.length;
        while(low < high){
            int mid = (low  + high) / 2;
            if(d >= Math.abs(curr_arr1 - arr2[mid])){
                return false;
            }
            else if(arr2[mid] > curr_arr1){
                high = mid;
            }

            else{
                low = mid + 1;
            }
        }

        return true;

    }
}
