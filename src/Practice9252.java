import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 10. 9..
 */
public class Practice9252 {

    public static int[][] LCS = new int[1001][1001];
    public static String[][] solution = new String[1001][1001];
    public static void main(String[] args) throws IOException{
        /**
         * @description: 백준 9252번 LCS2 (Longest Common Subsequence)
         * @solution : 1. LCS배열을 만들고 입력 받은 문자열이 같으면 대각선 값의 + 1을 해준다.
         *             2. 그 때, solution 배열을 만들어, 문자열 "diagonal"을 넣어준다.
         *             3. 입력 받은 문자열이 다른 값일 경우 왼쪽, 위쪽을 검사해서 큰 값을 위치에 넣어준다.
         *             4. 그 때, solution에 위쪽이 큰 경우 "top", 아래쪽이 큰 경우 "left"을 넣는다.
         *             5. LCS[a][b]이 0이 아닐 때까지, diagonal이면 문자열을 만들어주고
         *             6. left이면 왼쪽 이동, top이면 위쪽으로 이동하면서 공통 문자열을 찾아준다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line1 = br.readLine().trim().toCharArray();
        char[] line2 = br.readLine().trim().toCharArray();

        int a = line1.length;
        int b = line2.length;
        for(int i = 1; i <= a; i++){
            for(int j = 1; j <= b; j++){
                if(line1[i - 1] == line2[j - 1]){
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                    solution[i][j] = "diagonal";
                }else{
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);

                    if(LCS[i - 1][j] > LCS[i][j - 1]){
                        solution[i][j] = "left";
                    }else{
                        solution[i][j] = "top";
                    }
                }
            }
        }

        System.out.println(LCS[a][b]);

        StringBuffer sb = new StringBuffer("");
        while(LCS[a][b] != 0){
            if(solution[a][b].equals("diagonal")){
                sb.append(line1[a - 1]);
                a--;
                b--;
            }else if(solution[a][b].equals("left")){
                a--;
            }else{
                b--;
            }
        }

        String answer = sb.reverse().toString();
        System.out.println(answer);
    }
}
