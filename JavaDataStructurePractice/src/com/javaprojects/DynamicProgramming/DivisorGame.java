package com.javaprojects.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Vector;

/*
Alice and Bob take turns playing a game, with Alice starting first.
Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:

Choosing any x with 0 < x < n and n % x == 0.
Replacing the number n on the chalkboard with n - x.
Also, if a player cannot make a move, they lose the game.
Return true if and only if Alice wins the game, assuming both players play optimally.

Example 1:
Input: n = 2
Output: true
Explanation: Alice chooses 1, and Bob has no more moves.

Example 2:
Input: n = 3
Output: false
Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
Constraints:
1 <= n <= 1000

Use vector dp to track the result if Alice can win or not.
For each given number, Alice can win only previous number she cannot win, which means Alice can force the opponent to the lose state. How to find previous number? According to the rules, we can track all possible numbers from current number.
 */
public class DivisorGame {
    public boolean divisorGame(int n){
        //base case: if n = 1, there is no way Alice can win as there is no way of picking the value, both lost the game
        if(n==1){
            return false;
        }
        boolean ans = true;
        int x = n-1;
        while(x > 1){
            // every number can be divided by 1, toogle answer unless alice wins / losses
            ans = ans==true?false:true;
            x--;
        }
        return ans;
        }
}
