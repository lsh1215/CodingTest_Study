import java.util.*;

class Solution {

    public Map<String, Integer> getMultiset(String str) {
        Map<String, Integer> multiset = new HashMap<>();
        
        String upperStr = str.toUpperCase();

        for (int i = 0; i < upperStr.length() - 1; i++) {
            String sub = upperStr.substring(i, i + 2);

            char char1 = sub.charAt(0);
            char char2 = sub.charAt(1);

            if (Character.isLetter(char1) && Character.isLetter(char2)) {
                multiset.put(sub, multiset.getOrDefault(sub, 0) + 1);
            }
        }
        
        return multiset;
    }

    public int solution(String str1, String str2) {
        Map<String, Integer> mapA = getMultiset(str1);
        Map<String, Integer> mapB = getMultiset(str2);

        if (mapA.isEmpty() && mapB.isEmpty()) {
            return 65536;
        }

        int intersection = 0; 
        int union = 0;       

        Set<String> allKeys = new HashSet<>(mapA.keySet());
        allKeys.addAll(mapB.keySet()); 

        for (String key : allKeys) {
            int countA = mapA.getOrDefault(key, 0);
            int countB = mapB.getOrDefault(key, 0);

            intersection += Math.min(countA, countB);
            union += Math.max(countA, countB);
        }

        double jaccard = (double) intersection / union;
    
        
        int answer = (int) (jaccard * 65536);
        
        return answer;
    }
}