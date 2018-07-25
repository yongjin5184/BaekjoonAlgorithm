import java.util.Scanner;

/**
 * Created by yong on 2018. 7. 24..
 */
public class Practice03 {
    public static void main(String[] args){
        /*
        *
        * 표준 입력으로 방의 정원을 나타내는 서로 다른 세 자연수 A, B, C (1 ≤ A < B < C ≤ 50)와
        * 전체 학생 수를 나타내는 자연수 N (1 ≤ N ≤ 300)이 공백으로 분리되어 한 줄에 주어진다.
        *
        * */
        Scanner scan = new Scanner(System.in);
        int a, b, c, student;
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();
        student = scan.nextInt();
        if( (a < 1 || b < 1 || c < 1) && (a > 50 || b > 50 || c > 50 ) ){
            System.out.println("a, b, c는 1과 50 사이 자연수여야 합니다.");
            return;
        }

        int sum = 0;
        int sum1;
        int sum2;
        int sum3;

        for(int i = 0; i <= student; i++){
            sum1 = i * a;
            for(int j = 0; j <= student; j++){
                sum2 = j * b;
                for(int k = 0; k <= student; k++){
                    sum3 = k * c;

                    if(sum1 + sum2 + sum3 > student){
                        break;
                    }

                    if(sum1 + sum2 + sum3 == student){
                        sum = 1;
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }

}
