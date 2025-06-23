import java.util.*;

class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0});
            
        int row = maps.length;
        int column = maps[0].length;
        
        visited = new boolean[row][column];
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
        
            for(int i=0; i<4; i++){
            
                int nx = x + dx[i];
                int ny = y + dy[i];
            
                if (nx < 0 || ny < 0 || nx >= row || ny >= column)
                    continue;
                
                if (maps[nx][ny] == 0 || visited[nx][ny]) 
                    continue;

                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                maps[nx][ny] = maps[x][y] + 1;
            }
        }
        
        int count = maps[row - 1][column - 1];
        
        if(count == 1){
            return -1;
        }
        
        return count;
        
    }
}