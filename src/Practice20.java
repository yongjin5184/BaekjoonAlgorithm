import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 8. 18..
 */
public class Practice20 {
    public static void main(String[] args) throws IOException{

        /*
        *  문제 : 동전 0 (백준 11047번)
        *  입력 : 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
                 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다.
        *  출력 : 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최소값을 출력한다.
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] A = new Integer[N];
        for(int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());

            if(K >= coin)
                A[i] = coin;
            else
                A[i] = 0;
        }

        /*
        Arrays.sort(A, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        */

        Arrays.sort(A, (num1, num2) -> num2 - num1);

        for(int i = 0; i < N; i++) {
            System.out.println(A[i]);
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(K == 0)
                break;

            while (K >= A[i]) {
                K = K - A[i];
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
