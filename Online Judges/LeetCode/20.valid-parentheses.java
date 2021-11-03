/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if(s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']'){
            return false;
        }


        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else{
                if(s.charAt(i) == ')'){
                    if(stack.empty()){
                        return false;
                    }
                    Character top = stack.peek();
                    if(top.equals('(')){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else if(s.charAt(i) == ']'){
                    if(stack.empty()){
                        return false;
                    }
                    Character top = stack.peek();
                    if(top.equals('[')){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else if(s.charAt(i) == '}'){
                    if(stack.empty()){
                        return false;
                    }
                    Character top = stack.peek();
                    if(top.equals('{')){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }

        if(stack.empty()){
            return true;
        }else{
            return false;
        }

    }
}
// @lc code=end

