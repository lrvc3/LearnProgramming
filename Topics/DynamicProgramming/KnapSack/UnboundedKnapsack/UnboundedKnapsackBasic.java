package Topics.DynamicProgramming.KnapSack.UnboundedKnapsack;

public class UnboundedKnapsackBasic {

    public static int unbounded(int wt[], int val[], int target, int n){
        int [][] t = new int [n+1][target+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0 || j == 0) // base case
                    t[i][j] = 0;
                else if (wt[i - 1] <= j) { // current wt can fit in bag
                    int val1 = val[i - 1] + t[i][j - wt[i - 1]]; // take current wt
                    int val2 = t[i - 1][j]; // skip current wt
                    t[i][j] = Math.max(val1, val2);
                }
                else if (wt[i - 1] > j) // current wt doesn't fit in bag
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][target];
    }

    public static void main(String[] args) {
        int[] arr = { 3, 34, 4, 12, 5, 2 };
        int[] val = {};
        int sum = 30;
        int n = arr.length;
        System.out.println();
    }
}
