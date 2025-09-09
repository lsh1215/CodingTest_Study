import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        
        Arrays.sort(arr);
        
        for(int a : arr){
            if(a % divisor == 0){
                answer.add(a);
            }
        }
        
        if(answer.size() == 0){
            answer.add(-1);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}