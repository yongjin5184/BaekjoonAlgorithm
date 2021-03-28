package programmers;

import java.util.stream.IntStream;

public class DotProduct {
    public static int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(index -> a[index] * b[index]).sum();
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4};
        int[] b1 = {-3, -1, 0, 2};
        System.out.println(solution(a1, b1));
    }
}
