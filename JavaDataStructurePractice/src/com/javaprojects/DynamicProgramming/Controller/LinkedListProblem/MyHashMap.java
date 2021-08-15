package com.javaprojects.DynamicProgramming.Controller.LinkedListProblem;

/**
 * Design a HashMap without using any built-in hash table libraries.
 *
 * Implement the MyHashMap class:
 *
 * MyHashMap() initializes the object with an empty map.
 * void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
 * int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * Output
 * [null, null, null, 1, -1, null, 1, null, -1]
 * Explanation
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // The map is now [[1,1]]
 * myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
 * myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
 * myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
 * myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
 * myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
 * myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
 * myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]
 *
 *
 * Constraints:
 *
 * 0 <= key, value <= 106
 *
 *  At most 104 calls will be made to put, get, and remove. 
 * 
 * Approach: 
 * 
 * We can use the linekd list to store the key value pair. (key.next = value)
 *  
 * We are storing an arary of linked list
 * [(1:1),(2:2)]
 * 
 * We will combine the key-value pair into one linked list node and its next value will be the next node. 
 * 
 * Node 1.value = 1 and node.next = Node_2
 * 
 * get(1) => We will traverse through the linked list to find the element in the array to find the key and return its value
 * remove(1) => remove 1.next = null, 1 = null 
 * 
 * How to implement the linked list? do we have one massive linked list or assing multiple smaller linked list for each key-value pair
 *  
 * **/
class MyHashMap {

    //custom linked list node: 
    class Node{
        int key;
        int value; 
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            next = null;      
        }
    }

    //helper method to convert the key into a hashcode
    private int getHashCode(int key){
        return Math.abs(key % 9999);
    }

    //Create the array to keep track of the items needed to get pushed onto the map 
    private Node[] items;


    //constuctor to create a hash map
    public MyHashMap() {
        //init the linked list
        items = new Node[1000];
    }

    /** value will always be non-negative. 
     * We will put the key value pair onto the map as a seperate node
    */
    public void put(int key, int value) {
        //convert the key into the hash code
        int hashed = getHashCode(key);

        //check to see if the key has been stored, if the key has not been created, then we will add the key value pair into the 
        //list as the has
        if(items[hashed] == null){
            items[hashed] = new Node(hashed, value);
        } else {
            Node tmpNode = items[hashed];
            //check if the key is a matched
            if(tmpNode.key == key){
                tmpNode.value = value;
            } else {
                //if it is not the same key, then traverse through the linked list to find it
                while(tmpNode.next != null){
                    tmpNode = tmpNode.next;
                    //check for the matched key to override the value with the input value
                    if(tmpNode.key == key){
                        tmpNode.value = value;
                        return;
                    }          

                }

                tmpNode.next = new Node(key, value);          
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashed = getHashCode(key);

        //find the key in the linked list and return it
        if(items[hashed] != null){
            Node curr = items[hashed];
            //check to see if key is foudn
            if(curr.key == key){
                return curr.value;
            }      
            //otherwise, if traversing the linked list to find the key
            while(curr.next != null){
                curr = curr.next;
                if(curr.key == key){
                    return curr.value;
                }

            }
            
        }
        //cannot find the key
        return -1; 
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        //get the hashed code
        int hashed = getHashCode(key);

        if(items[hashed] != null){
            Node curr  = items[hashed];
            if(curr.key == key){
                items[hashed] = curr.next;
                return;
            }
            while(curr != null && curr.next != null){
                curr = curr.next;
                if(curr.next.key == key){
                    curr.next = curr.next.next; 
                    return;
                }
            }
            curr = curr.next;
        }

    }

}
