package com.javaprojects.DynamicProgramming;

/*
    Calculate square without using *, /, and pow()

    5 => 25
    5 * 5 = 5^2
    n = 5
    5
    5 + 5 + 5 +5 + 5

    2^2  = 2 * 2 = 4

    2 + 2 = 4

    3^2 = 9
    3 * 3 = 9
    3 + 3 + 3 = 9

    3*3 = 3^2
    square = power of 2

    (-2)^2  = 4
    -2*-2 = 4
    -2 + -2 =0



    constraint:
    there could be negative value
    just int

    time complexity: o(n)
    space : o(1)

 */
public class Test {
    public int findSquare(int n){
        //base case: if the number is negative, we just make it positive
        if(n < 0){
            n *= -1;
        }
        int result = 0;
        /*0 1 2 3 4 */
        for(int i = 0; i < n; i++){
            result += n;
        }
        return result;
    }

}
