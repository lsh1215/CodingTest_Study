class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int wMax = Math.max(wallet[0], wallet[1]);
        int wMin = Math.min(wallet[0], wallet[1]);
        int bMax = Math.max(bill[0], bill[1]);
        int bMin = Math.min(bill[0], bill[1]);
        
        while(wMax < bMax || wMin < bMin){
            
            answer++;
            bMax /= 2;
            if(bMax < bMin){
                bMax ^= bMin;
                bMin ^= bMax;
                bMax ^= bMin;
            }
        }
        return answer;
    }
}