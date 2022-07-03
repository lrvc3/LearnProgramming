package Topics.DynamicProgramming.MatrixChainMultiplication;

public class Mcm {

    // Basic Format
    // think of invalid input - Base Condition for MCM
    public static int solve(int[] arr, int i, int j){
        // Depends on question
        if (i > j) {
            return 0;
        }
        int ans = 0;
        for (int k = i; k < j ; k++) {
            // Calculate temp ans
            int tempans = solve(arr, i, k) + solve(arr, k+1, j);
            // Computation based on tempans 
            ans = tempans; 
        }

        return ans;
    }

    public static void main(String[] args) {
        
    }
}
