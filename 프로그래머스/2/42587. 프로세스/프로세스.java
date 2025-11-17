import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Integer> seq = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<priorities.length; i++){
            seq.offer(i);
            pq.offer(priorities[i]);
        }
        
        while(true){
            int x = seq.poll();
            int max = pq.peek();
            
            if(priorities[x] < max){
                seq.offer(x);
            }
            else{
                if(x == location) break;
                else {
                    pq.poll();
                    answer++;
                }
            }
        }
        
        return answer;
    }
}