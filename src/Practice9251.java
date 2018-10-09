import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 10. 9..
 */
public class Practice9251 {

    public static int[][] LCS = new int[1001][1001];
    public static char[] A = new char[1001];
    public static char[] B = new char[1001];

    public static void main(String[] args) throws IOException{
        /**
         * @description : 백준 9251번 LCS (Longest Common Subsequence)
         * @solution : 1. LCS배열을 만들고 입력 받은 문자열이 같으면 대각선 값의 + 1을 해준다.
         *             2. 입력 받은 문자열이 다른 값일 경우 왼쪽, 위쪽을 검사해서 큰 값을 위치에 넣어준다.
         *             3. 최종 LCS[n][m] 의 값을 Return
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine().trim().toCharArray();
        B = br.readLine().trim().toCharArray();

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i][j - 1], LCS[i - 1][j]);
                }
            }
        }

        int a = A.length;
        int b = B.length;

        System.out.println(LCS[a][b]);
    }
}
