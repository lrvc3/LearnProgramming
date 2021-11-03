/*
    Problem Link:
    Topic:
    Solution Video Link:
    Time Complexity:
    Space Complexity:
    Difficulty:
*/

import java.io.*;
import java.util.*;

public class fLargestKsuchthatbothKandNegativeKexistinarray {

	// Sorting - nlog n
	// forloop - n
	// while loop - n
	// nlogn
	public static int step(Integer[] input) {
		if (input.length == 0 || input == null)
			return 0;

		Arrays.sort(input);
		Map<Integer, Integer> m = new HashMap<>();
		for (int val : input) {
			if (m.containsKey(val)) {
				m.put(val, m.get(val) + 1);
			} else {
				m.put(val, 1);
			}
		}
		int i = 0;
		int ans = 0;
		while (input.length > 0) {
			int val = input[i];

			if (val < 0) {
				if (m.containsKey(val * -1)) {
					ans = val * (-1);
					break;
				}
			} else {
				ans = 0;
				break;
			}
			i++;
			if (i == input.length - 1) {
				break;
			}
		}
		return ans;
	}

	// Time Complexity O(n)
	public static int largestNumWithNegPair(Integer[] input) {
		HashSet<Integer> set = new HashSet<>();
		int curMax = 0;
		for (int a : input) {
			// if the negated counter part is already existing, consider the number for
			// largestNum selection.
			if (set.contains(a * -1))
				curMax = Math.max(curMax, Math.abs(a));
			else
				// keep track of the numbers read so far.
				set.add(a);
		}
		return curMax;
	}

	public static void main(String[] args) {

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}

		// taking input using Scanner class
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while (t-- > 0) {
			int n = 0;
			n = sc.nextInt();
			Integer[] input = new Integer[n];
			for (int i = 0; i < n; i++) {
				input[i] = sc.nextInt();
			}
			// System.out.println(step(input));
			System.out.println(largestNumWithNegPair(input));

		}

		// System.out.println(step(new Integer[]{3, 2, -2, 5, -3}));
		// System.out.println(step(new Integer[]{1, 2, 3, -4}));
		// System.out.println(step(new Integer[] { -41, 3, 2, 5, 41}));
		// System.out.println(step(new Integer[] { -1, -1}));

	}
}