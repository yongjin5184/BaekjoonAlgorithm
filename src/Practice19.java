import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * Created by yong on 2018. 8. 15..
 */


public class Practice19 {


    public static void main(String[] args) throws IOException{

        /*
        *  문제 : ATM (백준 11399번)
        *  입력 : 첫째 줄에 사람의 수 N(1 ≤ N ≤ 1,000)이 주어진다.
        *        둘째 줄에는 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어진다. (1 ≤ Pi ≤ 1,000)
        *  출력 : 첫째 줄에 각 사람이 돈을 인출하는데 필요한 시간의 합의 최소값을 출력한다.
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr;

        arr = br.readLine().split(" ");

        /*
        for(int i = 0; i < N; i++){
            System.out.println("");
            for(int j = 0; j <= i; j++){
                System.out.print("arr[" + j + "] = " + arr[j]);
            }
        }
        */
        Arrays.sort(arr, (num1, num2) -> Integer.parseInt(num1) - Integer.parseInt(num2));
//        Arrays.sort(arr);

        int sum = 0;
        for(int i = 0; i < N; i++){
//            System.out.println("");
            for(int j = 0; j <= i; j++){
//                System.out.print("arr[" + j + "] = " + arr[j]);
                sum += Integer.parseInt(arr[j]);
            }
        }


        System.out.print(sum);
    }
}

