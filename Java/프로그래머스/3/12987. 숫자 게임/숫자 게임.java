// 1.3.7.9
// 2.2.6.8
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int count = 0;
        PriorityQueue<Integer> Aheap = new PriorityQueue<>();
        PriorityQueue<Integer> Bheap = new PriorityQueue<>();
        
        for(int i=0; i<A.length; i++){
            Aheap.add(A[i]);
            Bheap.add(B[i]);
        }
        
        while(Aheap.size() != 0 && Bheap.size() != 0){
            Integer current = Bheap.poll();
            
            if(Aheap.peek() >= current)
                continue;
            
            Aheap.poll();
            count+=1;
        }
        
        return count;
    }
}