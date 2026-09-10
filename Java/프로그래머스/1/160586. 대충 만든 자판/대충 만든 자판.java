import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            char[] keys = keymap[i].toCharArray();

            for (int j = 0; j < keys.length; j++) {
                map.putIfAbsent(keys[j], j + 1);
                map.put(keys[j],Math.min(map.get(keys[j]), j + 1));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            char[] tgArray = targets[i].toCharArray();

            for (int j = 0; j < tgArray.length; j++) {
                if (!map.containsKey(tgArray[j])) {
                    answer[i] = -1;
                    break;
                }

                answer[i] += map.get(tgArray[j]);
            }
        }

        return answer;
    }
}