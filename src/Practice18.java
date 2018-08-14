import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by yong on 2018. 8. 15..
 */
public class Practice18 {
    public static void main(String[] args) throws IOException {

        /*
        *  문제 : 행복 (백준 15969번)
        *  입력 : 표준 입력으로 다음 정보가 주어진다. 첫 번째 줄에는 학생 수 N이 주어진다.
        *       다음 줄에는 N명의 학생 점수가 공백 하나를 사이에 두고 주어진다.
        *  출력 : 표준 출력으로 가장 높은 점수와 가장 낮은 점수의 차이를 출력한다.
        * */


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxNum = 0;
        int minNum = 0;
        int num = 0;
        for(int i = 0; i < N; i++){
            num = Integer.parseInt(st.nextToken());

            if(num >= maxNum){
                maxNum = num;
            }

            if(num <= minNum || i == 0){
                minNum = num;
            }
        }

        System.out.println(maxNum - minNum);
    }
}
