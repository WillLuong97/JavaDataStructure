package com.javaprojects.DynamicProgramming.Controller.Graph;

import java.util.*;

/*
Given a list of product ids, group them according to their categories and return the new list containing the
categorized Products IDs

Example:
Input: ((1,2), (2,5), (3,4), (4,6), (6,8), (5,7), (5,2), (5,2))

Output:
((1,2,5,7), (3,4,6,8))

Input: ((1,2), (3,4), (5,7), (6,8))
Output: ((1,2), (3,4), (5,7), (6,8))

Approach: we will convert the input into a hashmap and with the key being all the unique ids in the input and the value being
the set of related ids.

Psuedocode:
init a "hashmap" to store an Integer key and a Set()
loop through the 2d matrix of ids:
    if the ids[0] not already in the hashmap:
        init a hashmap key with the id value and have it stored a new Set()
    Otherwise, if id[0] is already in the hashmap:
        add id[1] into the current key value set.

init an empty visited array to keep track of visited node

loop through the 2d matrix again: iterator i
    if the current ids[0] is not already in visited:
        visited.add(ids[i[0])
        pass ids and visisted into the dfs recursive function
        after the recursion is done, we should get an array back, so add that array into our result variable
    continue looping for the next node

return result;

helper method to perform dfs onto
function dfs(int[] pair, int[] visited, int[][] hashmap) -> return an int[]:
    get the two ids out of the current pair
    init id_1 to be the first id in the pair, i.e, pair[0]
    init id_2 to be the first id in the pair, i.e, pair[1]
    int[] result;
    resul.add(id_1, id_2);
    loop through the value of id_1, i.e, hashmap[id_1]:
        if(the neighbor_node is not already visited):
            add it into the visited array
            pass the neighbor_node into the next recursion of dfs => dfs(neighbor_node, visited, hashmap)
    return result;

Time complexity: O(mxn),
Space complexity: O(mxn), we have to store a hashmap that store both the unique node and its neighbor
*  */
public class ProductGrouping {
    public List<List<Integer>> productGroups(List<List<Integer>>ids){
//        int row = ids.length;
//        int col = ids[0].length;
//        base case: ids list is empty
//        if(row == 0 || col == 0){
//            throw new RuntimeException("Empty Array");
//        }

        //create a hashmap to store the ids with its related ids as key and values:
        HashMap<Integer, HashSet<Integer>> id_relation_map = new HashMap<>();

        //loop through the ids and add the value onto the map
        for (List<Integer> pairs : ids){
            id_relation_map.putIfAbsent(pairs.get(0), new HashSet<>());
            id_relation_map.putIfAbsent(pairs.get(1), new HashSet<>());

            id_relation_map.get(pairs.get(0)).add(pairs.get(1));
            id_relation_map.get(pairs.get(1)).add(pairs.get(0));

        }

        List<List<Integer>> categorizedProduct = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();

        for(int product : id_relation_map.keySet()){
            if(!visited.contains(product)){
                List<Integer> products = new ArrayList<>();
                getNode(product, id_relation_map, products, visited);
                categorizedProduct.add(products);
            }

        }
        return categorizedProduct;
    }


    //helper method to run dfs through a graph
//    private List<Integer> dfs(int curr_id, Set<Integer> visited_ids, Map<Integer, Set<Integer>> id_map, List<Integer> grouping){
//        // traverse through the list of neighbor of id_1, if the set value of id_1 is not empty
//        if(id_map.get(curr_id) != null){
//            for(int id : id_map.get(curr_id)){
//                if((!visited_ids.contains(id))){
//                    visited_ids.add(id);
//                    grouping.add(id);
//                    dfs(id, visited_ids, id_map, grouping);
//                }
//            }
//        }
//        return grouping;
//    }
    public static void getNode(int currNode, HashMap<Integer, HashSet<Integer>> edges, List<Integer> product, HashSet<Integer> visited){
        product.add(currNode);
        visited.add(currNode);
        for(int edge : edges.get(currNode)){
            if(!visited.contains(edge)){
                getNode(edge, edges, product, visited);
            }
        }
    }
}
