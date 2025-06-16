import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        Queue<String> card1Queue = new ArrayDeque<>();
        Queue<String> card2Queue = new ArrayDeque<>();
        
        for(String s : cards1){
            card1Queue.offer(s);
        }
        
        for(String s : cards2){
            card2Queue.offer(s);
        }
        
        for(int i=0; i<goal.length; i++){
            if(goal[i].equals(card1Queue.peek())){
                card1Queue.poll();
            }
            else if(goal[i].equals(card2Queue.peek())){
                card2Queue.poll();
            }
            else
                return "No";
        }
        
        return answer;
    }
}