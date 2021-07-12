package Leetcode;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) return -1;
        int totalGas = 0;
        int currentGas = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                index = i + 1;
            }
        }
        return totalGas < 0 ? -1 : index;
    }

    public static void main(String[] arg) {
        int i = canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        System.out.println(i);
    }
}
