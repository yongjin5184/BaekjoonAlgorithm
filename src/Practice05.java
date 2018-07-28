import java.util.Scanner;

/**
 * Created by yong on 2018. 7. 28..
 */
public class Practice05 {
        /*
        *
        *    첫 번째 줄에는 학교의 수를 나타내는 정수 N (1 ≤ N ≤ 100)이 주어진다.
        *    다음 N 개의 줄에 각 학교의 학생 수와 배정된 사과 개수를 나타내는 두 개의 정수가 주어진다.
        *    학생 수와 사과 개수는 모두 1이상 100이하이다.
        *
        */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        String num = scan.nextLine();
        int intNum = Integer.parseInt(num);

        String[] apple = new String[intNum];
        String[] student = new String[intNum];

        for (int i = 0; i < intNum; i++) {
            String input = scan.nextLine().trim();
            String[] appleStudent = input.split(" ");
            for(int j = 0; j < appleStudent.length; j++){
                if(j % 2 == 0){
                    student[i] = appleStudent[j];
                }else{
                    apple[i] = appleStudent[j];
                }
            }
        }

        int resultSum = 0;
        for(int i = 0; i < intNum; i++){
            resultSum += (Integer.parseInt(apple[i]) % Integer.parseInt(student[i]));
        }

        System.out.print(resultSum);
    }

}