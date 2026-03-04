import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        boolean[] visited = new boolean[words.length]; 
        Queue<Node> queue = new ArrayDeque<>();
        
        queue.offer(new Node(begin, 0)); 
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (current.word.equals(target)) {
                return current.step;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && checkDiff(current.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], current.step + 1));
                }
            }
        }
        
        return 0;
    }
    
    private boolean checkDiff(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1; 
    }
    
    class Node {
        String word;
        int step;
        
        public Node(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }
}