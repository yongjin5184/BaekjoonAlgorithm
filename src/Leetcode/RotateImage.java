package Leetcode;

public class RotateImage {

    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int matrixLength = matrix.length;
        int temp;
        for (int i = 0; i < matrixLength / 2; i++) {
            for (int j = 0; j < (matrixLength + 1) / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[matrixLength - j - 1][i];
                matrix[matrixLength - j - 1][i] = matrix[matrixLength - i - 1][matrixLength - j - 1];
                matrix[matrixLength - i - 1][matrixLength - j - 1] = matrix[j][matrixLength - i - 1];
                matrix[j][matrixLength - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3},{4, 5, 6}, {7, 8, 9}};
        rotate(matrix1);
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print(matrix1[i][j]);
            }
            System.out.println();
        }

        int[][] matrix2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix2);
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j]);
            }
            System.out.println();
        }
    }
}
