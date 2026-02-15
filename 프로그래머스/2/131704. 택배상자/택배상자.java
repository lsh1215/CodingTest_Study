import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i=1; i<=order.length; i++){
            queue.offer(i);
        }
        
        int i = 0;
        
        while(i < order.length){
            if(!queue.isEmpty() && order[i] == queue.peek()){
                queue.poll();
                answer++;
            }
            else if(!queue.isEmpty() && order[i] > queue.peek()){
                while(!queue.isEmpty() && order[i] > queue.peek()){
                    stack.push(queue.poll());
                }
                queue.poll(); 
                answer++;
            }
            else {
                if(!stack.isEmpty() && order[i] == stack.peek()){
                    stack.pop();
                    answer++;
                }
                else{
                    break; 
                }
            }
            i++;
        }

        return answer;
    }
}