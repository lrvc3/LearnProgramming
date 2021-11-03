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

public class cMinDeletionsToMakeCharFrequencyUnique {

	public int minDeletions(String s) {
        int[] arr = new int[26];
        int res = 0;
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        Set<Integer> usedFrequency = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            int freq = arr[i];
            while (freq > 0) {
                if (!usedFrequency.contains(freq)) {
                    usedFrequency.add(freq);
                    break;
                } 
                freq--;
                res++;
            }
        }
        return res;        
    }
	
	
	public static void main (String[] args) {

		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		// //taking total testcases
		// int T=sc.nextInt();
		// while(T-->0)
		// {
		    
		// }
		
	}
}