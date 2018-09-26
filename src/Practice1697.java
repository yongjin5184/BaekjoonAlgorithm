import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 9. 26..
 */

public class Practice1697 {

    public static int[] map = new int[100001];
    public static boolean[] visit = new boolean[100001];
    public static int[] move = {1, -1, 2};
    public static void main(String args[]) throws IOException {
        /**
         * description : 백준 1697 숨바꼭질
         * solution : queue를 사용한 bfs로 구한다.
         *            1. map를 통해 움직인 위치를 저장한다.
         *            2. visit를 통해 이미 움직였던 위치를 표시한다.
         *            3. 움직일 때 마다 움직인 위치 value 값은 이전 값의 + 1
         *            4. 최종으로 end 위치에 도달했을 때, Map의 value 값을 return 한다.
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if(start == end){
            System.out.println(0);
            return;
        }

        bfs(start, end);
    }

    public static void bfs(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visit[start] = true;

        while(!queue.isEmpty()) {
            int tmp;
            int base = queue.poll();

            for (int i = 0; i < 3; i++) {

                if (i <= 1) tmp = base + move[i];
                else tmp = base * move[i];

                if (tmp < 0 || tmp > 100000) continue;
                if (visit[tmp]) continue;

                map[tmp] = map[base] + 1;

                if (tmp == end) {
                    System.out.println(map[tmp]);
                    return;
                }

                visit[tmp] = true;
                queue.offer(tmp);
            }
        }
    }
}

