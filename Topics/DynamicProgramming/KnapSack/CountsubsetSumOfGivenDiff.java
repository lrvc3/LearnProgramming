package Topics.DynamicProgramming.KnapSack;

public class CountsubsetSumOfGivenDiff {

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

    public static int getCountOfSubsetsWithDiffk(int[] arr, int k, int n){
        int target = 0;
        int sum = 0;
        
        for (int i : arr) {
            sum += i;
        }
        target = (k + sum)/2;

        return noOfSubset(arr, target, n);
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3};
        int diff = 1;
        int n = arr.length;

        System.out.println(getCountOfSubsetsWithDiffk(arr, diff, n));
    }
}
