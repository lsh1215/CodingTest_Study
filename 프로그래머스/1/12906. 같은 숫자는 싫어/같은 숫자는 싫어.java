import java.util.*;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int n = arr.length;
        
        List<Integer> list = new ArrayList<>();
        
        int prev = -1;
        for (int x : arr) {
            if (x != prev) {
                list.add(x);
                prev = x;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}