import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;

        if (n < 2) {
            return 0;
        }

        int[] prefixUnique = new int[n];
        Set<Integer> leftSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            leftSet.add(topping[i]);
            prefixUnique[i] = leftSet.size();
        }

        int[] suffixUnique = new int[n];
        Set<Integer> rightSet = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            rightSet.add(topping[i]);
            suffixUnique[i] = rightSet.size();
        }

        for (int i = 0; i < n - 1; i++) {
            if (prefixUnique[i] == suffixUnique[i + 1]) {
                answer++;
            }
        }

        return answer;
    }
}