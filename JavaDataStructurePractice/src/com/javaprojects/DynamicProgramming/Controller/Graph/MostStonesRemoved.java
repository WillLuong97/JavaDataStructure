package com.javaprojects.DynamicProgramming.Controller.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.

A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
   0  0 0
=> * 0 0
   0 * 0
Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.

Example 1:
                   0     1    2     3      4     5
Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]

        0 1 2           0 [0,1]     0 [0,1]
      0 * * 0           1 [0,2]     1 [0,2]
      1 * 0 *           2 [1,2]     2 [1,2]
      2 0 * *

 dfs:
 pick a stone, check its neighbor, if its neighbor is rock, then increment the counter, because this rock can be removed. If the current_neighbor
 does not have a rock, then branch out from that neighbor and see if it does lead to another rock. repeat this process until we cannot branch out anymore.

counter = 5

Output: 5
Explanation: One way to remove 5 stones is as follows:
1. Remove stone [2,2] because it shares the same row as [2,1].
2. Remove stone [2,1] because it shares the same column as [0,1].
3. Remove stone [1,2] because it shares the same row as [1,0].
4. Remove stone [1,0] because it shares the same column as [0,0].
5. Remove stone [0,1] because it shares the same row as [0,0].
Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Explanation: One way to make 3 moves is as follows:
1. Remove stone [2,2] because it shares the same row as [2,0].
2. Remove stone [2,0] because it shares the same column as [0,0].
3. Remove stone [0,2] because it shares the same row as [0,0].
Stones [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.
Example 3:

Input: stones = [[0,0]]
Output: 0
Explanation: [0,0] is the only stone on the plane, so you cannot remove it.

Constraints:

1 <= stones.length <= 1000
0 <= xi, yi <= 104
No two stones are at the same coordinate point.

*  */
public class MostStonesRemoved {
    //hashmap to store the key and row values:
    private Map<Integer, List<Integer>> rowMap = new HashMap<>();
    private Map<Integer, List<Integer>> colMap = new HashMap<>();

    //array to store the parent node
    int[] parent;
    public int removeStones(int[][] stones) {
        int n = stones.length;
        this.parent = new int[n];
        int counter = 0;
        //init the parent list with the parent node
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        //build out two hashmap to store the element in the left and right
        for(int i = 0; i < n; i++){
            int[] curr_stone = stones[i];
            //extracting the dimension of the current stone
            int row = curr_stone[0];
            int col = curr_stone[1];
            rowMap.putIfAbsent(row, new ArrayList<>());
            rowMap.get(row).add(col);

            colMap.putIfAbsent(col, new ArrayList<>());
            colMap.get(col).add(row);
        }

        //NOT YET FINISHED!!!! CONTINUE WORKING ON LATER.
        return counter;
    }

}
