// 2 + 4 = 6 

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int tmp = section[0];
        for(int i=1; i<section.length; i++){
            if(section[i] > tmp + m - 1){
                answer++;
                tmp = section[i];
            }
        }
        
        return answer;
    }
}