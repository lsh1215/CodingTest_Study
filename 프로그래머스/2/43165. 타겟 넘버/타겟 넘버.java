import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        
        for(int num : numbers){
            int levelsize = queue.size();
            
            for(int j=0; j<levelsize; j++){
                int currentSum = queue.poll();
                
                queue.add(currentSum + num);
                queue.add(currentSum - num);
            }
        }
        
        while(!queue.isEmpty()){
            if (queue.poll() == target) {
                answer++;
            }
        }
        
        return answer;
    }
}