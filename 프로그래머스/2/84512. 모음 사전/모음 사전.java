import java.util.*;

class Solution {
    private static final char[] VOWELS = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        List<String> dictionary = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();

        for (char c : VOWELS) {
            String initialWord = String.valueOf(c);
            queue.offer(initialWord);
            dictionary.add(initialWord);
        }

        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            
            if (currentWord.length() >= 5) {
                continue;
            }

            for (char nextChar : VOWELS) {
                String nextWord = currentWord + nextChar;
                
                queue.offer(nextWord);
                dictionary.add(nextWord); 
            }
        }
        
        Collections.sort(dictionary);
        
        return dictionary.indexOf(word) + 1;
    }
}