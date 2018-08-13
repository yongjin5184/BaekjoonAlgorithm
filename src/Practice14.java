import java.util.Scanner;

/**
 * Created by yong on 2018. 8. 13..
 */
public class Practice14 {
    public static void main(String[] args){

        /*
        *  문제 : 10부제 (백준 10797번)
        *  입력 : 첫 줄에는 날짜의 일의 자리 숫자가 주어지고 두 번째 줄에는 5대의 자동차 번호의 일의 자리 숫자가 주어진다.
        *       날짜와 자동차의 일의 자리 숫자는 모두 0에서 9까지의 정수 중 하나이다.
        *  출력 : 주어진 날짜와 자동차의 일의 자리 숫자를 보고 10부제를 위반하는 차량의 대수를 출력한다.
        * */

        Scanner scan = new Scanner(System.in);
        int date = Integer.parseInt(scan.nextLine());
        String[] carNum = scan.nextLine().split(" ");

        int carSum = 0;
        for(int i = 0; i < carNum.length; i++){
            if(date == Integer.parseInt(carNum[i]))
                carSum++;
        }

        System.out.print(carSum);
    }
}
