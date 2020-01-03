import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice17614 {
    public static void main(String[] args) throws IOException {
        /**
         * @description: 백준 17614 369 (한국정보올림피아드 KOI 2019 2차대회초등부)
         * @solution : 1. N을 문자열 배열로 변환하여 for 문을 돌면서 3, 6, 9 일 때, 카운트를 센다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(getClapCount(Integer.parseInt(br.readLine())));
    }

    private static int getClapCount(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            char[] chars = String.valueOf(i).toCharArray();
            for (char aChar : chars) {
                if (aChar == '3' || aChar == '6' || aChar == '9') {
                    count++;
                }
            }
        }
        return count;
    }
}
