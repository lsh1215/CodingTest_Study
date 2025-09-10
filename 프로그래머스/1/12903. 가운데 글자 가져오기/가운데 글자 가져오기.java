class Solution {
    public String solution(String s) {
        char[] cArr = s.toCharArray();
        int length = cArr.length;
        StringBuilder sb = new StringBuilder();
        
        if(length % 2 == 0) {
            sb.append(cArr[length/2-1]);
            sb.append(cArr[length/2]);
            return sb.toString();
        }
        return String.valueOf(cArr[length/2]);
    }
}