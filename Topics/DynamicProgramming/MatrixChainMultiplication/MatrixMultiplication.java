package Topics.DynamicProgramming.MatrixChainMultiplication;

public class MatrixMultiplication {

    public static int mcmRecursive(int[] arr, int i, int j){
        if (i >= j) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = mcmRecursive(arr, i, k) +
                      mcmRecursive(arr, k+1, j) +
                      arr[i-1] * arr[k] * arr[j];
            ans = Math.min(temp, ans);
        }
        return ans;
    }
    
    public static int[][] t = new int[101][1001];
    public static int mcmMemo(int[] arr, int i, int j){
        if (i >= j) {
            return 0;
        }

        if(t[i][j] != -1){
            return t[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = mcmMemo(arr, i, k) +
            mcmMemo(arr, k+1, j) +
                      arr[i-1] * arr[k] * arr[j];
            ans = Math.min(temp, ans);
        }
        return t[i][j] = ans;
    }


    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 1001; j++) {
                t[i][j] = -1;
            }
        }
        // System.out.println(mcmRecursive(arr, 1, arr.length - 1));
        System.out.println(mcmMemo(arr, 1, arr.length - 1));
    }
}
