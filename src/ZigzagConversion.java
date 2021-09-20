public class ZigzagConversion {

    /**
     * @description 6. ZigZag conversion 파라미터로 String 과 row 가 주어졌을때, 아래 예시와 같은  Output 을 반환하는 메소드를 만들어라.
     * Input
     * s = PAYPALISHIRING, numRows = 2
     *
     * P Y A I H R N
     * A P L S I I G
     *
     * Output
     * PYAIHRNAPLSIIG
     *
     * Input
     * s = PAYPALISHIRING, numRows = 3
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     *
     * Output
     * PAHNAPLSIIGYIR
     *
     *
     * Input
     * s = PAYPALISHIRING, numRows = 4
     *
     * P     I     N
     * A   L S   I G
     * Y A   H R
     * P     I
     *
     * Output
     * PINALSIGYAHRPI
     *
     * Input
     * s = PAYPALISHIRING, numRows = 5
     *
     * P       H
     * A     S I
     * Y   I   R
     * P L     I G
     * A       N
     *
     * Output
     * PHASIYIRPLIGAN
     */
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("PAYPALISHIRING", 5));
    }

    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        int currRow = 0;
        int step = 1;
        for (int i = 0; i < s.length(); i++) {
            if (rows[currRow] == null) {
                rows[currRow] = new StringBuilder();
            }
            rows[currRow].append(s.charAt(i));
            currRow += step;
            if (currRow == rows.length || currRow == -1) {
                step = -step;
                currRow += (2 * step);
            }
        }

        StringBuilder output = new StringBuilder();
        for (StringBuilder row : rows) {
            if (row != null) {
                output.append(row);
            }
        }
        return output.toString();
    }

}
