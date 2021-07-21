package com.javaprojects.DynamicProgramming.Controller.Greedy;

import java.util.Arrays;

/*
You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:

horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, and
verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts. Since the answer can be a large number, return this modulo 109 + 7.

Example 1:


Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
Output: 4
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green piece of cake has the maximum area.
Example 2:


Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
Output: 6
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green and yellow pieces of cake have the maximum area.
Example 3:

Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
Output: 9

Constraints:

2 <= h, w <= 109
1 <= horizontalCuts.length <= min(h - 1, 105)
1 <= verticalCuts.length <= min(w - 1, 105)
1 <= horizontalCuts[i] < h
1 <= verticalCuts[i] < w
All the elements in horizontalCuts are distinct.
All the elements in verticalCuts are distinct.



h = 5       0   3  => 2
w = 4       0 1 2 3 => 2 => 2 * 2 = 4

horizontalCut = [1, 2, 4]
verticalCut = [1,3]


Greedy approach:
At each cut, we want to find the cake size with the greater h and w as this would create the maximum area that we are looking for

Algorithm:

we will go through the list of both horizontal and vertical cut (from smallset element to the greatest element)and cut
h and w at each ith element. Then we will want to compare to see if the cut is greater than h or w, if it is then we will return it as it would give us the dimension

* */
public class MaximumAreaAfterCuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        //sort the horizontal cut with the vertical cut
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        //find the greatest dimension of the cut
        long maxh = maxDimension(horizontalCuts, h);
        long maxv = maxDimension(verticalCuts, w);

        int mod = (int) 1e9 + 7;

        long res1 = (int) (maxh % mod);
        long res2 = (int) (maxv % mod);

        //configuring the final result with the modulo
        int result = (int) ((res1 * res2) % mod);

        return result;

    }

    //function to find the maximum dimension of the cake with the largest area
    private long maxDimension(int[] cuts, int edge){
        //base case: the cuts size is empty, so just return the edge as there is nothing to cut, the max size  is the entire cake
        if(cuts.length == 0){
            return edge;
        }

        long maxVal = 0;
        long curr_cuts;
        int i = 0;

        // if we only cuts one piece, so compare the edge with the cut size
        if(cuts.length == 1){
            maxVal = Math.max(cuts[0], edge - cuts[0]);
            return (int) maxVal;
        }

        //otherwise, assume the first element of the cuts would cut the largest
        maxVal = cuts[0];
        //traverse through the cut to find the cuts size
        while(i < cuts.length){
            if(i == cuts.length-1){
                curr_cuts = Math.abs(cuts[i] - edge);
                maxVal = Math.max(curr_cuts, maxVal);
                break;
            }

            //if the list still have element, then we will find from the list the biggest cuts so far
            curr_cuts = Math.abs(cuts[i] - cuts[i+1]);
            maxVal = Math.max(curr_cuts, maxVal);
            i++;

        }

        return maxVal;


    }
}
