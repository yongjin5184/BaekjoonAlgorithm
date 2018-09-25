import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yong on 2018. 9. 25..
 */
public class Practice5585 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 5585번 거스름돈 Greedy
         * solution : 1. 각 거스름 돈을 value로 가지는 for loop
         *            2. while 문안에서 가장 큰 거스름돈 금액부터 빼면서 동전수를 계산.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int balance = 1000 - Integer.parseInt(br.readLine());
        int [] coins = {500, 100, 50, 10, 5, 1};
        int index = 0;
        for(int i = 0; i < coins.length; i++) {
            int base = coins[i];
            while (balance > 0 && balance >= base){
                balance -= base;
                index++;
            }
        }

        System.out.println(index);
    }
}

}