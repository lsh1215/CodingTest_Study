// 짝 짝 짝 -> X
// 홀 짝 짝 -> 0
// 홀 홀 짝 -> X
// 홀 홀 홀 -> 0

// 1 bruteforce

class Solution {
    public int solution(int[] nums) {
        int count = 0;
        
        int n = nums.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    if(isPrime(nums[i]+nums[j]+nums[k])) count++; 
                }
            }
        }
        

        return count;
    }
    
    public boolean isPrime(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}