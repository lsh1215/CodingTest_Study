class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        
        int sum = 0;
        int Xcopy = x;
        
        while(Xcopy>0){
            sum += Xcopy % 10;
            Xcopy /= 10;
        }
        System.out.println(sum);
        
        if(x % sum == 0){
            answer = true;
        }
        
        return answer;
    }
}