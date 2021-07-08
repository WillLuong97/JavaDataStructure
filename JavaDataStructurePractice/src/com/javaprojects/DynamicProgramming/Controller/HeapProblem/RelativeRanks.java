package com.javaprojects.DynamicProgramming.Controller.HeapProblem;

import java.util.PriorityQueue;

public class RelativeRanks {
    //Athelete data model
    class Athlete{
        int score;
        int position;

        //constructor:
        public Athlete(int score, int position){
            this.score = score;
            this.position = position;
        }
    }

    public String[] findRelativeRanks(int[] score) {
        //create priority queue to keep track of the element from the queue
        PriorityQueue<Athlete> pq = new PriorityQueue<>((a,b) -> b.score - a.score);
        String[] ranks = new String[score.length];
        String[] medals = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};

        //keeping track of unmarked ranks
        int counter = 1;

        //build out the priority queue
        for(int index = 0; index < score.length; index++){
            Athlete ath = new Athlete(score[index], index);
            pq.offer(ath);
        }

        while(!pq.isEmpty()){
            Athlete curr_ath = pq.poll();
            ranks[(int) curr_ath.position] = counter > 3 ? String.valueOf(counter) : medals[counter - 1];
        }
        return ranks;
    }

}
