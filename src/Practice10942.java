import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice10942 {

    static int[] numArr;
    static int[][] palArr;
    public static void main(String[] args) throws IOException {
        /**
         * @description: 백준 10941 팰린드롬?
         * @solution :
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        int cnt = Integer.parseInt(br.readLine());
        numArr = new int[cnt + 1];
        palArr = new int[cnt + 1][cnt + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= cnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int cmdCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cmdCnt; i++) {
            st = new StringTokenizer(br.readLine());
            if(isPalindrom(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) == 2){
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static int isPalindrom(int start, int end ) {
        if (start == end)
            return 2;

        if (start + 1 == end) {
            if (numArr[start] == numArr[end])
                return 2;
            return 1;
        }

        if(palArr[start][end] >= 1)
            return palArr[start][end];

        if (numArr[start] != numArr[end]) {
            return 1;
        } else {
            return (palArr[start][end] = isPalindrom(start + 1, end - 1));
        }
    }
}
