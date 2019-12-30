import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice17608 {
    public static void main(String[] args) throws IOException {
        /**
         * @description: 백준 17608번 막대기 (한국정보올림피아드 KOI 2019 1차대회 초등부)
         * @solution : 1. 보이는 막대기의 갯수를 출력, 결국은 보이는 방향에서 부터 큰 막대기의 갯수를 출력
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int maxHeight = 0;
        int visibleCount = 0;
        for(int i = N - 1; i >= 0; i--) {
            if(maxHeight < arr[i]){
                maxHeight = arr[i];
                visibleCount++;
            }
        }

        System.out.println(visibleCount);
    }
}
