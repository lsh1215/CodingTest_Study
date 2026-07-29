import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int length = topping.length;
        
        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();
        int[] left = new int[length];
        int[] right = new int[length];
        
        for(int i=0;i<length;i++){
            leftSet.add(topping[i]);
            left[i] = leftSet.size();
        }

        for(int i=length-1;i>=0;i--){
            rightSet.add(topping[i]);
            right[i] = rightSet.size();
        }

        for(int i=0;i<length-1;i++){
            if(left[i] == right[i+1]) answer++;
        }
        

        return answer;
    }
    
}