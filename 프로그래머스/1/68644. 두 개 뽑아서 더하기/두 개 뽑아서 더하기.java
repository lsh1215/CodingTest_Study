import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        TreeSet<Integer> treeset = new TreeSet<>();
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                treeset.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[treeset.size()];
        
        int idx = 0;
        for (int num : treeset) {
            answer[idx++] = num;
        }
        
        return answer;
    }
    
}