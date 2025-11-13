import java.util.*;

class Solution {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int xMax = board[0].length;
        int yMax = board.length;
        
        String color = board[h][w];
        
        for(int i=0; i<4; i++){
            int x = h + dx[i];
            int y = w + dy[i];
            
            if(x<0 || y<0 || x >= xMax || y >= yMax){
                continue;
            }
            
            if(board[x][y].equals(color)){
                answer++;
            }
        }
        return answer;
    }
}