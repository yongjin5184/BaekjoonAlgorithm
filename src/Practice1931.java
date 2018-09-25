
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 8. 14..
 */

public class Practice1931 {
    public static void main(String[] args) throws IOException {

        /*
        *  문제 : 회의실배정 (백준 1931번) - Greedy
        *  입력 : 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
        *       시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
        *  출력 : 첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
        * */


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int confNum = Integer.parseInt(br.readLine());
        int[][] conference = new int[confNum][2];

        for (int i = 0; i < confNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            conference[i][0] = Integer.parseInt(st.nextToken()); //시작시간
            conference[i][1] = Integer.parseInt(st.nextToken()); //끝나는시간
        }

        Arrays.sort(conference,(conference1 , conference2) ->
                conference1[1] == conference2[1] ? conference1[0] - conference2[0] : conference1[1] - conference2[1]); //끝나는 시간 순으로 정렬

        /*
        for (int i = 0; i < confNum; i++) {
            System.out.println(conference[i][0] + " " + conference[i][1]);
        }
        */

        int earliest = -1;
        int result = 0;
        for (int i = 0; i < confNum; i++) {
            if(conference[i][0] >= earliest){
                result ++;
                earliest = conference[i][1];
            }
        }

        System.out.println(result);

        /*
        for (int i = 0; i < confNum; i++) {
            System.out.println(conference[i][0] + " " + conference[i][1]);
        }
        */
    }
}