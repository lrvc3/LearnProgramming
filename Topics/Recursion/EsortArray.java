import java.io.*;
import java.util.*;

public class EsortArray {

	static List<Integer> put(List<Integer> nums, int lastVal){
		if(nums.size() == 0 || lastVal <= nums.get(nums.size()-1) ){
			nums.add(lastVal);
			return nums;
		}

		int val = nums.get(nums.size()-1);
		nums.remove(nums.size()-1);
		nums = put(nums, lastVal);
		nums.add(val);
		return nums;

	}

	static List<Integer> sortArray(List<Integer> nums) {
		if(nums.size() == 1){
			return nums;
		}

		int lastNum = nums.get(nums.size()-1);
		nums.remove(nums.size()-1);
		nums = sortArray(nums);
		return nums = put(nums, lastNum);

	}

	public static void main (String[] args) {

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}

		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);

		//taking total testcases
		int T = sc.nextInt();
		while (T --> 0) {
			int n = sc.nextInt();

			List<Integer> nums = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int val = sc.nextInt();
				nums.add(val);
			}

			List<Integer> ans = sortArray(nums);

			for (int element : ans) {
				System.out.print(element + " ");
			}
		}

	}
}