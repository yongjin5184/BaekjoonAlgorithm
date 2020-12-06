package src.src.programmers;

public class ReverseTernaryNotation {

    public static int solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n >= 3) {
            stringBuilder.insert(0, n % 3);
            n = n / 3;
        }
        stringBuilder.insert(0, n);

        StringBuilder reverse = stringBuilder.reverse();
        int result = 0;
        for (int i = reverse.length() - 1, j = 0; i >= 0; i--, j++) {
            result = result + (reverse.charAt(i) - '0') * (int) Math.pow(3, j);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(45));
        System.out.println(solution(125));
    }
}
