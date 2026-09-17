import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        PriorityQueue<Integer> xHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> yHeap = new PriorityQueue<>(Comparator.reverseOrder());
    
        char[] xArr = X.toCharArray();
        char[] yArr = Y.toCharArray();;
        
        for(char c : xArr) xHeap.add(c - '0'); 
        for(char c : yArr) yHeap.add(c - '0'); 
        
        StringBuilder sb = new StringBuilder();
        
        while(xHeap.size() != 0 && yHeap.size() !=0){
            if(xHeap.peek() > yHeap.peek()){
                xHeap.poll();
            }
            else if(xHeap.peek() < yHeap.peek()){
                yHeap.poll();
            }
            else{
                xHeap.poll();
                int max = yHeap.poll();
                sb.append(max);
            }
        }
        String answer = sb.toString();
        if(answer.equals("")) return "-1";
        else if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}