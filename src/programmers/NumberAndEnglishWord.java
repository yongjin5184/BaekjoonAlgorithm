package src.src.programmers;

import java.util.Map;

import static java.util.Map.entry;

public class NumberAndEnglishWord {

    static Map<String, String> englishWordsOfThreeSpell = Map.ofEntries(
            entry("one","1"),
            entry("two","2"),
            entry("six","6")
    );

    static Map<String, String> englishWordsOfFourSpell = Map.ofEntries(
            entry("zero","0"),
            entry("four","4"),
            entry("five","5"),
            entry("nine","9")
    );

    static Map<String, String> englishWordsOfFiveSpell = Map.ofEntries(
            entry("three","3"),
            entry("seven","7"),
            entry("eight","8")
    );

    static int start = 0;

    public static void main(String[] arg) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"));
        System.out.println(solution("123"));
    }

    public static int solution(String s) {
        StringBuilder result = new StringBuilder();
        int start = 0;
        while(start < s.length()) {
            String substring = s.substring(start, start + 1);
            if (isNumber(substring)) {
                // 만약 숫자이면
                result.append(substring);
                start++;
                continue;
            }

            // 숫자가 아니면
            String strNumber;
            String englishWord;
            englishWord = s.substring(start, start + 3);
            if (englishWordsOfThreeSpell.containsKey(englishWord)) {
                strNumber = englishWordsOfThreeSpell.get(englishWord);
            } else {
                englishWord = s.substring(start, start + 4);
                if (englishWordsOfFourSpell.containsKey(englishWord)) {
                    strNumber = englishWordsOfFourSpell.get(englishWord);
                } else {
                    englishWord = s.substring(start, start + 5);
                    strNumber = englishWordsOfFiveSpell.get(englishWord);
                }
            }

            result.append(strNumber);
            start += englishWord.length();
        }

        return Integer.parseInt(result.toString());
    }

    public static boolean isNumber(String s) {
        return Character.isDigit(s.charAt(0));
    }
}
