package com.javaprojects.DynamicProgramming.Controller.BinarySearch;

import java.util.HashMap;
import java.util.Map;

public class TimeMap {
    /** Initialize your data structure here. */
    Map<String, Map<Integer, String>> timeBasedStorageMap;
    String defaultValue = "";
    //when this contructor is called, we will init the map
    public TimeMap() {
        timeBasedStorageMap = new HashMap<String, Map<Integer, String>>();
    }
    //function to to assign the key, its value and timestamp into the map
    public void set(String key, String value, int timestamp) {
        //create a map to store the timestamp with its value
        Map<Integer, String> timeToValuesMap = timeBasedStorageMap.get(key);
        //if the value was not already in the map so we will add it into the map
        if(timeToValuesMap == null){
            timeToValuesMap = new HashMap();
            timeBasedStorageMap.put(key, timeToValuesMap);
        }

        timeToValuesMap.put(timestamp, value);
    }
    //Function to get the value from the key and the timestamp
    public String get(String key, int timestamp) {
        Map<Integer, String> timeToValuesMap = timeBasedStorageMap.get(key);
        //if we cannot find any element with the current key, then return empty string
        if (timeToValuesMap == null){
            return defaultValue;
        }
        //return values
        String value = null;
        //keep going down the timestamp to look for the values
        while(timestamp >= 1){
            //check to see if we have found the values
            value = timeToValuesMap.get(timestamp);
            if (value != null){
                return value;
            }
            timestamp--;
        }

        return defaultValue;
    }



}
