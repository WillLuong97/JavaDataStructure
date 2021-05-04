package com.javaprojects.DynamicProgramming.Controller.Greedy;

/* Given a binary string  without leading zeros, return true if s contains at most one contiguous segment of ones. Otherwise, return false.

Example 1:

Input: s = "1001"
Output: false
Explanation: The ones do not form a contiguous segment.

Example 2:
Input: s = "110"
Output: true
Constraints:

1 <= s.length <= 100
s[i] is either '0' or '1'.
s[0] is '1'.

requirements: There can only be one segment of contiguous ones, and if more than that, then it should return false

greedy approach:
loop through the binary string linearly, if there is a 1, increament the ones counter by 1, so if there are 2 ones
standing right next to each other then the counter = 2. However, if the counter encounter a 0 at any point, the one counter
would be reset and count to 0. We do this until we reach the end of the binary string.

Time complexity: O(n), we will look at every element in the binary string.
Space complexity: O(1), we only need to store the counters, so that would be in constant times
*  */
public class BinaryStringContiguosOne {
    public boolean checkOnesSegment(String s) {
//        //base case:
        if(s.length() == 0){
            return false;
        }
        //variable to keep track of the 1 counts and the number of congtiguous segment of 1 that it can make
        int contiguousCounter = 0;
        int oneCounter = 0;

        //loop through the binary string to look at each element in the binary string
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                oneCounter = 0;
            } else{
                oneCounter++;
            }

            //counting the congtigous segments, if the next element right n
            while(i + 1 < s.length() && s.charAt(i+1) == '1'){
                i++;
                oneCounter++;
            }
            //if there are multiple segment of ones, make sure to keep track of them
            if(oneCounter > 0){
                contiguousCounter++;
            }
            if(contiguousCounter > 1){
                return false;
            }
        }

        //the segment has to be at most 1 segment regardless of the length:
        return contiguousCounter == 1;
    }
}
