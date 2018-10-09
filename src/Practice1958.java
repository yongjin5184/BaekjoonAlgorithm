import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 10. 9..
 */
public class Practice1958 {
    public static int[][][] LCS = new int[101][101][101];
    public static void main(String[] args) throws IOException{
        /**
         * @description : 백준 1958번 LCS3(Longest Common Subsequence)
         * @solution : 1. 입력 받은 문자열 3개를 각각 char 배열로 만든 뒤,
         *             2. 기존 문자열 2개의 LCS와 유사하게 진행하되, z 조건을 추가해서 진행한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().trim().toCharArray();
        char[] B = br.readLine().trim().toCharArray();
        char[] C = br.readLine().trim().toCharArray();
        int ALength = A.length;
        int BLength = B.length;
        int CLength = C.length;

        for(int i = 1; i <= ALength; i++){
            for(int j = 1; j <= BLength; j++){
                for(int k = 1; k <= CLength; k++){
                    if(A[i - 1] == B[j - 1] && A[i - 1] == C[k - 1] && B[j - 1] == C[k - 1]){
                        LCS[i][j][k] = LCS[i - 1][j - 1][k - 1] + 1;
                    }else{
                        if(LCS[i - 1][j][k] > LCS[i][j - 1][k] || LCS[i - 1][j][k] > LCS[i][j][k - 1]){
                            LCS[i][j][k] = LCS[i - 1][j][k];
                        }else if(LCS[i][j - 1][k] > LCS[i - 1][j][k] || LCS[i][j - 1][k] > LCS[i][j][k - 1]){
                            LCS[i][j][k] = LCS[i][j - 1][k];
                        }else{
                            LCS[i][j][k] = LCS[i][j][k - 1];
                        }
                    }
                }
            }
        }

        int answer = LCS[ALength][BLength][CLength];
        System.out.println(answer);
    }
}
