import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by yong on 2018. 9. 28.
 */
public class Practice2467 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 2467번 용액
         * solution : 1. 입력 배열의 양 끝점을 가리키는 index(left, right)를 선언한다.
         *            2. 양 끝부터 더한 값(sum)이 양수이면 right--,
         *            3. 음수이면 left++ (배열이 정렬되어 있으므로) 하여 0에 가까운 값을 구한다.
         *            * String[] arr -> intp[] arr로 convert 하는 lambda 함수
         *            Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] array = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        int right = N - 1;
        int left = 0;
        String result = "";
        int min = 2000000000;
        int sum;
        int mleft;
        int mright;
        while(left < right){
            sum = array[left] + array[right];
            if(min > Math.abs(sum)){
                min = Math.abs(sum);
                mleft = left;
                mright = right;
                result = array[mleft] + " " + array[mright];
            }

            if(sum > 0){
                right--;
            }else if(sum < 0){
                left++;
            }else{
                result = array[left] + " " + array[right];
                break;
            }
        }

        System.out.println(result);
    }
}
