import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice1476 {
    public static void main(String args[]) throws IOException {
        /**
         * description : 백준 1476번 날짜계산
         * solution : 1. while 루프를 돌리면서 문제의 조건대로 e,s,m 이 같을 때 year 를 반환해준다.
         *            2. 그렇지 않을 경우는 1 씩 증가하고 해당 날짜에 도달하면 1로 초기화 해준다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int e=1;
        int s=1;
        int m=1;
        String[] strs = br.readLine().split(" ");
        int E = Integer.parseInt(strs[0]);
        int S = Integer.parseInt(strs[1]);
        int M = Integer.parseInt(strs[2]);
        int year = 1;
        while(true) {
            if(e == E && s == S && m == M) {
                System.out.println(year);
                break;
            }
            year++;
            e += 1;
            s += 1;
            m += 1;
            if(e == 16) e = 1;
            if(s == 29) s = 1;
            if(m == 20) m = 1;

        }
    }
}
