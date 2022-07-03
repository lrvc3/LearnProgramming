package Topics.DynamicProgramming.KnapSack;

public class CountSubsetsOfGivenSum {

    public static int noOfSubset(int[] arr, int target, int n) {
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
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j]; // either take or(||) do not take
                else // if sum is less than array size just leave and increment
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][target];

    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 6, 8, 10 };
        int target = 10;
        int n = arr.length;

        System.out.println(noOfSubset(arr, target, n));
    }
}
