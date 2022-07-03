package Topics.DynamicProgramming.MatrixChainMultiplication;

public class Mcm_tabulation {

    private static int minCost(int[] arr){
        int n = arr.length;
        int[][] t = new int[n][n];
        for (int i = 0; i < t.length; i++) {
            t[i][i] = 0;
        }

        for (int i = n-1; i >= 1; i--) {
            for(int j = i + 1; j < n; j++){
                int mini = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int steps = arr[i-1] * arr[k] * arr[j] +
                            t[i][k] + t[k+1][j];
                    if(steps < mini){
                        mini = steps;
                    }
                }
                t[i][j] = mini;
            }
        }
        return t[1][n-1];
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(minCost(arr));
    }
}
