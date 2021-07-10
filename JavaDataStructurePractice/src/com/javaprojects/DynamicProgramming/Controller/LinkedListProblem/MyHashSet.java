package com.javaprojects.DynamicProgramming.Controller.LinkedListProblem;

/**

 Design a HashSet without using any built-in hash table libraries.

 Implement MyHashSet class:

 void add(key) Inserts the value key into the HashSet.
 bool contains(key) Returns whether the value key exists in the HashSet or not.
 void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.


 Example 1:

 Input
 ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 Output
 [null, null, null, true, false, null, true, null, false]

 Explanation
 MyHashSet myHashSet = new MyHashSet();
 myHashSet.add(1);      // set = [1]
 myHashSet.add(2);      // set = [1, 2]
 myHashSet.contains(1); // return True
 myHashSet.contains(3); // return False, (not found)
 myHashSet.add(2);      // set = [1, 2]
 myHashSet.contains(2); // return True
 myHashSet.remove(2);   // set = [1]
 myHashSet.contains(2); // return False, (already removed)


 Constraints:

 0 <= key <= 106
 At most 104 calls will be made to add, remove, and contains.


 Hashset: only store unique element into the hashset and if the element already exist, it would not add another copy
 of the same element into the hashset.

 **/

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 **/


/**
 * Approach: We will use a doubly linked list to as the main data structure to store and access data
 * in this hashset implemnetation.

 *  **/

public class MyHashSet {
    //List node class:
    class DoublyNode{
        int val;
        DoublyNode next;
        DoublyNode prev;
    }

    //constant variable for the head and tails:
    final DoublyNode head = new DoublyNode();
    final DoublyNode tail = new DoublyNode();

    /** Initialize your data structure here. */
    public MyHashSet() {
        //init the doubly linked list by connecting the head with the tails
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    //add a key into the hashset if it is not already contained int the array
    //add it into the tails
    public void add(int key) {
        if(!contains(key)){
            //create a new node to contains its value
            DoublyNode new_node = new DoublyNode();
            new_node.val = key;

            tail.prev.next = new_node;
            new_node.prev = tail.prev;
            new_node.next = tail;
            tail.prev = new_node;

        }
    }

    public void remove(int key) {
        //remove a key if it already exist in the array, otherwise, dont do anything
        if(contains(key)){
            DoublyNode curr_node = getNode(key);
            DoublyNode prev_node = curr_node.prev;
            DoublyNode next_node = curr_node.next;

            //remove it by removing its linkage between the prev and the next node
            prev_node.next = next_node;
            next_node.prev = prev_node;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        //if the key is already contained in the linked list then it should return us a node value
        return getNode(key) != null ? true : false;

    }

    //helper method to get the node value from the int input key
    private DoublyNode getNode(int key){
        //init the pointer to traverse through the linked list
        DoublyNode result = head.next;
        //check for the rest of the list to find the node value based on its key
        while (result != tail){
            if(result.val == key){
                return result;
            }
            result = result.next;
        }

        return null;
    }
}
