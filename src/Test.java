import java.util.*;
public class Test {
    static int size;
    static ArrayList<Integer>[] list;
    static int[] polution;

    static int min = Integer.MAX_VALUE;
    static boolean[] visit;
    static void division(int cnt, int visitCnt){
        //사이즈 넘어가지 않게
        if(visitCnt > size  - 1|| cnt > size + 1) return;

        // 경우의 수로 선택
        if(visitCnt != 0){
            //사이클 검증
            if(isVaild(visitCnt)) {
                checkMin();
            }
        }
        for(int i = cnt;i <= size;i++) {
            if(visit[i]) continue;
            visit[i] = true;
            division(i, visitCnt + 1);
            visit[i] = false;
        }
    }

    static boolean isVaild(int visitCnt){
        boolean flag = false;
        for(int i = 1;i < size + 1;i++){
            flag = false;
            if(visit[i]){   // A
                if(visitCnt == 1) continue;
                int sizeA = list[i].size();
                for(int j = 0;j < sizeA;j++) {
                    int linked = list[i].get(j);
                    if(visit[linked]){
                        flag = true;
                        break;
                    }
                }
            }else if(!visit[i]){   // B
                if(size - visitCnt == 1) continue;
                int sizeB = list[i].size();
                for(int j = 0;j < sizeB;j++) {
                    int linked = list[i].get(j);
                    if(!visit[linked]){
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag) break;
        }

        return flag;
    }


    static void checkMin(){
        int a = 0;
        int b = 0;
        for(int i = 1;i < size + 1;i++){
            if(visit[i]){
                a += polution[i];
            }else {
                b += polution[i];
            }
        }
        min = Math.min(min, Math.abs(a - b));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        list = new ArrayList[size + 1];
        polution = new int[size + 1];
        visit = new boolean[size + 1];

        for(int i = 0;i < size;i++){
            polution[i + 1] = sc.nextInt();
        }

        for(int i = 0;i < size;i++){
            int tmp = sc.nextInt();
            list[i + 1] = new ArrayList<>();
            for(int j = 0;j < tmp;j++){
               list[i + 1].add(sc.nextInt());
            }
        }

        division(1, 0);
        System.out.println(min);
    }
}
