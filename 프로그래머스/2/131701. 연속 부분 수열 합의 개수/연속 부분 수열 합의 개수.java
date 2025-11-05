import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;

        // 이게 포인트임
        int[] extended = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            extended[i] = elements[i % n];
        }
        //길이 case에 대한 반복
        for (int length = 1; length <= n; length++) {
            // 기준잡기 
            for (int start = 0; start < n; start++) {
                
                int sum = 0;
                // 내부에서 합하기
                for (int i = 0; i < length; i++) {
                    sum += extended[start + i];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}