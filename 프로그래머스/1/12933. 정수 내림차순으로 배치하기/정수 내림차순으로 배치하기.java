import java.util.*;

class Solution {
    
    public long solution(long n) {
        long num = n;
        int count = 0;
        
        while (num > 0) {
            num /= 10;
            count++;
        }
        
        char[] arr = new char[count];
        
        for (int i = 0; i < count; i++) {
            arr[i] = (char)((n % 10) + '0');  
            n /= 10;
        }
        
        Arrays.sort(arr); 
        
        StringBuilder answer = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            answer.append(arr[i]);
        }
        
        return Long.parseLong(answer.toString());
    }
}
