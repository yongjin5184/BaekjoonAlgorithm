import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 11. 30..
 */
public class Practice10974 {
    static int[] output;

    public static void main(String args[]) throws Exception {
        /**
         * description : 백준 10974번 모든 순열
         * solution : 1. 첫째 자리의 수를 반복문에서 넣는다.
         *            2. 한 번 나온 수는 다시 나올 수 없도록 visited 배열을 사용해서 막는다.
         *            3. 해당 depth에 도달하면 재귀문을 빠져나온다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        output = new int[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            DFS(arr, visited, N, i, 0);
            visited[i] = false;
        }
    }

    public static void DFS(int[] arr, boolean[] visited, int N, int start, int depth) {
        output[depth] = start + 1;
        if (depth == N - 1) {
            for (int i = 0; i < N; i++)
                System.out.print(output[i] + " ");
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            DFS(arr, visited, N, i, depth + 1);
            visited[i] = false;
        }
    }
}
