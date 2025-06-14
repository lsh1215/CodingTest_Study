import java.util.*;

class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                
            } else {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    
    public int solution(String s) {
        int answer = 0;
        System.out.println(s);
        
        char[] charArray = s.toCharArray();
        int length = charArray.length;
       
        
        
        Queue<Character> queue = new ArrayDeque<>();
        
        for(char c : charArray){
            queue.add(c);
        }
            
        for (int i = 0; i < length; i++) {
            StringBuilder rotated = new StringBuilder();

            for (int j = 0; j < length; j++) {
                char c = queue.poll();
                queue.add(c);  
                rotated.append(c);
            }

            if (isValid(rotated.toString())) {
                answer++;
            }

            queue.add(queue.poll());
        }
        
        return answer;
    }
}