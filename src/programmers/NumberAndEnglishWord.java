package src.src.programmers;

import java.util.HashMap;

public class NumberAndEnglishWord {

    public static void main(String[] arg) {

    }

    public int solution(String s) {
        StringBuilder result = new StringBuilder();
        String[] englishWordsOf = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] numbersAndEnglishWords = s.split("");
        int start = 0;
        for (int i = 0; i < numbersAndEnglishWords.length; i++) {
            // 만약 숫자이면
            if (isNumber(numbersAndEnglishWords[i])) {
                result.append(numbersAndEnglishWords[i]);
                start++;
            } else {

            }
        }

        int answer = 0;
        return answer;
    }

    public boolean isNumber(String s) {
        return Character.isDigit(s.charAt(0));
    }
}
