import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 9. 28..
 */
public class Practice2468 {
    /**
     * description : 백준 2458번 안전영역
     * solution : 1. 강수량에 따라 침수되는 MAP을 만들고
     *            2. dfs를 이용하여 푼다. dfs 함수를 호출 할때마다 안전지역 갯수 변수를 ++해주고
     *            3. dfs를 통해 연결 된 지역들은 0으로 치환해준다.
     */
    static public int[][] map;
    static public int[][] rainMap;
    static public int max = 0;
    static public int maxValue = 1;
    static public int[] dx = {1, -1, 0, 0};
    static public int[] dy = {0, 0, -1, 1};
    static public int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        rainMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().trim().split(" ");
            for (int j = 0; j < line.length; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                if(max < map[i][j]) max = map[i][j];
            }
        }

        for(int k = 1; k <= max; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (k >= map[i][j]) rainMap[i][j] = 0;
                    else rainMap[i][j] = 1;
                }
            }

            int tmp = safetyArea();
            maxValue = (maxValue < tmp) ?  tmp : maxValue;
        }

        System.out.println(maxValue);

        /*
        for(int i = 0; i < N; i++){
            System.out.println("");
            for(int j = 0; j < N; j++) {
                System.out.print(rainMap[i][j]);
            }
        }
        */
    }


    public static void dfs(int x , int y) {

        if(x < 0 || y < 0 || x >= N || y >= N) return;

        if(rainMap[x][y] == 1) rainMap[x][y] = 0;
        else return;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            dfs(nx, ny);
        }
    }

    public static int safetyArea() {
        int safetyArea = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(rainMap[i][j] == 1) {
                    dfs(i, j);
                    safetyArea++;
                }
            }
        }
        return safetyArea;
    }
}
