class Solution {
    public static int zeroCount;
    public static int loopCount;
    
    public int[] solution(String s) {
        zeroCount = 0;
        loopCount = 0;
        
        loop(s);
        
        return new int[]{loopCount, zeroCount};
    }
    
    public int oneLength(String s){
        int length = 0;
        
        for (char c : s.toCharArray()){
            if(c == '1'){
                length++;
            } else {
                zeroCount++;
            }
        }
        return length;
    }
    
    public String makeBinary(int count){
        if (count == 0) {
            return "0";
        }
        return Integer.toBinaryString(count);
    }
    
    public String loop(String s){
        if (s.equals("1")) {
            return s;
        }
        
        loopCount++;
        
        int oneCount = oneLength(s);
        String newString = makeBinary(oneCount);
        
        return loop(newString);
    }
}