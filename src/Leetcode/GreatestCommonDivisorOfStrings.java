package Leetcode;

public class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        // 문제 페이지에 공개된 예제 4개
        // https://leetcode.com/problems/greatest-common-divisor-of-strings/
        // 순서: 설명, str1, str2, 기대값
        runTest("공식 예제 1: 짧은 문자열 전체가 반복 단위", "ABCABC", "ABC", "ABC");
        runTest("공식 예제 2: 후보를 줄여서 찾기", "ABABAB", "ABAB", "AB");
        runTest("공식 예제 3: 공통 반복 단위가 없음", "LEET", "CODE", "");
        runTest("공식 예제 4: 앞부분만 같고 전체는 다름", "AAAAAB", "AAA", "");

        // 추가 연습용 케이스 (공식 예제나 비공개 채점 데이터가 아닙니다.)
        // 문제 조건: 각 문자열은 길이 1~1000, 영문 대문자로 구성됩니다.
        runTest("추가 1: 가장 짧은 단위가 아닌 가장 긴 단위", "AAAAAA", "AAAA", "AA");
        runTest("추가 2: 두 문자열이 같음", "ABC", "ABC", "ABC");
        runTest("추가 3: 첫 번째 문자열이 더 짧음", "AB", "ABABAB", "AB");
        runTest("추가 4: 양쪽 모두 한 글자", "A", "A", "A");
        runTest("추가 5: 길이가 나누어떨어져도 내용이 다름", "ABAC", "AB", "");

        System.out.println("\n실행한 모든 케이스 통과!");
    }

    // 테스트용 메서드: 입력 → 풀이 호출 → 기대값과 비교
    // 하나만 보고 싶다면 main에서 나머지 runTest 호출을 주석 처리하세요.
    private static void runTest(String name, String str1, String str2, String expected) {
        System.out.println("\n========== " + name + " ==========");
        System.out.println("입력: str1 = \"" + str1 + "\", str2 = \"" + str2 + "\"");

        String result = gcdOfStrings(str1, str2);

        // 빈 문자열도 눈에 보이도록 따옴표로 감쌉니다.
        System.out.println("기대값: \"" + expected + "\"");
        System.out.println("실제값: \"" + result + "\"");
        if (expected.equals(result)) {
            System.out.println("판정: PASS");
        } else {
            throw new AssertionError(name + " 실패: 기대값=\"" + expected
                    + "\", 실제값=\"" + result + "\"");
        }
    }

    /**
     * 쉬운 풀이: 긴 접두사부터 한 글자씩 줄이며 공통 반복 단위인지 확인합니다.
     * n은 str1의 길이, m은 str2의 길이입니다.
     * 시간 복잡도 상한: O(min(n, m) * (n + m)).
     * 추가 공간 복잡도: O(max(n, m)) — 반복해서 만든 문자열을 보관합니다.
     */
    public static String gcdOfStrings(String str1, String str2) {
        // 디버깅: 아래 줄 왼쪽 여백에 중단점을 찍고 main을 Debug로 실행하세요.
        // Step Over로 length와 candidate를 확인하고,
        // canMake 호출에서 Step Into로 들어가 반복 문자열이 만들어지는 과정을 봅니다.

        // 1단계: 반복 단위는 두 문자열 중 짧은 쪽보다 길 수 없습니다.
        int maxLength = Math.min(str1.length(), str2.length());

        // 2단계: 긴 후보부터 검사합니다. 처음 성공한 후보가 가장 긴 정답입니다.
        for (int length = maxLength; length >= 1; length--) {
            // 반복 단위는 두 문자열의 시작 부분과 같아야 합니다.
            String candidate = str1.substring(0, length);

            // 3단계: 같은 후보를 반복해서 양쪽 문자열 전체를 만들 수 있는지 확인합니다.
            if (canMake(str1, candidate) && canMake(str2, candidate)) {
                return candidate;
            }
        }

        // 4단계: 모든 후보가 실패하면 공통 반복 단위가 없습니다.
        return "";
    }

    private static boolean canMake(String target, String candidate) {
        // 후보를 자르지 않고 반복하려면 길이가 나누어떨어져야 합니다.
        // 예: 길이 6인 문자열은 길이 4인 후보를 반복해서 만들 수 없습니다.
        if (target.length() % candidate.length() != 0) {
            return false;
        }

        // 예: target = "ABABAB", candidate = "AB"이면 6 / 2 = 3번 반복합니다.
        int count = target.length() / candidate.length();
        StringBuilder repeated = new StringBuilder();

        for (int i = 0; i < count; i++) {
            repeated.append(candidate);
        }

        // 길이뿐 아니라 내용까지 같아야 성공입니다.
        // 문자열 내용 비교에는 == 대신 equals를 사용합니다.
        return target.equals(repeated.toString());
    }
}
