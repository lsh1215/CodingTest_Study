import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        int range = (2 * w) + 1;
        int end = 0;
        
        for(int i=0; i<stations.length; i++){
            end = stations[i] - w - 1;
            
            int current = end - start + 1;
            
            if(current > 0) {
                answer += (current / range); 
                
                if(current % range != 0)
                    answer++;
            }
                
            start = stations[i] + w + 1;
        }
        
        if(start <= n){
            end = n;
            
            int current = end - start + 1;
            
            if(current != 0) {
                answer += (current / range); 
                
                if(current % range != 0)
                    answer++;
            }
        }
        
        return answer;
    }
}