package Topics.TwoPointer;

import java.util.*;

public class PrintPairsWithTargetSum {
    public static int[][] pairSum(int[] arr, int a) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        List<Integer[]> p = new ArrayList<>();
        int i = 0;
        while (left < right) { 
            int target = arr[left] + arr[right];
            
            if (target == a){
                
                if ( arr[left] == arr[right]){
                	int counts = right - left;
                    int combination = (counts * (counts + 1))/2;
                    int val = arr[left];
                    for (int q = 0; q < combination; q++){
                        p.add(new Integer[] { val, val });
                        left++;
                        right--;
                    }
                } else {
                	int aP = 1;
                    int bP = 1;
                    while(arr[left] == arr[left+1]){
                        left++;
                        aP++;
                    }
                    while(arr[right] == arr[right-1]){
                        right--;
                        bP++;
                    }
                    int combination = aP * bP;
                    for(int p1 = 0; p1 < combination; p1++){
                        p.add(new Integer[]{arr[left], arr[right]});
                    }
                    left++;
                    right--;
                }
            } else if (target < a){
                left++;
            } else {
                right--;
            }
        }
        int[][] ans = new int[p.size()][2];
        
        for (Integer[] pair: p){
            ans[i++] = new int[]{pair[0], pair[1]};
        }
        return ans;
    }
    
    
	public static void main(String[] args) {
	    int[] arr = new int[]{1, 1, 4, 4, 5, 5, 5, 6, 6, 11};
	    int target = 10;
	    pairSum(arr, target);
	}
}
