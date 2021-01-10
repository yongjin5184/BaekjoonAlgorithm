package Leetcode;

public class MinimumPathSum {

    /**
     * @description 2차원 배열에서 가장 마지막 arr[m][n] 에 도달하였을 때, 최소비용을 찾는 문제
     * 1. arr[m][0] 과 arr[0][n] 은 이전 값에 현재 비용을 더해서 구한다.
     * 2. 테두리(arr[m][0], arr[0][n]) 이외의 부분은 두 값 중 최소값을 구해 현재 비용을 더한다.
     * F(x,y) = cost(x,y) + Min(f(x-1, y), f(x, y-1))
     */
    public static int minimumPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int m = 1; m < dp.length; m++) {
            dp[m][0] = grid[m][0] + dp[m - 1][0];
        }

        for (int n = 1; n < dp[0].length; n++) {
            dp[0][n] = grid[0][n] + dp[0][n - 1];
        }

        for (int m = 1; m < dp.length; m++) {
            for (int n = 1; n < dp[0].length; n++) {
                dp[m][n] = grid[m][n] + Math.min(dp[m - 1][n], dp[m][n - 1]);
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}};

        System.out.println(minimumPathSum(grid1));
        System.out.println(minimumPathSum(grid2));
    }
}
