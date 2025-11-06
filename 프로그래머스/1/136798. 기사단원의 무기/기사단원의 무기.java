class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<=number; i++){
            answer += calcPower(i, limit, power);
        }
        
        return answer;
    }
    
    public int calcPower(int number, int limit, int power){
        int count = 0;
        for(int i=1; i*i<=number; i++){
            if(number % i == 0){
                if(i*i == number) count++;
                else count+=2;
            }
        }
        
        if(count > limit) count = power;
        
        return count;
    }
}