import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int length = number.length();
        
        for (int i = 0; i < length; i++) {
            char current = number.charAt(i);
            
            while (!stack.isEmpty() && k > 0 && stack.peek() < current) {
                stack.pop();
                k--;
            }
            stack.push(current);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size() - k; i++) {
            sb.append(stack.get(i));
        }
        
        return sb.toString();
    }
}