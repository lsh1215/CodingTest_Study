import java.util.*;

class Solution {
    public int solution(String dartResult) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (Character.isDigit(c)) {
                if (c == '0' && !stack.isEmpty() && stack.peek() == 1) {
                    stack.pop(); 
                    stack.push(10); 
                } else {
                    stack.push(Integer.parseInt(String.valueOf(c)));
                }
            } 
            else if (c == 'S') {
                int score = stack.pop();
                stack.push((int) Math.pow(score, 1));
            } 
            else if (c == 'D') {
                int score = stack.pop();
                stack.push((int) Math.pow(score, 2)); 
            } 
            else if (c == 'T') {
                int score = stack.pop();
                stack.push((int) Math.pow(score, 3)); 
            }
            else if (c == '*') {
                int currentScore = stack.pop();
                currentScore *= 2;
                
                if (!stack.isEmpty()) {
                    int prevScore = stack.pop();
                    prevScore *= 2; 
                    stack.push(prevScore); 
                }
                
                stack.push(currentScore);
            }
            else if (c == '#') {
                
                int currentScore = stack.pop();
                currentScore *= -1;
                stack.push(currentScore);
            }
        }

        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }
}

