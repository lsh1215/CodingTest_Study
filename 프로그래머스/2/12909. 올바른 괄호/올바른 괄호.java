import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        char[] charArray = s.toCharArray();
        
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
            } else if(c == ')'){
                if (stack.isEmpty() || stack.peek() != '('){
                    return false;
                }
                stack.pop();
            }
        }
        
        if(!stack.isEmpty()) return false;

        return true;
    }
}