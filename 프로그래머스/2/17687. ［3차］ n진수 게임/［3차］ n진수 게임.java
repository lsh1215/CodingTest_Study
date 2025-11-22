import java.util.*;

class Solution {
    private static final char[] NOTATION = "0123456789ABCDEF".toCharArray();

    public String solution(int n, int t, int m, int p) {
        StringBuilder sequence = new StringBuilder();
        StringBuilder result = new StringBuilder();

        List<Integer> currentNum = new ArrayList<>();
        currentNum.add(0);

        while (sequence.length() < t * m) {
            for (int num : currentNum) {
                sequence.append(NOTATION[num]);
            }

            increment(currentNum, n);
        }
        
        for (int i = 0; i < t; i++) {
            result.append(sequence.charAt((p - 1) + (i * m)));
        }

        return result.toString();
    }

    private void increment(List<Integer> numList, int n) {
        int lastIndex = numList.size() - 1;
        
        numList.set(lastIndex, numList.get(lastIndex) + 1);

        for (int i = lastIndex; i >= 0; i--) {
            if (numList.get(i) == n) {
                numList.set(i, 0); 

                if (i == 0) {
                    numList.add(0, 1);
                } 
                else {
                    numList.set(i - 1, numList.get(i - 1) + 1);
                }
            } 
            else break;
        }
    }
}