import java.util.*;

class Solution {
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        int answer = dfs(begin, target, words, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private int dfs(String current, String target, String[] words, int depth) {
        int min = Integer.MAX_VALUE;
        if (current.equals(target)) {
            return depth;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i] || strDiff(current, words[i]) != 1) {
                continue;
            }

            visited[i] = true;

            int result = dfs(words[i], target, words, depth + 1);
            min = Math.min(min, result);

            visited[i] = false;
        }

        return min;
    }

    private static int strDiff(String a, String b) {
        int cnt = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }

        return cnt;
    }
}