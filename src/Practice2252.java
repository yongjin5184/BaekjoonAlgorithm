import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by yong on 2018. 11. 30..
 */
public class Practice2252 {
    public static int[] indegree;
    public static ArrayList<Integer>[] list;

    public static void main(String[] args) throws Exception {
        /**
         * description : 백준 2252번 줄 세우기
         * solution : 1. 위상정렬을 이용하여 정렬한다.
         *              * 위상정렬 : 순서가 정해져 있는 작업을 차례로 수행할 때, 그 순서를 결정해주기 위해 사용하는 알고리즘.
         *            2. Arraylist<Integer>[] list를 선언한다.
         *            3. 자신을 가르키는 화살표의 갯수를 표현하는 indegree 배열을 선언한다.(진입차수 배열)
         *            4. Queue를 선언하여, 진입차수가 0인 경우 Queue에 넣어준다.
         *            5. Queue에서 값을 빼면서 list를 통해 다음 가리키는 값으로 이동하고 가리키는 화살표를 없애준다.
         *            6. 화살표를 없애면 indegree의 값에서 -1을 하고 indegree가 0이라면 Queue에 넣어 계속 진행되도록 한다.
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(" ");
        int[] arr = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        int N = arr[0];
        int M = arr[1];

        indegree = new int[N + 1];
        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            String[] strs2 = br.readLine().trim().split(" ");
            int[] arr2 = Arrays.stream(strs2).mapToInt(Integer::parseInt).toArray();
            int x = arr2[0];
            int y = arr2[1];
            list[x].add(y);
            indegree[y]++;
        }

        topologySort();

    }

    public static void  topologySort(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            System.out.print(queue.peek() + " ");
            int current = queue.poll();

            for(int i = 0; i < list[current].size(); i++){
                int next = list[current].get(i);
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.add(next);
                }
            }
        }
    }
}


