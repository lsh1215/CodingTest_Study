class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int unit = 1; unit <= s.length() / 2; unit++) {
            answer = Math.min(answer, shortener(s, unit));
        }

        return answer;
    }

    private int shortener(String s, int unit) {
        StringBuilder sb = new StringBuilder();

        String prev = s.substring(0, Math.min(unit, s.length()));
        int count = 1;

        for (int i = unit; i < s.length(); i += unit) {
            String current = s.substring(
                i,
                Math.min(i + unit, s.length())
            );

            if (prev.equals(current)) {
                count++;
                continue;
            }

            if (count > 1)
                sb.append(count);

            sb.append(prev);

            prev = current;
            count = 1;
        }

        if (count > 1)
            sb.append(count);

        sb.append(prev);

        return sb.toString().length();
    }
}