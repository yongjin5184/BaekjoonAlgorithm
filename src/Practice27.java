import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 8. 21..
 */

public class Practice27 {

    public static void main(String[] args) throws IOException{

        /*
        *  문제 : 미로탐색 BFS (백준 2178번)
        *  입력 : 첫째 줄에 두 정수 N, M(2≤N, M≤100)이 주어진다.
        *        다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
        *  출력 : 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] rows = {0, -1, 0, 1};
        int[] cols = {-1, 0, 1, 0};
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        for(int i = 1; i < N + 1; i++) {
            String line = br.readLine();
            for(int j = 1; j < M + 1; j++){
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }

        LinkedList<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N + 1][M + 1];
        visited[1][1] = true;
        int res = 0, xRow = 0 , yCol = 0, qSize;

        queue.offer(new Point(1,1));

        while(!queue.isEmpty()){
            res++;
            qSize = queue.size();

            for(int i = 0; i < qSize; i++){

                Point point = queue.poll();

                if( point.row == N && point.col == M) {
                    System.out.println(res);
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    xRow = point.row + rows[j];
                    yCol = point.col + cols[j];

                    if (xRow < 1 || xRow > N || yCol < 1 || yCol > M) continue;
                    if (map[xRow][yCol] == 0) continue;
                    if (visited[xRow][yCol]) continue;

                    visited[xRow][yCol] = true;
                    queue.offer(new Point(xRow, yCol));
                }
            }
        }

        System.out.println(res);
    }

}

class Point{

    int row;
    int col;

    Point(int row, int col){
        this.row = row;
        this.col = col;
    }
}