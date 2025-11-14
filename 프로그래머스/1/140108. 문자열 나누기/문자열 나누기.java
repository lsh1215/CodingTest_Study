import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char[] charArr = s.toCharArray();
        
        char fChar = charArr[0];
        int first = 1;
        int other = 0;
        
        for (int i = 1; i < charArr.length; i++) {
            if (first == 0) {
                
                fChar = charArr[i];
                first = 1;
                other = 0;
                continue;
            }

            if (fChar == charArr[i]) {
                first++;
            } else {
                other++;
            }

            if (first == other) {
                answer++;
                first = 0; 
                other = 0;
            }

        }
        
        if(first != 0) answer++;
        
        return answer;
    }
}