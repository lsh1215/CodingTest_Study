import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        int size = (int)(right - left + 1);
        int[] answer = new int[size];

        for (long k = left; k <= right; k++) {
            
            long row = k / n;
            long col = k % n;

            int value = (int)(Math.max(row, col) + 1);

            int index = (int)(k - left);
            answer[index] = value;
        }
        
        return answer;
    }
}