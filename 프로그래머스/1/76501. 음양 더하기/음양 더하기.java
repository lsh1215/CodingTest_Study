class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int length = absolutes.length;
        
        for(int i=0; i<length; i++){
            if(signs[i]==true) answer += absolutes[i];
            else if(signs[i]==false) answer -= absolutes[i];
        }
        
        return answer;
    }
}