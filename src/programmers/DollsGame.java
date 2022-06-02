package src.src.programmers;

import java.util.Arrays;
import java.util.Stack;

public class DollsGame {

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution(board, moves));

//        int[][] board2 = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
//        int[] moves2 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
//        System.out.println(solution(board2, moves2));
//
//        int[][] board3 = {{1, 1}, {1, 1}};
//        int[] moves3 = {1, 2, 1, 2};
//        System.out.println(solution(board3, moves3));

    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] topIndexes = new int[board.length];
        Arrays.fill(topIndexes, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0 && topIndexes[j] == -1) {
                    topIndexes[j] = i;
                }
            }
        }

        for (int j : moves) {
            int move = j - 1;
            int topIndex = topIndexes[move];
            if (topIndex < topIndexes.length) {
                int pick = board[topIndex][move];
                topIndexes[move] = topIndex + 1;
                if (stack.empty()) {
                    stack.push(pick);
                    continue;
                }

                if (stack.peek() == pick) {
                    stack.pop();
                    answer = answer + 2;
                    continue;
                }
                stack.push(pick);
            }
        }

        return answer;
    }

    public static int solution2(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }
                    if (board[j][move - 1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else
                        stack.push(board[j][move - 1]);
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
