package Leetcode;

import java.util.Arrays;

public class MergeStringsAlternately {

    public static void main(String[] args) {
        // 문제 페이지에 공개된 예제 3개
        // https://leetcode.com/problems/merge-strings-alternately/
        // 순서: 설명, word1, word2, 기대값
        runTest("공식 예제 1: 길이가 같음", "abc", "pqr", "apbqcr");
        runTest("공식 예제 2: 두 번째 문자열이 더 김", "ab", "pqrs", "apbqrs");
        runTest("공식 예제 3: 첫 번째 문자열이 더 김", "abcd", "pq", "apbqcd");

        // 추가 연습용 케이스 (공식 예제나 비공개 채점 데이터가 아닙니다.)
        // 문제 조건: 각 문자열은 길이 1~100, 영문 소문자로 구성됩니다.
        runTest("추가 1: 양쪽 모두 한 글자", "a", "z", "az");
        runTest("추가 2: 첫 번째만 한 글자", "a", "xyz", "axyz");
        runTest("추가 3: 두 번째만 한 글자", "xyz", "a", "xayz");
        runTest("추가 4: 같은 문자가 반복됨", "aaa", "aa", "aaaaa");

        System.out.println("\n실행한 모든 케이스 통과!");
    }

    // 테스트용 메서드: 입력 → 풀이 호출 → 기대값과 비교
    // 하나만 보고 싶다면 main에서 나머지 runTest 호출을 주석 처리하세요.
    private static void runTest(String name, String word1, String word2, String expected) {
        System.out.println("\n========== " + name + " ==========");
        System.out.println("입력: word1 = " + word1 + ", word2 = " + word2);
        String result = mergeAlternately(word1, word2);
        String result2 = mergeAlternately2(word1, word2);

        System.out.println("\n기대값: " + expected);
        System.out.println("기본 버전: " + result);
        System.out.println("최적화 버전: " + result2);
        // 문자열 내용 비교에는 == 대신 equals를 사용합니다.
        if (expected.equals(result) && expected.equals(result2)) {
            System.out.println("판정: 두 버전 모두 PASS");
        } else {
            throw new AssertionError(name + " 실패: 기대값=" + expected
                    + ", 기본=" + result + ", 최적화=" + result2);
        }
    }

    /**
     * 시간 복잡도: O((n + m)^2) — n은 word1의 길이, m은 word2의 길이.
     * 문자를 붙이는 횟수는 n + m번이지만, String은 불변이므로
     * result += 문자마다 기존 결과까지 새 문자열에 복사합니다.
     * 복사량의 합: 1 + 2 + ... + (n + m) → O((n + m)^2).
     */
    public static String mergeAlternately(String word1, String word2) {
        // 디버깅: 아래 줄 왼쪽 여백에 중단점을 찍고 main을 Debug로 실행하세요.
        // Step Over를 한 번씩 누르며 chars1, chars2, i, result를 확인하세요.

        // 1단계: 문자열을 문자 배열로 바꾸기
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        // 2단계: 짧은 배열 길이를 구하고, 결과를 담을 빈 문자열 준비
        int minLength = Math.min(chars1.length, chars2.length);
        String result = "";

        // 3단계: 양쪽에 문자가 있는 구간을 번갈아 붙이기
        for (int i = 0; i < minLength; i++) {
            result += chars1[i];
            result += chars2[i];
        }

        // 4단계: 첫 번째 배열에 남은 문자 붙이기
        System.out.println("\n[4단계] 첫 번째 배열의 남은 문자: " + (chars1.length - minLength) + "개");
        for (int i = minLength; i < chars1.length; i++) {
            result += chars1[i];
            System.out.println("chars1[" + i + "] = " + chars1[i] + " 추가 → " + result);
        }

        // 5단계: 두 번째 배열에 남은 문자 붙이기
        for (int i = minLength; i < chars2.length; i++) {
            result += chars2[i];
        }

        return result;
    }

    /**
     * 시간 복잡도: O(n + m) — n은 word1의 길이, m은 word2의 길이.
     * StringBuilder에 공간을 미리 확보하고 각 문자를 한 번씩 추가합니다.
     * 마지막 toString()의 복사도 O(n + m)이므로 전체는 O(n + m)입니다.
     */
    public static String mergeAlternately2(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        // 최종 길이만큼 공간을 준비하고, 문자열을 매번 새로 만들지 않고 붙입니다.
        StringBuilder result = new StringBuilder(length1 + length2);

        // 긴 문자열의 끝까지 진행하되, 각 문자열에 문자가 남아 있을 때만 붙입니다.
        for (int i = 0; i < Math.max(length1, length2); i++) {
            if (i < length1) {
                result.append(word1.charAt(i));
            }
            if (i < length2) {
                result.append(word2.charAt(i));
            }
        }

        // charAt()으로 직접 읽으므로 별도의 char[] 변환도 필요하지 않습니다.
        return result.toString();
    }
}
