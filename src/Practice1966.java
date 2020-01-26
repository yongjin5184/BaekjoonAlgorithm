import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Practice1966 {
    public static void main(String[] args) throws Exception {
        /**
         * description : 백준 1966번 프린터 큐
         * solution : 1. 문제와 제시되어있는 것처럼 큐를 만들고
         *            2. 큐의 맨 앞의 우선순위가 가장 크면 큐에서 poll 한 후, printSequence ++
         *            3. 그렇지 않으면 큐의 마지막에 다시 offer 한다.
         *            4. M (궁금한 문서의 sequence) 일 경우 printSequence + 1  를 리턴한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        int cnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < cnt; i++) {
            String[] MN = br.readLine().trim().split(" ");
            String[] valueOfQueue = br.readLine().trim().split(" ");
            Queue<Print> queue = new LinkedList<>();
            for(int j = 0; j < valueOfQueue.length; j++) {
                queue.offer(Print.of(Integer.parseInt(valueOfQueue[j]) , j));
            }

            System.out.println(getPrintSequence(queue, Integer.parseInt(MN[1])));
        }
    }

    private static int getPrintSequence(Queue<Print> queue, int m) {
        int printSequence = 0;
        while(!queue.isEmpty()){
            Print peekOfQueue = queue.poll();

            if(queue.isEmpty()){
                return printSequence + 1;
            }

            int i = 0;
            for(Print print : queue) {
                if(peekOfQueue.getPriority() < print.getPriority()){
                    queue.offer(peekOfQueue);
                    break;
                }

                if(++i == queue.size()) {
                    if (peekOfQueue.getSequence() == m) {
                        return printSequence + 1;
                    }

                    printSequence++;
                }
            }
        }

        throw new RuntimeException();
    }


}

class Print {
    private int priority;
    private int sequence;

    private Print(){};

    private Print(int priority, int sequence) {
        this.priority = priority;
        this.sequence = sequence;
    }

    public static Print of(int priority, int sequence) {
        return new Print(priority, sequence);
    }

    public int getPriority() {
        return priority;
    }

    public int getSequence() {
        return sequence;
    }
}


