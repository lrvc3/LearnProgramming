package Topics.SlidingWindow;

public class MaxsubarrayOfkSize {

    public static int solve(int[] arr, int k){
        int mx = Integer.MIN_VALUE;
        int i = 0;
        int j  = 0;
        int sum = 0;
        while (j < arr.length) {
            sum += arr[j];
            if (j-i+1 < k) {
                j++;
                continue;
            }else if (j - i + 1 == k) {
                mx = Math.max(mx, sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return mx;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1,5, 1, 3, 2};
        int k = 3;
        System.out.println(solve(arr, k));


    }
}
