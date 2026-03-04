class Solution {
    private int minCount = 9;

    public int solution(int N, int number) {
        dfs(0, 0, N, number);
        
        return minCount > 8 ? -1 : minCount;
    }

    private void dfs(int count, int currentVal, int N, int number) {
        if (count > 8) {
            return;
        }

        if (currentVal == number) {
            minCount = Math.min(minCount, count);
            return;
        }

        int tempN = 0;
        for (int i = 1; i <= 8 - count; i++) {

            tempN = tempN * 10 + N;

            dfs(count + i, currentVal + tempN, N, number);
            dfs(count + i, currentVal - tempN, N, number);
            dfs(count + i, currentVal * tempN, N, number);
            dfs(count + i, currentVal / tempN, N, number);
        }
    }
}