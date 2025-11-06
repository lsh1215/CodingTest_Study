import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Integer[] integerCitations = Arrays.stream(citations)
                                           .boxed()
                                           .toArray(Integer[]::new);
        
        Arrays.sort(integerCitations, Collections.reverseOrder());
        
        int n = citations.length;
        
        for (int i = 0; i < n; i++) {
            if (integerCitations[i] < i + 1) { 
                answer = i;
                break;
            }
            
            if (i == n - 1) {
                answer = n;
            }
        }
        
        return answer;
    }
}