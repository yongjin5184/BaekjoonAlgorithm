import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 10. 10..
 */
public class Practice9095 {
    public static void main(String[] args) throws IOException{
        /**
         * @description : 백준 9095번 1, 2, 3 더하기
         * @solution : 1. 점화식 f(N) = f(N-3) +f(N-2)+f(N-1)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] answer = new int [11];

        answer[1] = 1;
        answer[2] = 2;
        answer[3] = 4;
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            for(int j = 4; j < 11; j++){
                answer[j] = answer[j - 3] + answer[j - 2] + answer[j - 1];
            }
            System.out.println(answer[n]);
        }
    }
}
