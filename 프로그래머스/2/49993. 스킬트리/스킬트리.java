import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String stree : skill_trees){
            Queue<Character> queue = new ArrayDeque<>();
            Set<Character> set = new HashSet<>();
            
            for(char s : skill.toCharArray()){
                set.add(s);
                queue.offer(s);
            }
            
            boolean pass = true;
            for(char c : stree.toCharArray()){
                if(!set.isEmpty() && set.contains(c)){
                    set.remove(c);
                    
                    if(!queue.poll().equals(c)){
                        pass = false;
                        break;
                    }
                }
                
            }
            if(pass == true) answer++;
        }
        return answer;
    }
}