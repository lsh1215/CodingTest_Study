import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
        for (int s : score) {
            
            minHeap.add(s);
            
            // 2. 명예의 전당 크기가 k를 초과하면 가장 낮은 점수 제거
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            
            // 3. 현재 명예의 전당에서 가장 낮은 점수를 answer에 추가
            answer.add(minHeap.peek());
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}