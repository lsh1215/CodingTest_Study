// 옆에 놈하고 다이다이 
// 이기면 토너먼트 다음 라운드 진출
// 위로 올라가면 number 부여 다시

import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while(a!=b){
            a = (int) Math.ceil((double) a / 2);
            b = (int) Math.ceil((double) b / 2);
            answer++;
        }

        return answer;
    }
}