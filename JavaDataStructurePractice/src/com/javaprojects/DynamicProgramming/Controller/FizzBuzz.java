package com.javaprojects.DynamicProgramming.Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* Given an integer n, return a string array answer (1-indexed) where:
answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i if non of the above conditions are true.

Example 1:

Input: n = 3
Output: ["1","2","Fizz"]
Example 2:

Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]
Example 3:

Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

*  */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        //base case:
        if(n <= 0){
            return null;
        }

        //result array to store all the conditions
        List<String> result = new ArrayList<>();
        //loop through from 1 to n and check for each conditions
        for(int i = 1; i < n+1; i++){
            if (i % 3 == 0 && i % 5 == 0){
                result.add("FizzBuzz");
            }
            else if (i % 3 == 0){
                result.add("Fizz");
            }
            else if (i % 5 == 0) {
                result.add("Buzz");
            }

            else{
                result.add(Objects.toString(i));
            }
        }
        return result;
    }

}
