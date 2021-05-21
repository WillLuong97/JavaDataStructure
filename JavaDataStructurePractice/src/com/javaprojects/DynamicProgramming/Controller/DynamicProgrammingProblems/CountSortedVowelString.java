package com.javaprojects.DynamicProgramming.Controller.DynamicProgrammingProblems;

import java.util.HashMap;
import java.util.Map;

/*
1641. Count Sorted Vowel Strings
Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
Example 2:

Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
Example 3:

Input: n = 33
Output: 66045

Constraints:

1 <= n <= 50
base case: if n == 1: return 5 because there are 5 unique string that can be made out of the length 1 ["a","e","i","o","u"]

for other cases with other length
we will have to generate the permutation of each vowel with other vowels.

we only have to generate all string with the length of n but not up to 2, len(s) < n

if n ==2 :

visited check requirement to make sure that there is no duplication:
requirements: lexicographically sorted for each strings and each character within each string
"a":  "aa", "ae", "ai", "ao", "au"
"e":  "ee", "ei", "eo", "eu"
"i": "ii", "io", "iu"
"o": "oo", "ou"
"u": "uu"
Approach: build out all possible permutation of each string, make sure that the length of each string == n.
main function to generate the left most letter and then pass in the current string into the recursion

recursion would generate the rest of sub-solution string.


recursion tree:
represent each vowel as a number from 1 - 5
n = 3
                            "a"
                        "aa" "ae" "ai" "ao" "au"
                        5     5
                "aaa" "aae" "aai" "aao" "aau"

Time complexity: O(n^5)
Space complexity: O(n), n is the depth of recursion tree.

*  */
public class CountSortedVowelString {
    //This approach is basic brute force through dynamic programming
    public int countVowelStrings(int n){
        return recursion(n, 0);
    }
    private int recursion(int n, int vowel){
        //base case: if n == 0, this means that our current substring is out of the current required length
        if(n == 0){
            return 1;
        }
        //variable to keep track of the number of string from vowel that we have built so far
        int count = 0;
        //loop through the vowel list, labeling from 1 to 5 and build a vowel string from there
        for(int i = vowel; i < 5; i++){
            count += recursion(n-1, i);
        }
        return count;
    }
    //optimize with injecting memoization:
    public int countVowelStrings_MEMOIZATION(int n){
        return recursion_MEMOIZATION(n, 0, new char[]{'a', 'e', 'i', 'o', 'u'}, new HashMap<>());
    }
    private int recursion_MEMOIZATION(int n, int vowel, char[] vowelList, Map<String, Integer> map){
        //base case: if n = 0, return 1 as our current substring has maxed out the required length
        if(n == 0){
            return 1;
        }

        var key = vowelList[vowel] + "," + n;

        if(map.containsKey(key)){
            return map.get(key);
        }
        var count = 0;
        for(int i = vowel; i < 5; i++){
            count += recursion_MEMOIZATION(n-1, i, vowelList, map);
        }
        //variable to count the number of vowel string that we have found:
        map.put(key, count);
        return count;
    }
}
