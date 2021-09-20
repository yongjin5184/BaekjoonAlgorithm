public class ZigzagConversion {

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
