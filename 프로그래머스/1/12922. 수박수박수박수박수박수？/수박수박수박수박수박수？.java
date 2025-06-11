class Solution {
    public String solution(int n) {
        String answer = "";
        String[] pattern = {"수", "박"};
        
        
        for(int i=0; i<n; i++){
            answer += pattern[i%2];
        }
        return answer;
    }
}