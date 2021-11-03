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

public class dMinNoOfSwapsToMakePalindrome {

	private static int getNoOfSwaps(String s) {
		if (s == null || s.length() == 0) return -1;
		int totalSwaps = 0;

		if (isShuffledPalindrome(s)) {
			char[] chars = s.toCharArray();
			int p1 = 0, p2 = chars.length - 1;

			while (p2 > p1) {
				if (chars[p1] != chars[p2]) {
					int k = p2;
					while (k > p1 && chars[k] != chars[p1]) k--;

					if (k == p1) { //When no matching character found
						swap(chars, p1, p1 + 1);
						totalSwaps++;

					} else { //When Matching character found swap until K reaches p2 position
						while (k < p2) {
							swap(chars, k, k + 1);
							totalSwaps++;
							k++;
						}
						p1++; p2--;
					}
				} else {
					p1++; p2--; //When the characters are equal move on
				}
			}
			return totalSwaps;
		} else return -1;
	}

	private static void swap(char[] chars, int k, int i) {
		char temp = chars[k];
		chars[k] = chars[i];
		chars[i] = temp;
	}

	private static boolean isShuffledPalindrome(String s) {
		int [] occurrence = new int[26];
		int oddCount = 0;

		for (int i = 0; i < s.length(); i++) occurrence[s.charAt(i) - 'a']++;
		for (int value : occurrence) if (value % 2 != 0) oddCount++;
		return oddCount <= 1;
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
		while (T-- > 0) {
			String s = sc.next();
			int cnt = getNoOfSwaps(s);
			System.out.print(cnt);
			System.out.println("");
		}

	}
}