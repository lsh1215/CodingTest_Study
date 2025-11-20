// 2진법 변환
// 10 % 2 = 0
// 10 / 2 = 5
// 5 % 2 = 1
// 5 / 2 = 2
// 2 % 2 = 0
// 2 / 2 = 1
// 1010
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        while(n>0){
            stack.add(n % k);
            n /= k;
        }
        
        int size = stack.size();
        
        long num = 0; 
        
        for(int i=0; i<size; i++){
            int a = stack.pop();
            
            if(a != 0){
                num *= 10; 
                num += a;
            }
            else{ 
                if(isPrime(num)){
                    answer++;
                }
                num = 0; 
            }
        }
        
        if(num > 0 && isPrime(num)) answer++; 
        
        return answer;
    }
    
    public boolean isPrime(long x){
        if(x <= 1) return false;
        
        for(long i=2; i*i<=x; i++){
            if(x % i == 0) return false;
        }
        
        return true;
    }
}