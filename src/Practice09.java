import java.util.Scanner;

/**
 * Created by yong on 2018. 8. 2..
 */
public class Practice09 {
    public static void main(String[] arg){

        /*
        *  문제 : 색종이(이차원 배열을 이용한 좌표 문제)
        *  입력 : 입력의 첫 번째 줄에는 색종이의 장수를 나타내는 정수 N (1 ≤ N ≤ 100)이 주어진다.
        *       이어서 N장의 색종이에 관한 입력이 각 색종이마다 한 줄씩 차례로 주어진다.
        *       색종이가 놓이는 평면은 가로 최대 101칸, 세로 최대 101칸으로 구성된 격자 모양이다.
        *       격자의 각 칸은 가로, 세로 길이가 1인 면적이 1인 정사각형이다.
        *  출력 : 입력에서 주어진 순서에 따라 N장의 색종이를 평면에 놓았을 때,
        *       입력에서 주어진 순서대로 각 색종이가 보이는 부분의 면적을 한 줄에 하나씩 하나의 정수로 출력한다.
        *       만약 색종이가 보이지 않는다면 정수 0을 출력한다.
        * */


        int[][] map = new int[101][101];
        int[]square = new int[101];
        int n;

        Scanner scan1 = new Scanner(System.in);
        n = Integer.parseInt(scan1.nextLine());
        String input = "";

        for (int i = 1; i <= n; i++) {
            input = scan1.nextLine();
            String[] inputArr = input.split(" ");
            int sx = Integer.parseInt(inputArr[0]);
            int sy = Integer.parseInt(inputArr[1]);
            int dx = Integer.parseInt(inputArr[2]);
            int dy = Integer.parseInt(inputArr[3]);
            dx += sx;
            dy += sy;
            for(int x = sx; x < dx; x++){
                for(int y = sy; y < dy; y++){
                    map[x][y] = i;
                }
            }

        }

        for (int i=0; i < 101; i++) {
            for (int j=0; j < 101; j++) {
                if (map[i][j] != 0) {
                    square[map[i][j]]++;
                }
            }
        }
        /*
        for(int i = 0; i < map.length; i++){
            System.out.println("");
            for(int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j]);
            }
        }

        System.out.println("");
        */
        for(int i = 1; i <= n; i++){
            System.out.println(square[i]);
        }

    }
}
