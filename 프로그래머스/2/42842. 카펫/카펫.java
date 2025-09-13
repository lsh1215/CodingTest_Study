class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        for(int i=yellow; i>0; i--){
            if(yellow % i == 0){
                if(brown == (i + 2) * 2 + (yellow / i) * 2){
                    answer = new int[]{(yellow / i)+2, i+2};
                }
            }
        }
        return answer;
        
    }
}

/*

1 * 24 ==> (1 + 2) * 2 + (24 * 2)
2 * 12 ==> (2 + 2) * 2 + 12 * 2 = 32
3 * 8 ==> (3 + 2) * 2 + 8 * 2 = 26 
4 * 6 ==> (4 + 2) * 2 + (6 * 2) = 12 + 12
*/