package Topics.TwoPointer;

/*
	Time Complexity: O(N)
	Space Complexity: O(N)

	Where N is the size of the given array.
*/

import java.util.HashMap;

public class CheckPairWithDiffK{
    public static String isPairDifferenceKMap(int[] arr, int n, int k) {

        HashMap<Integer, Boolean> isPresent = new HashMap<Integer, Boolean>();

        // Iterating through all elements of the array.
        for (int i = 0; i < n; i++) {
            // Checking if arr[i] - k is already present in the array or not.
            if (isPresent.containsKey(arr[i] - k) == true) {
                return "Yes";
            }

            // If arr[i]-K is not present in the array,
            // Mark the current element to be present in the array.
            isPresent.put(arr[i], true);
        }

        // Returning "No", if no pair found that satisfied the required condition.
        return "No";
    }


    /*
        Time Complexity: O(N)
        Space Complexity: O(1)

        Where N is the size of the given array.
    */
    public static String isPairDifferenceK(int[] arr, int n, int k) {

        // Two pointers which will point to first and second elements of the pair.
        int i = 0, j = 1;

        // We will try to find the possible pair till both pointers points to elements inside array.
        while (i < n && j < n) {

            // If element pointed by i and j are not same, and absolute difference between them is equal to then we found the required pair, and return "Yes".
            if (i != j && Math.abs(arr[i] - arr[j]) == k) {
                return "Yes";
            }

            // If absolute difference between elements pointed by i and j, is greater than k, then we increment i.
            if (Math.abs(arr[i] - arr[j]) > k) {
                i++;
            }

            else {
                // If absolute difference between elements pointed by i and j, is less than k or i is same as j, then we increment j.
                j++;
            }

        }

        // Returning "No", if no pair found that satisfied the required condition.
        return "No";
    }

    public static void main(String[] args) {
        int[] arr = new int[]{};
        int target = ;
        
    }
}
