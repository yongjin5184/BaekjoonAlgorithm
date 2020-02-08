import java.util.*;
class Pair{
    int x, y;
    Pair(int a, int b, int c, boolean flag){
        if(flag) {
            this.x = a - c;
            this.y = b - c;
        }else{
            this.x = a + c;
            this.y = b + c;
        }
    }
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Test2 {
    static int N, M;
    static int num;
    static int[][] arr;
    static Pair[][] posit;

    static int min = Integer.MAX_VALUE;
    static boolean[] visit;

    static void dfs(int cnt, int[] order){
        if(cnt == num){
            int[][] save = saveArr();
            for(int i = 0;i < num;i++){
                rotation(order[i]);
                checkMin();
            }
            revertArr(save);
        }

        for(int i = 0; i < num;i++){
            if(visit[i]) continue;
            visit[i] = true;
            order[cnt] = i;
            dfs(cnt + 1, order);
            visit[i] = false;
        }
    }

    static void rotation(int now){
        Pair top = posit[now][0];
        Pair bottom = posit[now][1];

        int loopSize = posit[now][1].x - posit[now][0].x;

        for(int i = 0;i < loopSize;i++){
                top.x += i; top.y += i;
                bottom.x -= i; bottom.y -= i;
                rotate(top, bottom);
        }
    }
    static void rotate(Pair a, Pair b){
        int x = a.x; int y = a.y;
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Pair> posit = new LinkedList<>();
        while(true){
            queue.add(arr[x][y]);
            posit.add(new Pair(x, y));
            y = (y + 1 >= a.y) ? y + 1 : a.y;
            x = (y == a.y) ? x + 1 : x;
            if(x > b.x|| y > b.y) {
                int size = posit.size();
                int last = queue.removeLast();
                queue.addFirst(last);
                for(int i = 0;i < size;i++){
                    Pair tmp = posit.remove();
                    arr[tmp.x][tmp.y] = queue.removeFirst();
                }
                break;
            }
        }
    }

    static int[][] saveArr(){
        int[][] save = new int[N][M];
        for(int i = 0;i < N;i++){
            for(int j = 0;j < M;j++){
                save[i][j] = arr[i][j];
            }
        }
        return save;
    }

    static void checkMin(){
        for(int i = 0;i < N;i++) {
            int sum = 0;
            for(int j = 0;j < M;j++){
                sum += arr[i][j];
            }
            min = Math.min(min, sum);
        }
    }

    static void revertArr(int[][] save){
        for(int i = 0;i < N;i++){
            for(int j = 0;j < M;j++){
                arr[i][j] = save[i][j];
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        num = sc.nextInt();
        posit = new Pair[num][2];
        visit = new boolean[num];

        arr = new int[N][M];
        for(int i = 0;i < N;i++){
            for(int j = 0;j < M;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0;i < num;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            posit[i][0] = new Pair(a, b, c, true);
            posit[i][1] = new Pair(a, b, c, false);
        }

        dfs(0, new int[num]);
        System.out.println(min);
    }
}
