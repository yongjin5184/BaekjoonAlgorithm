package src.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yongjin on 2018-10-10.
 */
public class Practice1463 {
    public static void main(String[] args) throws IOException{
        /**
         * @description :
         * @solution : 1. 해당 입력된 수의 연산을 사용하는 횟수는 이전 값 횟수의 +1 이거나
         *             2. 3으로 나누어 떨어진다면 이전 3 또는 2로 나누어 떨어진 값의 횟수의 +1 이므로
         *             3. 두 가지 경우 중, min을 구해서 return 한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[1000001];

        for(int i = 2; i <= N; i++){
            dp[i] = dp[i - 1] + 1;

            if(i % 3 == 0)
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);

            if(i % 2 == 0)
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);

        }

        System.out.println(dp[N]);
    }
}
