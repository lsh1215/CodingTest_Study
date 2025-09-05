class Solution {
    public String solution(String s) {
        String[] strArray = s.split(" ", -1); // -1 옵션으로 공백 보존
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strArray.length; i++) {
            String str = strArray[i];
            if (!str.isEmpty()) { 
                char[] charArray = str.toCharArray();

                if (charArray[0] >= 'A' && charArray[0] <= 'z') {
                    sb.append(Character.toUpperCase(charArray[0]));
                } else {
                    sb.append(charArray[0]);
                }

                for (int j = 1; j < charArray.length; j++) {
                    sb.append(Character.toLowerCase(charArray[j]));
                }
            }
            if (i < strArray.length - 1) { 
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
