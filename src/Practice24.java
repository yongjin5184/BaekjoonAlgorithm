import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 8. 21..
 */
public class Practice24 {

    /*
    *  문제 : 숫자 n이 주어진다. 숫자 n을 이진법으로 변환 시켰을 때, 1의 갯수를 구하시오.
    *  입력 : 첫째 줄에 임의의 N이 주어진다
    *  출력 : 1의 갯수를 출력하시오.
    * */
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int result = recursive(input, 0);
        System.out.println(result);
    }

    public static int recursive(int input, int result){
        int tmp = input / 2;
        int tmp2 = input % 2;

        if(tmp2 == 1){
            result++;
        }

        if(tmp <= 0){
            return result;
        }

        return recursive(tmp, result);
    }
}
