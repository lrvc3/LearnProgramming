package Topics.DynamicProgramming.LongestIncreasingSubSequence;
import java.util.*;
public class LongestBitonicSubsequence {

    public static int longestBitonicSequence(int[] arr, int n) {
        
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        
        for(int i =  0; i < n; i++){
            for(int prev = 0 ; prev  < i; prev++){
                if(arr[prev] < arr[i] && 1 + dp1[prev] > dp1[i]){
                    dp1[i] = 1 + dp1[prev];
                }
            }
        }
        int maxi = 1;
        for(int i =  n-1; i >= 0; i--){
            for(int prev = n- 1 ; prev  > i; prev--){
                if(arr[prev] < arr[i] && 1 + dp2[prev] > dp2[i]){
                    dp2[i] = 1 + dp2[prev];
                }
            }
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 40, 5, 3, 1};
        System.out.println(longestBitonicSequence(arr, arr.length));
    }
}
