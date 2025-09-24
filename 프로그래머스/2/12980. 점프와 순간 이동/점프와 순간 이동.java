import java.util.*;

/*
5 - 1 = 4, sum = 1
4 / 2 = 2, sum = 1
2 / 2 = 1, sum = 1
1 - 1 = 0, sum = 2

6 / 2 = 3, sum = 0
3 - 1 = 2, sum = 1
2 / 2
*/    

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n > 0){
            if(n%2==0){
                n /= 2;
            }
            else {
                n -= 1;
                ans++;
            }
        }

        return ans;
    }
}