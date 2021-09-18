package Leetcode;

public class ContainerWithMostWater {

    /**
     * @description 11. Container With Most Water
     * 1. 이 중 Loop 로 풀게 되면 Time Limit Exceeded 가 발생한다.
     * 2. Two Pointer 를 둔다. (왼쪽 포인터와 오른쪽 포인터를 둔다.)
     * 3. 오른쪽 값이 크거나 같으면 왼쪽 포인터를 한 칸 옮기고 왼쪽 값이 끄면 오른쪽 포인터를 한 칸 옮긴다.
     * 4. Max 값을 구해서 반환한다.
     */
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 1}));
        System.out.println(maxArea(new int[]{4, 3, 2, 1, 4}));
        System.out.println(maxArea(new int[]{1, 2, 1}));
    }

    public static int maxArea(int[] height) {
        int currentMostWater = 0;
        int left = 0;
        int right = height.length - 1;
        while (right > left) {
            int waterContainsHere = (right - left) * Math.min(height[left], height[right]);
            if (height[right] >= height[left]) {
                currentMostWater = Math.max(currentMostWater, waterContainsHere);
                left++;
            } else {
                currentMostWater = Math.max(currentMostWater, waterContainsHere);
                right--;
            }
        }
        return currentMostWater;
    }
}
