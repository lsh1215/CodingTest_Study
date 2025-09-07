class Solution {
    boolean solution(String s) {
        String upStr = s.toUpperCase();
        char[] cArr = upStr.toCharArray();
        
        int countP = 0, countY = 0;
        
        for(char c : cArr){
            if(c == 'P'){
                countP += 1;
            }
            else if (c == 'Y'){
                countY += 1;
            }
        }
        
        if(countP == countY){
            return true;
        }

        return false;
    }
}