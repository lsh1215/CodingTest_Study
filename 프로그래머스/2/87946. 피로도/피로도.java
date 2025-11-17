class Solution {
    public static int maxDungeons = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, visited, 0);
        
        return maxDungeons;
    }
    
    public void dfs(int k, int[][] dungeons, boolean[] visited, int count) {      
        maxDungeons = Math.max(maxDungeons, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                
                dfs(k - dungeons[i][1], dungeons, visited, count + 1);
                
                visited[i] = false;
            }
        }
    }
}

// 최소 피로도는 던전 입장 조건
// 소모 피로도는 던전 돌고 소모되는 값

// 최소 피로도가 큰 거부터 돌기
// 문제는 소모 피로도가 클 경우 다음걸 못 돌 수 있다

// 소모 피로도가 작은거부터 돌기
// 문제는 소모피로도가 작아도 해당 소모 피로도로 인해 최소 피로도가 크고 소모 피로도가 작은 던전을 못 돌 수 있다

// 그럼 결국 완탐밖에는 없다