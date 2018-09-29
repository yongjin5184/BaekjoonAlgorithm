import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * Created by yong on 2018. 9. 29..
 */
public class Practice2548 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 2548번 대표 자연수
         * solution : 1. 입력 받은 배열을 정렬한다.
         *            2. 첫 번째 for문으로 base 원소를 정한 뒤,
         *            3. 두 번째 for문을 돌리면서 base - 각 원소를 뺀 값의 합이 최소인 걸 return
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().trim().split(" ");
//        Arrays.sort(strs, (num1, num2) -> Integer.parseInt(num1) - Integer.parseInt(num2));
        Arrays.sort(strs);
        int[] arr = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();

        int arrLength = arr.length;
        int min = 200000000;
        int sum = 0;
        int result = 0;
        for(int i = 0; i < arrLength; i++){
            sum = 0;
            int base = arr[i];
            for(int j = 0; j < arrLength; j++){
                sum += Math.abs(base - arr[j]);
            }

            if(min > sum){
                min = sum;
                result = base;
            }
        }

        System.out.println(result);

    }
}
