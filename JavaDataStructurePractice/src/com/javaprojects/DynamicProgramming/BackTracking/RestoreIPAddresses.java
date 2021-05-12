package com.javaprojects.DynamicProgramming.BackTracking;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.

A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "1111"
Output: ["1.1.1.1"]
Example 4:

Input: s = "010010"
Output: ["0.10.0.10","0.100.1.0"]
Example 5:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]


Constraints:

0 <= s.length <= 3000
s consists of digits only.

*  */
public class RestoreIPAddresses {
    List<String> result;
    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        //base case: we cannot build a valid ip address string if the assigned string are greater than 12, that would be too much
        //digits for us to put. And if the string is lesser than 4 then it does not have enough digits to pass into the array
        if(s.length() < 4 || s.length() > 12){
            //condition violated so return the empty
            return result;
        }
        //construct all valid ip addresses from the string using a recursion
        restoreIP(s, "", 0);
        return result;
    }

    //funtcion to build out all IP addresses from the current using recursion
    void restoreIP(String s, String sub, int section){
        //base case: if the string s is empty or section has reached over 4 digit, then check to see if we can make a valid ip address out of it
        if(s.length() == 0 || section == 4){
            //check if we can make a valid ip address, if so add it into the result list
            if(s.length() == 0 && section == 4){
                //125.554.11.205. => we want to get rid of the final .
                result.add(sub.substring(0, sub.length() - 1));
            }
            //if not, backtrack and look for other cases
            return;

        }

        //3 conditions: ways of building out a valid IP address string
        //making a section with only 1 digit
        restoreIP(s.substring(1), sub + s.substring(0,1) + ".", section+1);

        //making a section with 2 digit, no leading 0
        if(s.length() >= 2 && s.charAt(0) != '0'){
            restoreIP(s.substring(2), sub + s.substring(0,2) + ".", section+1);
        }
        //making a section with 3 digit, no leading 0 and 3 number combined must be lesser than 255.
        if(s.length() >= 3 && s.charAt(0) != '0' && Integer.valueOf(s.substring(0,3)) <= 255){
            restoreIP(s.substring(3), sub + s.substring(0,3) + ".", section+1);
        }
    }
}
