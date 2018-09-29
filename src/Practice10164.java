import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * Created by yong on 2018. 9. 29..
 */
public class Practice10164 {
    public static int[][] map;

    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 10164번 격자상의 경로
         * solution : 1. 반드시 입력 받은 K를 거쳐서 N * M 칸으로 가야한다.
         *            2. 왼쪽과 위에서만 K로 접근할 수 있으므로 점화식은 map[i - 1][j] + map[i][j - 1]이 된다.
         *            3. map에 해당 위치까지 접근할 수 있는 경우의 수를 넣어준다.
         *            4. K가 0인 경우는 Map[N][M]을 return
         *            5. K가 0이 아닌 경우는 K까지 도착하는 경우의 수 * K에서 M x N 까지 가는 경우의 수로 구해준다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(" ");
        int[] arr = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        int N = arr[0];
        int M = arr[1];
        int K = arr[2];
        map = new int[N + 1][M + 1];

        map[0][1] = 1;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                map[i][j] = map[i - 1][j] + map[i][j-1];
            }
        }

        if(K == 0){
            System.out.println(map[N][M]);
        }else {
            int ax = K / M + (K % M == 0 ? 0 : 1);
            int ay = K - (ax - 1) * M;
            int bx = N - ax + 1;
            int by = M - ay + 1;
            System.out.println(map[ax][ay] * map[bx][by]);
        }
    }

}
