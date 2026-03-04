import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int count = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int n : numbers){
            if(queue.isEmpty()){
                queue.add(n);
                queue.add(-n);
            }
            else {
                int size = queue.size();
                
                for(int i=0; i<size; i++){
                    int current = queue.poll();
                
                    queue.add(current + n);
                    queue.add(current - n);
                }
            }
        }
        
        while(!queue.isEmpty()){
            if(queue.poll() == target)
                count++;
        }
        
        return count;
    }
}