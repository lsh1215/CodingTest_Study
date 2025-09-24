import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int boatCount = 0;
        // 제일 작은쪽
        int left = 0;
        // 제일 큰쪽
        int right = people.length - 1; 

        while (left <= right) {
            boatCount++;

            // 작은 놈 + 큰 놈 <= limit, 즉 보트에 탈 수 있으면
            if (people[left] + people[right] <= limit) {
                // 다음단계로
                left++;
            }
            // 큰 놈을 덜 큰 놈으로 바꿔보기
            right--;
        }

        return boatCount;
    }
}