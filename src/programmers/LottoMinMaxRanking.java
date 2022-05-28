package src.src.programmers;

import java.util.Arrays;

/**
 * 로또의 최고 순위와 최저 순위
 * https://programmers.co.kr/learn/courses/30/lessons/77484
 */
public class LottoMinMaxRanking {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})));
        System.out.println(Arrays.toString(solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25})));
        System.out.println(Arrays.toString(solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35})));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int matchedCount = 0;
        int unknownCount = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                unknownCount++;
                continue;
            }

            if (isMatched(win_nums, lotto)) {
                matchedCount++;
            }
        }

        int maxRanking = getRanking(matchedCount + unknownCount);
        int minRanking = getRanking(matchedCount);

        return new int[]{maxRanking, minRanking};
    }

    private static boolean isMatched(int[] win_nums, int lotto) {
        for (int win_num : win_nums) {
            if (lotto == win_num) {
                return true;
            }
        }
        return false;
    }

    private static int getRanking(int matchedOrUnknownCount) {
        int ranking;
        switch (matchedOrUnknownCount) {
            case 2:
                ranking = 5;
                break;
            case 3:
                ranking = 4;
                break;
            case 4:
                ranking = 3;
                break;
            case 5:
                ranking = 2;
                break;
            case 6:
                ranking = 1;
                break;
            default:
                ranking = 6;
                break;
        }
        return ranking;
    }
}
