import java.util.*;

class Solution {
    public static boolean HaveItem(Map<String, Integer> map, Map<String, Integer> tempMap) {
        for (String key : map.keySet()) {
            if (tempMap.getOrDefault(key, 0) < map.get(key)) {
                return false;
            }
        }
        return true;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> tempMap = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
                tempMap.put(discount[j], tempMap.getOrDefault(discount[j], 0) + 1);
            }

            if (HaveItem(map, tempMap)) {
                answer++;
            }
        }

        return answer;
    }
        
}