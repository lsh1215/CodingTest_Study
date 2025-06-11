import java.util.*;

// 최하품 사과 p 
// 한 상자의 가격은 사과 갯수(m) * p
// 즉 가격 결정은 p가 영향을 줌
// 1 내림차순으로 정렬
// 2 m개씩 쪼개기
// p * 박스 갯수(전체 / m)

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Integer[] sorted = Arrays.stream(score)
                                 .boxed()
                                 .sorted(Collections.reverseOrder())
                                 .toArray(Integer[]::new);

        int boxCount = sorted.length / m;
        
        for (int i = 0; i < boxCount; i++) {
            int min = sorted[m - 1 + i * m];
            answer += min * m;
        }

        return answer;
    }
}