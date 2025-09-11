import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        
        for(char c : chars){
            if(stack.isEmpty() || !stack.peek().equals(c)){
                stack.add(c);
            } 
            else if(stack.peek().equals(c)){
                stack.pop();
            }
            
                
        }
        
        if(stack.isEmpty()) answer = 1;

        return answer;
    }
}