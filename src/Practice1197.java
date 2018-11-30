import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yong on 2018. 11. 29..
 */
public class Practice1197 {
    public static void main(String[] args) throws IOException{
        /**
         * description : 백준 1197 최소스패닝/신장트리(MST)
         * solution : 1. 크루스칼 알고리즘 이용
         *               2. Union - Find 알고리즘 이용
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(" ");
        int[] arr = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();

        List<Edge> edgeList = new ArrayList<>();
        for(int i = 0; i < arr[1]; i++){
            String[] strs2 = br.readLine().trim().split(" ");
            int[] arr1 = Arrays.stream(strs2).mapToInt(Integer::parseInt).toArray();
            edgeList.add(new Edge(arr1[0], arr1[1], arr1[2]));
        }

        Collections.sort(edgeList, (Edge e1, Edge e2) -> e1.distance - e2.distance );

        int[] cycle = new int[arr[0]];
        for(int i = 0; i < arr[0]; i++){
            cycle[i] = i;
        }

        int sum = 0;
        for (int i = 0; i < edgeList.size(); i++){
            if(!findParent(cycle, edgeList.get(i).node[0] - 1, edgeList.get(i).node[1] - 1)){
                sum += edgeList.get(i).distance;
                unionParent(cycle, edgeList.get(i).node[0] - 1, edgeList.get(i).node[1] - 1);
            }
        }

        System.out.println(sum);

    }

    public static int getParent(int[] arr, int x){
        if(arr[x] == x) return x;
        return arr[x] = getParent(arr, arr[x]);
    }

    public static void unionParent(int[] arr, int a, int b){
        a = getParent(arr, a);
        b = getParent(arr, b);

        if(a < b) arr[b] = a;
        else arr[a] = b;
    }

    public static Boolean findParent(int[] arr, int a, int b){
        a = getParent(arr, a);
        b = getParent(arr, b);

        if(a == b) return true;
        else return false;
    }

}

class Edge{
    public int[] node = new int[2];
    public int distance;

    Edge(int a, int b, int distance){
        this.node[0] = a;
        this.node[1] = b;
        this.distance = distance;
    }
}
