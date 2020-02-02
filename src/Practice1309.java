import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice1309 {
    public static final int MOD_NUMBER = 9901;
    public static void main(String[] args) throws IOException {
        /**
         * description : 백준 1309번, 동물원
         * solution : dp[1][0] -> 1번째 줄의 왼쪽 오른쪽 사지가 없는 경우
         *            dp[1][1] -> 1번째 줄의 왼쪽에 사자가 있는 경우, 오른쪽엔 사자가 없다.
         *            dp[1][2] -> 1번째 줄의 왼쪽에 사자가 없고, 오른쪽에 사자가 있는 경우
         *
         *            dp[i][0] -> 이전 상태의 (사자가 없는 경우 + 사자가 왼쪽에 있는 경우 + 사자가 오른쪽에 있는 경우)
         *            dp[i][1] -> 이전 상태의 (사자가 없는 경우 + 사자가 왼쪽에 있는 경우)
         *            dp[i][2] -> 이전 상태의 (사자가 없는 경우 + 사자가 오른쪽에 있는 경우)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD_NUMBER;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD_NUMBER;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD_NUMBER;
        }

        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % MOD_NUMBER);
    }
}
