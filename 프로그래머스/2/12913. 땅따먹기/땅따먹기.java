class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int n = land.length;
        
        int[][] dp = new int[n][land[0].length];
        
        for(int i=0; i<4; i++){
            dp[0][i] = land[0][i];
        }
        
        for(int i=1; i<n; i++){
            for(int j=0; j<4; j++){
                dp[i][j] = Math.max(dp[i-1][(j+1)%4], 
                                    Math.max(dp[i-1][(j+2)%4],dp[i-1][(j+3)%4])) 
                    + land[i][j];
            }
            
                
        } 
        
        
        answer = Math.max(dp[n-1][0], Math.max(dp[n-1][1], Math.max(dp[n-1][2], dp[n-1][3])));
        
        
        return answer;
    }
}