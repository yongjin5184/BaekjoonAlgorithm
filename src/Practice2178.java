import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yong on 2018. 9. 26..
 */
public class Practice2178{

    public static int[][] map;
    public static boolean[][] visit;
    public static int[] rows = {1, 0, -1, 0};
    public static int[] cols = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 2178번 미로찾기
         * solution : bfs - queue를 이용해서 결과값을 찾는다.
         *            1. rows array, cols array를 4방향으로 이동할 수 있도록 설정.
         *            2. queue를 만들고 queue 사이즈 만큼 for문을 돌린다. ( queue size 만큼 돌리는 이유는 막힌 길까지 Queue에 넣기 때문)
         *            3. 4 방향으로 이동하면서, 경계선, 막힌길, 이미 방문한 길을 확인하여 방문여부를 체크하고 queue에 넣는다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        map = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        for(int i = 1; i < N + 1; i++){
            char[] rowChars = br.readLine().toCharArray();
            for(int j = 0; j < rowChars.length; j++){
                map[i][j + 1] = rowChars[j] - '0';
            }
        }

        Queue<Cell> queue = new LinkedList<>();

        queue.offer(new Cell(1, 1));
        int result = 0;
        visit[1][1] = true;
        while(!queue.isEmpty()){

            result++;
            int queueSize = queue.size();

            for(int i = 0; i < queueSize; i++){
                Cell cell = queue.poll();
                if(cell.row == N && cell.col == M){
                    System.out.println(result);
                    return;
                }

                int row = cell.row;
                int col = cell.col;

                for(int j = 0; j < 4; j++){
                    int nextRow = row + rows[j];
                    int nextCol = col + cols[j];

                    if(nextRow < 1 || nextCol < 1 || nextRow > N || nextCol > M) continue; // 경계선
                    if(map[nextRow][nextCol] == 0) continue; // 미로 막힌 길
                    if(visit[nextRow][nextCol]) continue; // 이미 방문한 길

                    visit[nextRow][nextCol] = true;
                    queue.offer(new Cell(nextRow, nextCol));
                }
            }
        }
        /*
        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < M + 1; j++){
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
        */
    }
}

class Cell{
    int row;
    int col;

    Cell(int row, int col){
        this.row = row;
        this.col = col;
    }
}
