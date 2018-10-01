import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yong on 2018. 10. 1..
 */
public class Practice1181 {

    public static Alpa[] strs;
    public static void main(String[] args) throws IOException{
        /**
         * @description : 백준 1181번 단어 정렬
         * @solution : 1. 길이로 우선 정렬
         *             2. 사전 순으로 두 번째 정렬
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        strs = new Alpa[N];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            Alpa alpabet = new Alpa(str, str.length());
            strs[i] = alpabet;
        }

        Arrays.sort(strs);

        List<String> list = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            if(!list.contains(strs[i].str))
                list.add(strs[i].str);
        }

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}

class Alpa implements Comparable<Alpa>{

    String str;
    int length;

    Alpa(String str, int length){
        this.str = str;
        this.length = length;
    }

    @Override
    public int compareTo(Alpa o) {
        if(o.length > this.length){
            return -1;
        }else if(o.length == this.length){
            return this.str.compareTo(o.str);
        }else{
            return 1;
        }
    }
}
