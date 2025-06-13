import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준 1337
// https://www.acmicpc.net/problem/1337
// 올바른 배열
// 연속되는 숫자가 5개 이상이다? 이러면 올바른 배열이다.
// 배열 반복문 돌면서 연속되는 숫자 5개 이상인지 확인

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        arr = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int maxCount = 1;

        for (int i = 0; i < T; i++) {
            int count = 1;
            for (int j = i + 1; j < T; j++) {
                if (arr[j] - arr[i] <= 4) {
                    count++;
                } else {
                    break;
                }
            }
            if (count >= 5) {
                System.out.println(0);
                return;
            }
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(5 - maxCount);
    }
}