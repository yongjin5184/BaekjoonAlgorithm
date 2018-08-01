import java.util.Scanner;

/**
 * Created by yong on 2018. 8. 1..
 */
public class Practice08 {
    /*
    *  문제 : 전자렌인지(탐욕 알고리즘)
    *  입력 : 첫 번째 줄에는 요리시간 T(초)가 정수로 주어져 있으며 그 범위는 1 ≤ T ≤ 10,000 이다.
    *  출력 : T초를 위한 최소버튼 조작의 A B C 횟수를 첫 줄에 차례대로 출력해야 한다.
    * */
    public static void main(String[] args){
        int a = 300;
        int b = 60;
        int c = 10;

        int numA  = 0, numB = 0, numC = 0;

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int success = 0;
        while(t - a >= 0){
            success = 1;
            t = t - a;
            numA ++;
        }

        while(t - b >= 0){
            success = 1;
            t = t - b;
            numB ++;
        }

        while(t - c >= 0){
            success = 1;
            t = t - c;
            numC ++;
        }

        if(t > 0){
            success = 0;
        }

        if(success == 1){
            System.out.print("" + numA + " " + numB + " " +numC);
        }else{
            System.out.print("-1");
        }
    }
}
