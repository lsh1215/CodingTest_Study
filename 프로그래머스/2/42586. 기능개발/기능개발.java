// 먼저 했는데 뒤에 한게 더 빠를 수 있다
// 뒤에 있는 기능은 앞에 꺼가 배포될 때 배포가 된다
// 배포되어야 하는 순서대로 progresses가 있다.
// 각 작업의 개발 속도가 적힌 speeds가 있다
// 각 기능 당 몇개씩 배포가 되는가
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++){
            queue.add((int) Math.ceil((100 - (double)progresses[i]) / speeds[i]));
        }
        
        int n = queue.size();
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int count = 1;
            
            while (!queue.isEmpty() && queue.peek() <= current) {
                queue.poll();
                count++;
            }
            
            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}