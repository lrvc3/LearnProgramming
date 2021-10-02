import java.io.*;
import java.util.*;

public class Cfactorial {
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
		while (T-- > 0) {
			int n = sc.nextInt();

			Solution sol = new Solution();
			int ans = sol.fact(n);
			System.out.println(ans);
		}

	}
}

class Solution {
	public int fact(int n) {

		if ( n == 0 ) {
			return 1;
		}

		return n * fact(n - 1);
	}
}