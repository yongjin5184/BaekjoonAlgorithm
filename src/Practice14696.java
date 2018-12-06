import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice14696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {

            int[] tmp1 = new int[5];
            int[] tmp2 = new int[5];

            String[] strs1 = br.readLine().trim().split(" ");
            int[] arr1 = Arrays.stream(strs1).mapToInt(Integer::parseInt).toArray();

            String[] strs2 = br.readLine().trim().split(" ");
            int[] arr2 = Arrays.stream(strs2).mapToInt(Integer::parseInt).toArray();

            for(int j = 1; j <= arr1[0]; j++){
                tmp1[arr1[j]]++;
            }

            for(int j = 1; j <= arr2[0]; j++){
                tmp2[arr2[j]]++;
            }

            String result = "D";
            for(int j = tmp2.length - 1; j > 0; j--){
                if(tmp1[j] > tmp2[j]) {
                    result = "A";
                    break;
                }else if(tmp1[j] == tmp2[j]){
                    continue;
                }else{
                    result = "B";
                    break;
                }
            }

            System.out.print(result);
        }
    }
}
