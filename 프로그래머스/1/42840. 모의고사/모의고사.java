import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[4];
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == person1[i%5]) scores[0]+=1;
            if(answers[i] == person2[i%8]) scores[1]+=1;
            if(answers[i] == person3[i%10]) scores[2]+=1;
        }
        
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                result.add(i + 1); 
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
        
    }
}