import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        long pValue = Long.parseLong(p); 

        for (int i = 0; i <= t.length() - pLength; i++) {
            String subStr = t.substring(i, i + pLength);
            
            long subValue = Long.parseLong(subStr);
            
            if (subValue <= pValue) {
                answer++;
            }
        }
        
        return answer;
    }
}