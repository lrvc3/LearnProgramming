package Topics.DynamicProgramming.LongestIncreasingSubSequence;
import java.util.*;

public class LargestDivisbleSubset_one {

    public static List<Integer> largestDivisibleSubset(int[] arr) {
        int[] dp = new int[arr.length];
        int[] hash = new int[arr.length];
        int maxi = 1;
        Arrays.fill(dp, 1);
        Arrays.sort(arr);
        int lastNode = 0;
        for(int i = 0; i < arr.length; i++){
            hash[i] = i;
            for(int prev = 0; prev < i; prev++){
                if(arr[i] % arr[prev] == 0 && 
                  1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if(dp[i] > maxi){
                maxi = dp[i];
                lastNode = i;
            }
        }
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(arr[lastNode]);
        while(hash[lastNode] != lastNode){
            lastNode = hash[lastNode];
            lis.add(arr[lastNode]);
        }
        Collections.reverse(lis);
        return lis;
    }


    public static void main(String[] args) {
        
    }
}
