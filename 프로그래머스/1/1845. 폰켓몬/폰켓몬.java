import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int n : nums){
            set.add(n);
        }
        
        int count = nums.length / 2;
        if(set.size() < count){
            return set.size();
        }
        return count;
    }
}