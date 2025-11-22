import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int w : works){
            pq.offer(w);
        }
        
        while(n > 0){
            int max = pq.poll();
            
            if(max == 0) return 0;
            
            max--;
            n--;
            
            pq.offer(max);
        }
        
        int size = pq.size();
        
        for(int i=0; i<size; i++){
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}