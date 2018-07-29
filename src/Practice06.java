import java.util.Scanner;

/**
 * Created by yong on 2018. 7. 28..
 */
public class Practice06 {
    /*
    *
    * */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        String num = scan.nextLine();
        int intNum = Integer.parseInt(num);
        int direction = 0;
        Double result = 1.0;

        for (int i = 0; i < intNum; i++) {
            String input = scan.nextLine().trim();
            String[] curNext = input.split(" ");

            result = result * Double.parseDouble(curNext[1]) / Double.parseDouble(curNext[0]);
            direction += Integer.parseInt(curNext[2]);
        }

        int resultDirection = 0;

        if(direction % 2 == 1){
            resultDirection = 1;
        }

        System.out.println(resultDirection + " " + result.intValue());
    }
}
