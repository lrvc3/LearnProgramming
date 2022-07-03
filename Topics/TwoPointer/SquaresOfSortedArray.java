package Topics.TwoPointer;

import java.util.*;

public class SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        // Two Pointer Approach
        int left = 0;
        int right = nums.length - 1;

        // Start filling the array from the last
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[i] = nums[left] * nums[left];
                left++;
            } else {
                res[i] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -7, -3, 2, 3, 11 };
        int[] res = sortedSquares(nums);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
