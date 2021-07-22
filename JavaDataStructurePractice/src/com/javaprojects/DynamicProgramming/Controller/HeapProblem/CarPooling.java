package com.javaprojects.DynamicProgramming.Controller.HeapProblem;

/*

You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)
Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.

Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.

* Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false

* Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true

* Example 3:

Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true

* Example 4:

Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true

Constraints:

trips.length <= 1000
trips[i].length == 3
1 <= trips[i][0] <= 100
0 <= trips[i][1] < trips[i][2] <= 1000
1 <= capacity <= 100000


Approach:
We will use a priority queue to keep track of the current trip that we are travelling, then
we pop them out of the queue to see if we can drop off the current set of customer by the time we reaches the next starting point, this way
we can always check to see if the capacity can fit all customers.

- We will prioritize picking up customers from the nearest starting locations and drop them off if we reaches the next starting point
that is greater than or equals to the our current dropping points

time complexity: O(nlogn)
space complexity: O(n), n is the size of the priority queue
*
*  */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        //base case:
        if(trips.length == 0){
            return true;
        }

        //sort the arrays by the starting point in ascending order, because we want to prioritize picking up
        //the customer at the nearest starting point
        Arrays.sort(trips, new Comparator<int[]>(){
            //sort the array in asceding order
            public int compare(int[] i1, int[] i2){
                return i1[1] - i2[1];
            }
        });


        //create a priority queue to keep track of the current trip that we are going
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            //let the queue store the element the destination
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        //traverse through the list and check for the locations
        for(int i = 0; i < trips.length; i++){
            while(!pq.isEmpty() && pq.peek()[2] <= trips[i][1]){
                //we can drop off the customer, meaning the capacity increases
                capacity += pq.peek()[0];
                pq.poll();
            }

            //if the queue is empty or we cannot drop off the customer because the current trips have not ended, then pick up new customer and keep going
            capacity -= trips[i][0];
            pq.offer(trips[i]);

            if(capacity < 0){
                return false;
            }
        }

        return true;
    }

}
