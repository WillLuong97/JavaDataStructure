package com.javaprojects.DynamicProgramming.Controller.DynamicProgrammingProblems;

/*
You are given two identical eggs and you have access to a building with n floors labeled from 1 to n.
You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break, and any egg dropped at or below floor f will not break.
In each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). If the egg breaks, you can no longer use it. However, if the egg does not break, you may reuse it in future moves.
Return the minimum number of moves that you need to determine with certainty what the value of f is.

Example 1:
Input: n = 2
Output: 2
Explanation: We can drop the first egg from floor 1 and the second egg from floor 2.
If the first egg breaks, we know that f = 0.
If the second egg breaks but the first egg didn't, we know that f = 1.
Otherwise, if both eggs survive, we know that f = 2.

Example 2:
Input: n = 100
Output: 14
Explanation: One optimal strategy is:
- Drop the 1st egg at floor 9. If it breaks, we know f is between 0 and 8. Drop the 2nd egg starting
  from floor 1 and going up one at a time to find f within 7 more drops. Total drops is 1 + 7 = 8.
- If the 1st egg does not break, drop the 1st egg again at floor 22. If it breaks, we know f is between 9
  and 21. Drop the 2nd egg starting from floor 10 and going up one at a time to find f within 12 more
  drops. Total drops is 2 + 12 = 14.
- If the 1st egg does not break again, follow a similar process dropping the 1st egg from floors 34, 45,
  55, 64, 72, 79, 85, 90, 94, 97, 99, and 100.
Regardless of the outcome, it takes at most 14 drops to determine f.
Constraints:
1 <= n <= 1000


DP approach
*  */
public class EggDrop {
    public int twoEggDrop(int n) {
        //the total number of eggs:
        int totalEggs = 2;
        //create a dp array to cache the solution of each sub problem:
        int[][] cache = new int[totalEggs+1][n+1];
        //setting the base case: if we only have 0 floors, then we drop the egg 0 times, if we have 1 floor, then we drop the egg 1
        //time to know
        for(int i = 1; i <= totalEggs; i++){
            cache[i][0] = 0;
            cache[i][1] = 1;
        }

        //set the base case for the eggs, if we only have 1 egg, then the worst case that we need to drop to is the number of floor
        for(int i = 1; i <= n; i++){
            cache[1][i] = i;
        }

        for(int i = 2; i <= totalEggs; i++){
            for(int j = 2; j <=n; j++){
                cache[i][j] = Integer.MAX_VALUE;
                for(int currFloor = 1; currFloor <= j; currFloor++){
                    int costOfWorsCase = Math.max(cache[i][j-currFloor], cache[i-1][currFloor-1]);

                    int accountForDroppingAtThisFloor = costOfWorsCase + 1;

                    cache[i][j] = Math.min(cache[i][j], accountForDroppingAtThisFloor);
                }
            }
        }

        return cache[totalEggs][n];
    }
}
