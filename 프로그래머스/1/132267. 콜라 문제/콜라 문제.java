class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int ex = 0; 
        
        while(n >= a){
            answer += (n / a)*b;
            ex = n % a;
            n = (n / a)*b;
            n += ex;
        }
        
        return answer;
    }
}