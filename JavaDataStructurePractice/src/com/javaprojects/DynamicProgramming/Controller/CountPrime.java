package com.javaprojects.DynamicProgramming.Controller;

/*
Count the number of prime numbers less than a non-negative number, n.
Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0


Constraints:

0 <= n <= 5 * 106

*  */
public class CountPrime {
    public int countPrimes(int n) {
        //base case:
        if(n <= 2){
            return 0;
        }

        //create a boolean array to keep track of the composite number from 0 to n
        boolean[] isComposite = new boolean[n];
        //loop through each number that potentially is a prime number, we will then check for its multiples and make those number composite on
        // our array.
        for(int i = 2; i <= (int) Math.sqrt(n); ++i){
            if(isComposite[i] == false){
                for(int j = i*i; j < n; j+=i){
                    isComposite[j] = true;
                }
            }
        }

        int counter = 0;
        for(int i = 2; i < isComposite.length; i++){
            if(isComposite[i] == false){
                counter++;
            }
        }
        return counter;
    }
}
