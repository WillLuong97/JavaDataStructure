package com.javaprojects.DynamicProgramming.Controller.HeapProblem;
/*
Design a system that manages the reservation state of n seats that are numbered from 1 to n.

Implement the SeatManager class:

SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n. All seats are initially available.
int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.
Example 1:

Input
["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
[[5], [], [], [2], [], [], [], [], [5]]
Output
[null, 1, 2, null, 2, 3, 4, 5, null]

Explanation
SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
seatManager.reserve();    // All seats are available, so return the lowest numbered seat, which is 1.
seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
seatManager.reserve();    // The available seats are [3,4,5], so return the lowest of them, which is 3.
seatManager.reserve();    // The available seats are [4,5], so return the lowest of them, which is 4.
seatManager.reserve();    // The only available seat is seat 5, so return 5.
seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].
Constraints:

1 <= n <= 105
1 <= seatNumber <= n
For each call to reserve, it is guaranteed that there will be at least one unreserved seat.
For each call to unreserve, it is guaranteed that seatNumber will be reserved.
At most 105 calls in total will be made to reserve and unreserve.

* */

import java.util.PriorityQueue;

/*SeatManager(int n)
In the Constructor, seats (1->n) are added in the PQ.
Overall Complexity of the Constructor is O(nlogn)

Traversing from 1->n is O(n)
Adding a seat number in PQ is of O(logn)
reserve() - O(logn)
Reserve func reserves the smallest-numbered seat and returns it. Reserving the seat means removing that smallest-numbered seat from the PrioirtyQueue(which contains all unreserved seat numbers).

unreserve(int seatNumber) - O(logn)
Unreserve func takes an argument called seatNumber. This func adds that seatNumber to the PriorityQueue. As the number gets added to PQ, that seat number is unreserved.
*  */
public class SeatManager {
    //Init a priority queue system:
    PriorityQueue<Integer> availableSeats; //min heap
    //constructors
    public SeatManager(int n) {
        availableSeats = new PriorityQueue<>();
        //loop through from 1 to n and add them into the priority queue:
        for(int i = 1; i <= n; i++){
            availableSeats.add(i);
        }
    }
    //function to reserve a seat
    public int reserve() {
        return availableSeats.remove(); //this method will return the smallest element currently in the heap
    }

    public void unreserve(int seatNumber) {
        //add the seat number back onto the available seats
        availableSeats.add(seatNumber);
    }

}
