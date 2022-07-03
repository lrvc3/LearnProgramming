package Topics.DynamicProgramming.KnapSack;

import java.util.*;
public class MinimumSubsetSumDiff {

    public static List<Integer> subsetSum(int[] arr, int target, int n){
        boolean[][] t = new boolean[n+1][target+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if(i==0){
                    t[i][j] = false;
                }
                if( j==0){
                    t[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if(arr[i-1] <= j){
                    t[i][j] = (t[i-1][j - arr[i-1]]) || (t[i-1][j]);
                }else{
                    t[i][j] = (t[i-1][j]);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int j = 0; j <= target/2; j++) {
            if(t[n][j]){
                res.add(j);
            }
        }
        return res;
    }

    public static int minSubsetSumDiff(int[] arr, int n){
        int range = 0;
        for (int i : arr) {
            range += i;
        }

        List<Integer> res = subsetSum(arr, range, arr.length);
        
        int ans = Integer.MAX_VALUE;
        for (Integer ele : res) {
            ans = Math.min(ans, range - 2*ele);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 7};
        int n = arr.length;
        System.out.println(minSubsetSumDiff(arr, n));
    }
}
