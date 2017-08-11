import java.util.Scanner;

/**
 * Created by yongjin on 2017-08-11.
 */
public class Practice01 {
    /*
    1000번

    문제
        두 수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

    입력
        첫째 줄에 A와 B가 주어진다. (0 < A,B < 10)

    출력
        첫째 줄에 A+B를 출력한다.

    Input
        1
        2
    Output
        3

    */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b;
        a = scan.nextInt();
        b = scan.nextInt();
        System.out.print(a + b);
    }
}
