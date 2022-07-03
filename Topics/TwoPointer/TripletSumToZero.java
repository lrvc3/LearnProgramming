package Topics.TwoPointer;

import java.util.*;

public class TripletSumToZero {

    public static void searchPair(int[] a, int target, int left, List<List<Integer>> res){
        int right = a.length - 1;
        while (left < right) {
            int currSum = a[left] + a[right];
            if (currSum == target) {
                res.add(Arrays.asList(-target, a[left], a[right]));
                left++;
                right--;
                while (left < right && a[left] == a[left - 1]) {
                    left++;
                }
                while (left < right && a[right] == a[right + 1]) {
                    right--;
                }
            }else if( target > currSum){
                left++;
            }else{
                right--;
            }
        }
        
    }

    public static List<List<Integer>> findTriplets(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            // Checking if its duplicate
            if (i== 0 || (i > 0 && arr[i] != arr[i-1])) {
                searchPair(arr, -arr[i], i+1, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = findTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2});

        for (List<Integer> list : res) {
            for (Integer list2 : list) {
                System.out.print(list2 + " ");
            }
            System.out.println(" ");
        }
    }
}
