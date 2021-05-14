package com.javaprojects.DynamicProgramming.Controller.DynamicProgrammingProblems;

import java.util.Stack;

/*Implement a smart stack, instead of using a stack to generate all possible substring combination and sort through them,
we just need to add the "(" onto the stack and everytime we see a ")" on the string we will check if the stack is empty or not, if
it is then we pop it out of the stack and check if we can create a valid parenthese string

Time complexity: O(n), where n is the length of the give string
Space complexity: O(n), n is the size of the stack
*  */
public class LongestValidParenthese {
    public int longestValidParentheses(String s) {
        //base case:
        if(s.length() == 0){
            return 0;
        }

        //result variable to keep track of the longest substring
        int result = 0;
        //a stack to keep track of the "(" by its index
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); //the stack is currently empty
        for(int i = 0; i < s.length(); i++){
            //we will give reference to the open parentheses:
            if(s.charAt(i) == '('){
                //push the index of the char onto the stack
                stack.push(i);
            } else{
                stack.pop();
                //if the stack is currently empty, then we will add the current index into the stack
                if(stack.isEmpty()){
                    stack.push(i);
                } else {
                    //otherwise, calculate the longest path.
                    result = Math.max(result, i - stack.peek());
                }

            }
        }
    return result;
    }
}
