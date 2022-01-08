package Leetcode;

public class LeetCode_IslandPerimeter {
    /**
     * description  : 463. LeetCode Island Perimeter
     * solution     : 1. 2차원 배열의 원소를 하나씩 접근한다.
     *                2. 값이 1을 만나면 결과 값을 +=4로 세팅한다.
     *                3. 위와 왼쪽을 검사한다.
     *                  1. 1이면 결과 값에서 각각 -=2 한다.
     *                  perimeter 를 계산하는 데 있어서, 두 개의 cell 에서 값이 차감되는 것이기 때문
     *                4. 결과 값을 리턴한다.
     * result       : O(n^2)
     */
    public static void main(String[] args) {
        int[][] test = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        System.out.println(islandPerimeter(test));
    }

    public static int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;

                    if (i > 0 && grid[i - 1][j] == 1) {
                        result -= 2;
                    }

                    if (j > 0 && grid[i][j - 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }

        return result;
    }
}
