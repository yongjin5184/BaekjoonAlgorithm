import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by yong on 2018. 11. 2..
 */
public class Practice1149 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 1149번 RGB 거리
         * solution : 1. 각 RGB의 Cost를 담은 배열을 선언한다.
         *            2. DP배열을 선언한다. (모두 2차원 배열)
         *            3. dp[i][0]은 이전 값, 즉, dp[i - 1][1]과 dp[i - 1][2]의 최소값에 자신을 더한 값이라고 할 수 있다.
         *            4. 따라서 이 값들(dp[i][0], dp[i][1], dp[i][2])을 N까지 모두 구해주고
         *            5. N번째의 가장 작은 값을 출력해준다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N + 1][3];
        int dp[][] = new int[N + 1][3];
        for(int i = 1; i <= N; i++){
            String[] strs = br.readLine().trim().split(" ");
            arr[i] = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        }

        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        for(int i = 1; i <= N; i++){
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
        }

        int miniumCost = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);
        System.out.println(miniumCost);
        /*
        for(int i = 0; i <= N; i++){
            for(int j = 0; j < 3; j++) {

                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        */
    }
}
