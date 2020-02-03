import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice11057 {
    public static long MOD = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] d = new long[n+1][10];
        for (int i=0; i<=9; i++) {
            d[1][i] = 1;
        }
        for (int i=2; i<=n; i++) {
            for (int j=0; j<=9; j++) {
                for (int k=0; k<=j; k++) {
                    d[i][j] += d[i-1][k];
                    d[i][j] %= MOD;
                }
            }
        }
        long ans = 0;
        for (int i=0; i<10; i++) {
            ans += d[n][i];
        }
        ans %= MOD;
        System.out.println(ans);
    }
}