import java.util.Scanner;

/**
 * Created by yong on 2018. 7. 28..
 */
public class Practice07 {
    /*
    *  문제 : 타일 장식물
    *  입력 : 입력은 한 줄로 구성되며 이 줄에는 타일의 개수를 나타내는 정수 N(1 ≤ N ≤ 80)이 주어진다.
    *  출력 : 표준 출력으로 N 개의 타일이 구성하는 타일 장식물 직사각형의 둘레를 출력한다.
    * */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[] dp;
        if(n <= 1) {
            System.out.println(4);
            return;
        }else{
            dp = new long[n + 1];
        }

        dp[1] = dp[2] = 1;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        long answer = 4 * dp[n] + 2 * dp[n-1] ;

        System.out.println(answer);
    }
}
