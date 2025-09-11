class Solution {
    public int solution(int[] a, int[] b) {
        int length = a.length;
        
        int sum = 0;
        
        for(int i=0; i<length; i++){
            sum += a[i] * b[i];
        }
        return sum;
    }
}