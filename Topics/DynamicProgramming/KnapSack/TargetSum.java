package Topics.DynamicProgramming.KnapSack;

/**
 * This problem is same as count subset sum with given difference.
 * 
 * basically we are assigning signs to the elements in such a manner that the
 * sets: s1 and s2 given a difference of k
 * 
 * s2 - s1 = k
 */
public class TargetSum {

    public static int subsetSum(int[] arr, int target, int n) {
        int[][] t = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][target];
    }

    public static int getCountOfSubsetsWithDiffk(int[] arr, int k, int n) {
        int target = 0;
        int sum = 0;

        for (int i : arr) {
            sum += i;
        }
        target = (k + sum) / 2;

        k = Math.abs(k);
        // [1000] -1000
        if (sum < k || (sum + k) % 2 != 0) {
            return 0;
        }

        return subsetSum(arr, target, n);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 1 };
        int target = 3;
        int n = arr.length;

        System.out.println(getCountOfSubsetsWithDiffk(arr, target, n));
    }
}
/**
 * Input: nums = [1,1,1,1,1], target = 3 Output: 5 Explanation: There are 5 ways
 * to assign symbols to make the sum of nums be target 3. -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3 +1 + 1 - 1 + 1 + 1 = 3 +1 + 1 + 1 - 1 + 1 = 3 +1 + 1 +
 * 1 + 1 - 1 = 3
 */