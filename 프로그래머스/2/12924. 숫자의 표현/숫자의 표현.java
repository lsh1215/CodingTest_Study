class Solution {
    public int solution(int n) {
        int answer = 0;
        // 1부터 n까지의 모든 홀수를 확인합니다.
        for (int i = 1; i <= n; i += 2) {
            // i가 n의 약수인지 확인합니다.
            if (n % i == 0) {
                answer++;
            }
        }
        return answer;
    }
}