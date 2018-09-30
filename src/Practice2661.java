import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 9. 30..
 */
public class Practice2661 {

    public static void main(String[] args) throws IOException {
        /**
         * description : 백준 2661번 좋은 수열, (백트래킹)
         * solution : 1. 현재 수열에 나쁜 수열이 나오지 않는 경우로 1 ~ 3까지 문자열을 붙여가면서 좋은 수열을 만든다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dfs("1", Integer.parseInt(br.readLine()));
    }

    static void dfs(String result, int n){
        if(result.length() == n){
            System.out.println(result);
            System.exit(0);
        }

        for(int i = 1; i <= 3; i++){
            if(isOK(result + i))
                dfs(result + i, n);
        }
    }

    static boolean isOK(String result){
        int k;
        int len = result.length();
        int half = len / 2;
        String a, b;
        for(int i = 1; i <= half; i++){
            k = i * 2;
            for(int j = 0; j + k <= len; j++){
                a = result.substring(j, i + j);
                b = result.substring(i + j,  j + k);
                if(a.equals(b))
                    return false;
            }
        }

        return true;
    }
}


