class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=Math.min(left, right); i<=Math.max(left,right); i++){
            if(isEvenNum(i)) answer+= i;
            else answer -= i;
        }
        return answer;
    }
    
    public boolean isEvenNum(int a){
        if(Math.sqrt(a) == Math.round(Math.sqrt(a))) return false;
        return true;
    }
}