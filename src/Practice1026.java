package src.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by yongjin on 2018-10-01.
 */
public class Practice1026 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String line = "";
        while((line = br.readLine()) != null && !line.equals("")){
            String[] strs = line.split(" ");
            Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        }
    }
}
