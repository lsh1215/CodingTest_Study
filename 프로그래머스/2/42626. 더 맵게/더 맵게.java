import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int sco : scoville){
            pq.offer(sco);
        }
        
        while(pq.size() > 1){
            int minFirst = pq.poll();
            
            if(minFirst >= K){
                break;
            }
            
            int minSec = pq.poll();
            
            pq.offer(minFirst + (minSec * 2));
            answer++;
        }
        
        if(pq.size() == 1 && pq.poll() < K) return -1;
        
        return answer;
    }
}