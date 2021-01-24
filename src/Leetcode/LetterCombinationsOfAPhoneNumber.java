package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    /**
     * @description 17. Letter Combinations of a Phone Number 백트래킹 문제
     * 숫자에 맵핑되어 있는 알파벳이 주어지고, digits (숫자) 가 주어질 때, 숫자에 맵핑된 알파벳을 사용하여 나올 수 있는 문자를 구하는 문제
     * 1. recursion 을 이용하여, 다음 문자를 더해 나간다.
     * 2. 반환 조건은 index 가 주어진 digits 의 길이와 같아지면 중단한다.
     */
    private static String phoneLetters[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private static char[] chars;

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() <= 0) {
            return result;
        }

        chars = digits.toCharArray();

        backtracking(0, "", result);

        return result;
    }

    public static void backtracking(int index, String letter, List<String> result) {

        if (index >= chars.length) {
            result.add(letter);
            return;
        }

        int i = Integer.parseInt(String.valueOf(chars[index]));
        String phoneLetter = phoneLetters[i];
        char[] chars = phoneLetter.toCharArray();
        for (char c : chars) {
            backtracking(index + 1, letter + c, result);
        }
    }

    public static void main(String[] args) {
        System.out.println("letterCombinations = " + letterCombinations("23"));
        System.out.println("letterCombinations = " + letterCombinations(""));
        System.out.println("letterCombinations = " + letterCombinations("2"));
    }
}
