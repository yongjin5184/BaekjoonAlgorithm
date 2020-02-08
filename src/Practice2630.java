import java.io.*;

public class Practice2630 {

    private static boolean[][] board;
    private static int white;
    private static int blue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        int n = Integer.parseInt(br.readLine());

        board = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                board[i][j] = line[j].equals("1");
            }
        }

        divide(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void divide(int x, int y, int n) {
        if (n == 1) {
            if (board[x][y]) {
                blue++;
            } else {
                white++;
            }
            return;
        }
        boolean sameColor = true;
        boolean color = board[x][y];
        out:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[x + i][y + j] != color) {
                    sameColor = false;
                    break out;
                }
            }
        }
        if (sameColor) {
            if (board[x][y]) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        int newN = n / 2;
        divide(x, y, newN);
        divide(x + newN, y, newN);
        divide(x, y + newN, newN);
        divide(x + newN, y + newN, newN);
    }
}

