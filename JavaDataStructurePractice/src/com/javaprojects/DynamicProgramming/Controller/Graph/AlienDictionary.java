package com.javaprojects.DynamicProgramming.Controller.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
* There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Input:
[
  "z",
  "x"
]

Output: "zx"
Input:
[
  "z",
  "x",
  "z"
]

Output: ""

Explanation: The order is invalid, so return "".
*
*
*
* You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
*
*
https://massivealgorithms.blogspot.com/2019/04/leetcode-269-alien-dictionary.html
*
*
*
* Approach: Topological Sort
* 1. Build the graph
*  Build out the graph from the list of words using a HashMap of Character, Set<Character>
*  Keep track of the number of indegrees of each character, this will be the map of Chacter -> Number
*
* 2. Apply topological sort to find the elements in the array
*
*  */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        //base case: the list is empty
        if(words.length == 0){
            return "";
        }
        //Create a hashmap to represent the adjacency list relationship
        Map<Character, Set<Character>> graph = new HashMap<>();
        //create an array to store the number of indegress of each character in the dictionary
        int[] indegrees = new int[26];
        //build out the graph
        buildGraph(words, graph, indegrees);

    }
    //Helper method to build the adjacency list and find the number of indegress using a list
    private void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] indegress){
        //build out the graph
        for(String word: words){
            for(char c: word.toCharArray()){
                graph.put(c, new HashSet<>());
            }
        }



    }
}
