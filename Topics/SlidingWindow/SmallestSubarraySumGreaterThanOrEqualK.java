package Topics.SlidingWindow;

public class SmallestSubarraySumGreaterThanOrEqualK {
    public static int solve(int[] arr, int S){
        int mn = Integer.MAX_VALUE;

        int i = 0, j = 0, sum = 0;
        while (j < arr.length) {
            sum += arr[j];

            while (sum >= S) {
                mn = Math.min(mn, j-i+1);
                sum -= arr[i];
                i++;
            }
            j++;
        }
        return mn;
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 8};
        int S = 7;
        System.out.println(solve(arr, S));
    }
}
