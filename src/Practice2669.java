package src.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by yongjin on 2018-09-20.
 */
public class Practice2669 {
    public static void main(String[] args) throws IOException{
        /**
         * description  : 백준 2668번 직사각형 네개의 합집합의 면적 구하기
         * solution     : 1. 2차원 map을 하나 만든다.
         *                2. 주워진 점을 map에 맵핑한다.
         *                3. 겹치는 지점은 한 번만 맵핑되도록 조건문 처리,
         *                4. 맵핑된 부분을 모두 더한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[101][101];

        for(int i = 0; i < 4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            for(int x = startY; x < endY; x++){
                for(int y = startX; y < endX; y++){
                    if(map[x][y] == 0) {
                        map[x][y] = 1;
                    }
                }
            }


        }


        int sum = 0;
        for(int x = 0; x < 101; x++){
            for(int y = 0; y < 101; y++){
                sum += map[x][y];
            }
        }

        System.out.print(sum);
    }
}
