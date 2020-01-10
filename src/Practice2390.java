import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice2390 {

    public static void main(String[] args) throws Exception {
        /**
         * description : 백준 2390번 일곱난쟁이
         * solution : 1. 아홉명의 난쟁이가 있고 이 중, 일곱명의 난쟁이만 더해서 100이 되면 그 난쟁이를 정렬하여 리턴한다.
         *            2. 모든 난쟁이의 합을 구한다.
         *            3. 이중 루프를 돌면서 합에서 i 번째와 j 번째를 뺀다.
         *            4. 합에서 i 번째와 j 번째를 빼고 100이 되는 순간 List 를 정렬하여 출력한다.
         *
         **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            arr.add(Integer.parseInt(br.readLine()));
            sum += arr.get(i);
        }

        List<Integer> resultArrLists = getSevenDwarfs(arr, sum);
        for(int i = 0; i < 7; i++){
            System.out.println(resultArrLists.get(i));
        }
    }

    private static ArrayList<Integer> getSevenDwarfs( ArrayList<Integer> arr, int sum) {
        for(int i = 0; i < 8; i++){
            for(int j = i + 1; j < 9; j++) {
                if(sum - arr.get(i) - arr.get(j) == 100){
                    arr.remove(i);
                    arr.remove(j - 1);
                    Collections.sort(arr);
                    return arr;
                }
            }
        }
        return new ArrayList<>();
    }
}
