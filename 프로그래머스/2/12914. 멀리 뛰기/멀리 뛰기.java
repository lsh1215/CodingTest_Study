class Solution {
    public long solution(int n) {
        if (n == 1) {
            return 1;
        }
        
        long a = 1; 
        long b = 2; 

        for (int i = 3; i <= n; i++) {
            long temp = (a + b) % 1234567;
            
            a = b;      
            b = temp;  
        }

        return b;
    }
}