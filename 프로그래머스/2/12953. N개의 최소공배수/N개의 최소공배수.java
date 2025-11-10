import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }
    
    /**
     * a와 b의 최대공약수를 반환합니다.
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b; 
            
            a = b;
            b = r;
        }
        return a; 
    }

    /**
     * a와 b의 최소공배수를 반환합니다.
     * LCM(a, b) = (a * b) / GCD(a, b)
     */
    private int lcm(int a, int b) {
        return a * (b / gcd(a, b)); 
    }
}