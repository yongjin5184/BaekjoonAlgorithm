import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 9. 28..
 */
public class Practice1065 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 1065번 한수, * 한수 : 각 자리수들 등차수열을 이루는 수.
         * solution : 1. for문에서 각 숫자의 자리수를 가져온다.
         *            2. 십의 자리 수와 일의 자리수의 격차를 구한다.
         *            3. 각 자리 수의 격차를 구해 비교 한 뒤, 한수이면 갯수를 카운트한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        char[] arr;
        int result = 0;
        loop1: for(int i = 1; i <= num; i++){
            arr = String.valueOf(i).toCharArray();
            int arrLength = arr.length;

            if(arrLength == 1){
                result++;
                continue;
            }

            int diff = arr[1] - arr[0];
            for(int j = 1; j < arrLength - 1; j++){
                if(arr[j + 1] - arr[j] != diff){
                    continue loop1;
                }
            }

            result++;
        }

        System.out.println(result);
    }
}
