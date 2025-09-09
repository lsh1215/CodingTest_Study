import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        SortedSet<Integer> set = new TreeSet<>();
        for (int num : numbers) {
            set.add(num);
        }
        
        for (int i = 0; i <= 9; i++) {
            if (!set.contains(i)) {
                answer += i;
            }
        }
        
        return answer;
    }
}