package com.javaprojects.DynamicProgramming.Controller.AmazonOA.DynamicProgramming;

public class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        //base case:
        if(rating.length == 0){
            return 0;
        }

        //create a dp array to cache the previous compared soldiers together
        int[] cache = new int[rating.length];
        int result = 0;
        int n = rating.length;
        //traverse through the rating list using two loops because we will cache their comparison in memory so no need for the third loops
        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                if(rating[i] < rating[j]){
                    cache[i] += 1;
                    result += cache[j];
                }
            }
        }

        //reset the cache to check for the second conditions
        cache = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                if(rating[i] > rating[j]){
                    cache[i] += 1;
                    result += cache[j];
                }
            }
        }

        return result;

    }

}
