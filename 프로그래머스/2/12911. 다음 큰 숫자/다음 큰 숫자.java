import java.util.*;

class Solution {
    public int solution(int n) {
        
        int nOneCount = Integer.bitCount(n);
        int nextNum = n + 1;

        while(true) {
            if (Integer.bitCount(nextNum) == nOneCount) {
                return nextNum;
            }
            nextNum++; 
        }
    }
}