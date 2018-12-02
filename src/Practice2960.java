import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by yong on 2018. 12. 2..
 */
public class Practice2960 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 2960번 에라토스테네스의 체
         * solution : 1. tempArr 배열을 두어서 해당 index가 true 일 때, num++을 한다.
         *            2. 두 번째 for문은 2부터 3, 5를 선택하여야 하므로 j는 j += i 만큼씩 증가한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(" ");
        int N = Integer.parseInt(strs[0]);
        int K = Integer.parseInt(strs[1]);

        boolean[] tempArr = new boolean[N + 1];
        Arrays.fill(tempArr, Boolean.TRUE);
        int num = 0;
        for(int i = 2; i <= N; i++) {
            for(int j = i; j <= N; j += i) {
                if(!tempArr[j]) continue;
                tempArr[j] = false;
                num++;
                if(num == K) System.out.println(j);
            }
        }
    }
}
