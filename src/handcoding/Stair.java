package handcoding;

public class Stair {

    /**
     * 계단 오르기
     * 손으로 해보면 피보나치 수열이라는 것을 알 수 있음
     */
    public static int fib2(int n) {
        if (n <= 1) {
            return 1;
        }

        return fib2(n - 1) + fib2(n - 2);
    }


    public static void main(String args[]) {
        int s = 20;
        System.out.println("fib2 = " + fib2(s));
    }
}

