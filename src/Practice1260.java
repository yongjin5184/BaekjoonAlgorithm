import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 9. 26..
 */
public class Practice1260 {

    public static int[][] map; // 노드들의 연결 관계를 나타내는 배열
    public static boolean[] visit; // 방문 여부 나타내는 배열
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 1260번, DFS와 BFS
         * solution : DFS는 recursive를 통해, BFS는 Queue를 통해 구현한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int V = Integer.parseInt(line[2]);
        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }

        dfs(N, V);

        System.out.println();
        visit = new boolean[N + 1];

        bfs(N, V);
    }

    public static void dfs(int N, int V){
        if(visit[V]){
            return;
        }

        System.out.print(V + " ");

        for(int i = 1; i < N + 1; i++){
            if(map[V][i] == 1){
                visit[V] = true;
                dfs(N, i);
            }
        }
    }

    public static void bfs(int N, int V){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(V);
        visit[V] = true;
        while(!queue.isEmpty()){
            int n = queue.poll();
            System.out.print(n + " ");
            for(int i = 1; i < N + 1; i++){
                if(map[n][i] == 1 && !visit[i]){
                    visit[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
