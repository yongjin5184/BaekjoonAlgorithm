import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by yongjin on 2018-10-01.
 */
public class Practice1026 {
    public static void main(String[] args) throws IOException{
        /**
         * @description : 백준 1026번 보물
         * @solution : 1. 첫 번째 배열은 asc 정렬
         *             2. 두 번째 배열은 desc 정렬
         *             3. 두 정렬된 배열을 돌면서 원소들을 곱해서 sum한 값을 출력한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String line;
        int index = 0;
        int[] arr1 = new int[N];
        String[] arr2 = new String[N];
        while((line = br.readLine()) != null && !line.equals("")){
            String[] strs = line.split(" ");

            if(index == 0) {
                arr1 = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
                Arrays.sort(arr1);
            }else{
                arr2 = Arrays.copyOf(strs, N);
                Arrays.sort(arr2, (num1, num2) -> Integer.parseInt(num2) - Integer.parseInt(num1));
            }

            index++;
        }

        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += arr1[i] * Integer.parseInt(arr2[i]);
        }

        System.out.println(sum);
    }
}
