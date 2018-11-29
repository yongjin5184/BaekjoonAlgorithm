import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by yong on 2018. 11. 29..
 */
public class Test1920 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 1920 수찾기
         * solution : 1. 이진탐색을 구현하는 문제.
         *            2. 찾을 숫자, 대상 배열, 시작 값, 마지막 값을 Parameter 로 받는 Method를 선언
         *            3. 탈출 조건 : 시작 값과 마지막 값이 역전 되는 순간 값을 못 찾고 return
         *            4. 탈출로의 수렴 조건 : 중간값을 구하고 중간 값이 찾는 값이면 return
         *            5.                 중간값보다 큰경우이면 시작값 + 1로 재귀
         *            6.                 중간값보다 작은경우이면 마지막 값 - 1로 재귀
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strs1 = br.readLine().trim().split(" ");
        int[] A = Arrays.stream(strs1).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(br.readLine());
        String[] strs2 = br.readLine().trim().split(" ");
        int[] B = Arrays.stream(strs2).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(A);
        for (int find: B) {
            System.out.println(binarySearch(find, A, 0, N - 1));
        }
    }

    public static int binarySearch(int find, int[] arr, int start, int end){
        if(start > end) return 0;

        int half = (start + end) / 2;
        if(arr[half] == find){
            return 1;
        }else if(arr[half] < find){
            return binarySearch(find, arr, half + 1, end);
        }else{
            return binarySearch(find, arr, start, half - 1);
        }
    }
}
