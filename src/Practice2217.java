import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by yong on 2018. 9. 25..
 */
public class Practice2217 {
    public static void main(String args[]) throws NumberFormatException, IOException{
        /**
         * description : 백준 2217번 로프
         * solution : 1. 로프의 수용 가능한 중량을 오름차순 한다.
         *            2. a[0] * n , a[1] * n-1 ... a[i] * n - i를 통해 max 값을 구한다.
         *            3. 점화식 a[i] * n - i
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer a[]= new Integer[n];
        for(int i = 0 ; i < n ; i++){
            a[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(a);

        int max = 0;
        for(int i = 0 ; i < n ; i++){
            if(a[i] * (n - i) > max){
                max = a[i] * ( n - i);
            }
        }
        System.out.println(max);
    }
}
