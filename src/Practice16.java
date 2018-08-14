import java.util.Scanner;
import java.util.Stack;

/**
 * Created by yong on 2018. 8. 14..
 */
public class Practice16 {
    public static void main(String[] args){

        /*
        *  문제 : 쇠막대기 (백준 10799번)
        *  입력 : 한 줄에 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다. 괄호 문자의 개수는 최대 100,000이다.
        *  출력 : 잘려진 조각의 총 개수를 나타내는 정수를 한 줄에 출력한다.
        * */


        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        char[] charLine = line.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        int sum = 0;
        for(int i = 0; i < charLine.length; i++){
            if(charLine[i] == '('){
                stack.push(charLine[i]);
            }else{
                if(charLine[i - 1] == '('){
                    stack.pop();
                    sum += stack.size();
                }else{
                    stack.pop();
                    sum += 1;
                }
            }
        }

        System.out.print(sum);
    }
}
