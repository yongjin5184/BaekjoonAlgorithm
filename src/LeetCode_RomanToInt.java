import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_RomanToInt {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode RomanToInt
         *               로마숫자를 숫자로 바꾸는 문제
         * solution     : 로마 숫자는 두 가지 방법으로 계산된다.
         *                뒤에 큰 숫자가 나오면 뒷 문자에서 앞 문자를 빼고 Sum 을 계산한다.
         *                그렇지 않으면 뒷 숫자를 더해 Sum 을 계산한다.
         * result       : O(n)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        System.out.println(romanToInt(br.readLine()));
    }

    public static int romanToInt(String s) {
        if(s.length() == 0 ) return 0;

        Map<Character,Integer> map = initMap();
        int result = map.get(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            int x = map.get(s.charAt(i - 1));
            int y = map.get(s.charAt(i));
            if(y > x) {
                result = result - x;
                result = result + y - x;
            } else {
                result = result + y;
            }
        }
        return result;
    }

    private static Map<Character,Integer> initMap(){
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        return map;
    }
}
