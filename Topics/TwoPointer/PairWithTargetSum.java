package Topics.TwoPointer;

import java.util.*;

public class PairWithTargetSum {

    public static int[] findPair(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int sum = nums[start] + nums[end];
            if(sum == target){
                return new int[] {start, end};
            }else if( sum > target){
                end--;
            }else{
                start++;
            }
        }
        return new int[] {0, 0};
    }

    public static void main(String[] args) {
        int [] res = findPair(new int[]{ 1, 2, 3, 4, 6}, 6);
        System.out.println(res[0] + " " + res[1]);
    }
}
