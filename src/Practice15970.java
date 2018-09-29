import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by yong on 2018. 9. 29..
 */
public class Practice15970 {
    public static void main(String[] args) throws IOException{
        /**
         * decription : 백준 15970번 화살표 그리기
         * solution : 1. Position과 color 를 가지는 Class를 만든다.
         *            2. Array sort를 통해 Position의 오름 차순으로 정렬 한 후,
         *            3. for loop를 통해 Color가 같은 점이 나오면 그 거리를 계산한다.
         *            4. 거리가 가장 최소 값일 때 거리를 Return 하여 모두 더한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Point15970[] points;
        int N = Integer.parseInt(br.readLine());
        points = new Point15970[N];
        for(int i = 0; i < N; i++){
            String[] strs = br.readLine().trim().split(" ");
            int[] arr = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
            Point15970 point = new Point15970(arr[0], arr[1]);
            points[i] = point;
        }

        Arrays.sort(points);
        /*
        for(int i = 0; i < points.length; i++) {
            System.out.println(points[i].position + " " + points[i].color);
        }
        */
        int sum = 0;
        for(int i = 0; i < points.length; i++){
            int minLength = 100000;
            Point15970 point = points[i];

            int pointPosition = point.position;
            int pointColor = point.color;

            for(int j = 0; j < points.length; j++) {
                if(i == j) continue;
                if(pointColor == points[j].color) {
                    int length = Math.abs(pointPosition - points[j].position);
                    if(minLength >= length){
                        minLength = length;
                    }
                }
            }
            sum += minLength;
//            System.out.println(point.position + " minLength = " + minLength);
        }
        System.out.println(sum);
    }

}

class Point15970 implements Comparable<Point15970>{
    int position;
    int color;

    Point15970(int position, int color){
        this.position = position;
        this.color = color;
    }

    @Override
    public int compareTo(Point15970 o) {
        return this.position - o.position;
    }
}
