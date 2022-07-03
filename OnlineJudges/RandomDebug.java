package OnlineJudges;

import java.util.*;

public class RandomDebug {
    public static int solve(int[] a) {
        if( a == null || a.length == 0){
            return 0;
        }
        if(a.length == 1){
            return 1;
        }

        Arrays.sort(a);
        int n = a.length;
        int i = 0;
        int j = 1;
        int mx = Integer.MIN_VALUE;
        while(j < n){

            while(j < n && (a[j] == a[i] + 1)){
                j++;
            }

            mx = Math.max(mx, j - i);
            i++;
            j++;
        }
        return mx;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 0};
        int ans = solve(a);
        System.out.println(ans);
    }
}
