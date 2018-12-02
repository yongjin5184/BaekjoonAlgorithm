import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;



/**
 * Created by yong on 2018. 12. 2..
 */
public class Practice5557 {
    static int N;
    static int[] ar;
    static long[][] dp;
    public static void main(String[] args) throws Exception {
        /**
         * description : 백준 5557번 1학년
         * solution : 1. dp[i][j] 는 i번째 인덱스에서 j가 나올 수 있는 방법의 갯수로
         *            2. j 인덱스에 arr의 순차 값을 더하거나 빼면서 갯수를 세어준다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ar = new int[N];
        dp = new long[N][21];
        String[] tmp = br.readLine().split(" ");
        for(int i = 0; i < tmp.length; i++){
            ar[i] = Integer.parseInt(tmp[i]);
        }

        dp[0][ar[0]] = 1;
        for(int i = 1; i < N - 1; i++){
            for(int j = 0; j <= 20; j++){
                if(dp[i - 1][j] != 0){
                    if(j - ar[i] >= 0){
                        dp[i][j - ar[i]] += dp[i - 1][j];
                    }
                    if(j + ar[i] <= 20){
                        dp[i][j + ar[i]] += dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[N - 2][ar[N - 1]]);
    }
}
