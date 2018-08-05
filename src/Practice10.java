import java.util.Scanner;

/**
 * Created by yong on 2018. 8. 5..
 */
public class Practice10 {
    public static void main(String[] arg) {

        /*
        *  문제 : 동전게임
        *  입력 : 첫 줄에 게임의 라운드 수를 나타내는 정수 K(1 ≤ K ≤ 1,000)가 주어진다.
        *        두 번째 줄에는 입력의 개수를 나타내는 정수 C(1 ≤ C ≤ 100,000)가 주어진다.
        *        다음 이어지는 C개의 줄 각각에는 하나의 입력을 나타내는 두 정수 M과 N(0 ≤ M, N ≤ K)이 주어진다.
        *  출력 : 출력은 C개의 줄로 구성된다.
        *        게임에서 영희와 동수의 점수가 각각 M과 N이 될 수 있다면 1, 아니면 0을 각 줄에 출력한다.
        * */

        Scanner scan = new Scanner(System.in);

        int round = scan.nextInt();
        int inputNum = scan.nextInt();

        StringBuilder sb = new StringBuilder();

        while (inputNum -- > 0) {
            int m = scan.nextInt();
            int n = scan.nextInt();
            int diff = Math.abs(m - n);
            int remain = round - Math.max(m, n);

            if (m == n) {
                sb.append("1\n");
            } else if (m < n) {
                if (diff - remain <= 1) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else {
                if (diff - remain <= 2) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
        }

        System.out.println(sb.toString());

    }
}
