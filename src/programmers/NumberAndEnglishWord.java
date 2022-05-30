package src.src.programmers;

public class NumberAndEnglishWord {

    public static void main(String[] arg) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"));
        System.out.println(solution("123"));
    }

    public static int solution(String s) {
        String[] englishWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(englishWords[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}
