import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice17609 {

    private static int N;
    private static char[] chars;
    public static void main(String[] args) throws IOException {
        /**
         * @description: 백준 17609 회문 (한국정보올림피아드 KOI 2019 1차대회 초등부)
         * @solution : 1.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        N = Integer.parseInt(br.readLine());

        int[] resultArr = new int[N];
        for(int i = 0; i < N; i++){
            chars = br.readLine().toCharArray();
            System.out.println(getAns());
        }
    }

    static Boolean isPalindrome()
    {
        int left=0,right=chars.length-1;
        while(left<=right)
        {
            if(chars[left++]!=chars[right--]) return false;
        }
        return true;
    }

    static Boolean canPalindrome(int left,int right,Boolean flag)
    {
        if(left>right) return true;
        if(chars[left]==chars[right]) return canPalindrome(left+1,right-1,flag);
        else if(flag) return canPalindrome(left + 1, right, false)
            || canPalindrome(left, right - 1, false);
        else return false;
    }

    static int getAns()
    {
        if(isPalindrome()) return 0;
        else if(canPalindrome(0,chars.length-1,true)) return 1;
        else return 2;
    }
}
