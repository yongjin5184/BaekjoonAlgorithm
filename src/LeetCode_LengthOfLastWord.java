import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeetCode_LengthOfLastWord {

    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode Length Of Last Word
         *                문자의 띄어쓰기로 구분된 마지막 단어의 길이를 출력한다.
         * solution     : split 의 마지막 배열의 길이를 구한다.
         * result       : O(n)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        System.out.println(lengthOfLastWord(br.readLine()));
    }

    public static int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        if(strs.length <= 0) {
            return 0;
        }

        return strs[strs.length - 1].length();
    }
}
