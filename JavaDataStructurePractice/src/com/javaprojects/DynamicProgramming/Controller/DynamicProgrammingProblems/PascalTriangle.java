package com.javaprojects.DynamicProgramming.Controller.DynamicProgrammingProblems;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]

Constraints:

1 <= numRows <= 30


Approach: Generate each row of the triangle as a list with the first element and last element of each list being 1, while other
element will be computed by the previous element in the previous row, which is a good use case for dp, since we will
store the previously computed solutions from the previous row and assign them to the current row. We will use each array
to store the computed solutions from previous row.

time complexity: O(numsRows^2).lthough updating each value of triangle happens in constant time, it is performed O(numRows^2)O(numRows
2
 ) times. To see why, consider how many overall loop iterations there are. The outer loop obviously runs numRowsnumRows times, but for each iteration of the outer loop, the inner loop runs rowNumrowNum times.
 Therefore, the overall number of triangle updates that occur is 1 + 2 + 3 + \ldots + numRows1+2+3+…+numRows, which, according to Gauss' formula, is

space complexity: O(numsRows^2), we need to store each number we update in the triangle


*  */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        //base case:
        if(numRows < 0){
            throw new RuntimeException("Invalid Input: numRows is not within the right bound");
        }

        //create the return triangle
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        triangle.add(new ArrayList<>());
        //base case: the row 0 will always have one element
        triangle.get(0).add(1);

        //iterate through the number of rows and calculate the pascal triangle
        for(int i = 1; i < numRows; i++){
            //getting the current and previous row
            List<Integer> curr_row = new ArrayList<>();
            List<Integer> prev_row = triangle.get(i-1);
            //the first element of each row will always be 1
            curr_row.add(1);

            //for any element in the middle it will be computed by the element from the previous row
            for(int j = 1; j < i; j++){
                curr_row.add(prev_row.get(j-1) + prev_row.get(j));
            }
            //the last element of the row will always be 1
            curr_row.add(1);

            triangle.add(curr_row);

        }
        return triangle;
    }
}
