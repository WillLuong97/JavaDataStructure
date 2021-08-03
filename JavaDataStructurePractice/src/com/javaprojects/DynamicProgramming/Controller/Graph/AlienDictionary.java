package com.javaprojects.DynamicProgramming.Controller.Graph;

import java.util.*;

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
* Each entire word in the array of the string is sorted in the lexicographically order as well
* so word[i-1] < word[i]
* *
* Approach: Topological Sort
* 1. Build the graph
*  Build out the graph from the list of words using a HashMap of Character, Set<Character>
*  Keep track of the number of indegrees of each character, this will be the map of Chacter -> Number
*
* 2. Apply topological sort to find the elements in the array
*
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
        //Find the order by applying the topological sort algorithm
        String result = topSort(graph, indegrees);
        return result.length() == graph.size() ? result : "";
    }
    //Helper method to build the adjacency list and find the number of indegress using a list
    private void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] indegress){
        //build out the graph, Character : HashSet
        for(String word: words){
            for(char c: word.toCharArray()) {
                graph.put(c, new HashSet<>());
            }
        }

        //loop through the array to which word is lexicographically lower
        for(int i = 1; i < words.length; i++){
            //getting the first and second word out of the array to compare them lexicographically
            String firstWord = words[i-1];
            String secondWord = words[i];
            int wordLength = Math.min(firstWord.length(), secondWord.length());

            for(int j = 0; j < wordLength; j++){
                char parent = firstWord.charAt(j);
                char child = secondWord.charAt(j);

                //compare the two chars together
                if(parent != child){
                    if(!graph.get(parent).contains(child)){
                        graph.get(parent).add(child);
                        indegress[child - 'a']++;
                    }
                    break;
                }
            }
            // The map: {r=[t], t=[f], e=[r], f=[], w=[e]}
        }
    }


    //Helper method to apply top sort on the graph of character to find the order of the alien dictionary
    private String topSort(Map<Character, Set<Character>> graph, int[] inDegrees){
        Queue<Character> queue = new LinkedList<>();
        //go into the map and put the character with no ingree onto it first, as it would be the first element
        for(char c : graph.keySet()){
            if(inDegrees[c - 'a'] == 0){
                queue.offer(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()){
            char current = queue.poll();
            result.append(current);
            //with TopSort, we will process the current node onto the queue first before we branch out to its neighbor
            for(char neighbor : graph.get(current)){
                inDegrees[neighbor - 'a']--;
                if(inDegrees[neighbor - 'a'] == 0){
                    queue.offer(neighbor);
                }
            }

        }

        return result.toString();

    }
}
