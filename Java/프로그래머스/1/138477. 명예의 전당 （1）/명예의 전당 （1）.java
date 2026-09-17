import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int i=0; i<score.length; i++){
            int size = heap.size();
            if(size < k) {
                heap.add(score[i]);
                answer.add(heap.peek());
            }
            else{
                int min = heap.poll();
                int bigger = Math.max(min, score[i]);
                heap.add(bigger);
                answer.add(heap.peek());
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}