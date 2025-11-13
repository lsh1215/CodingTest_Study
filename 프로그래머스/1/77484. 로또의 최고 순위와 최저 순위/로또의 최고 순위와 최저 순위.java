// lottos를 set에 담으면 전체 길이 - size + 1 이  0 갯수임
import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {    
        Set<Integer> lottoSet = new HashSet<>();
        int max = 0;
        int min = 0;
        
        
        for(int i=0; i<lottos.length; i++){
            lottoSet.add(lottos[i]);
        }
        
        int zeroCount = lottos.length - lottoSet.size() + 1;
        if(!lottoSet.contains(0)){
            zeroCount = 0;
        }
        
        
        for(int i=0; i<win_nums.length; i++){
            int size = lottoSet.size();
            
            lottoSet.add(win_nums[i]);
            
            if(lottoSet.size() > size){
                if(zeroCount > 0){
                    max++;
                    zeroCount--;
                }
            }
            else{
                max++;
                min++;
            }
        }
        
        max = 7 - Math.max(max,1);
        min = 7 - Math.max(min,1);
        
        
        
        int[] answer = new int[]{max, min};
        return answer;
    }
}