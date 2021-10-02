import java.io.*;
import java.util.*;

public class FsortStack {

	static void sortedInsert(Stack<Integer> s, int x) {
		// Base case: Either stack is empty or newly
		// inserted item is greater than top (more than all
		// existing)
		if (s.isEmpty() || x <= s.peek()) {
			s.push(x);
			return;
		}

		
		int temp = s.pop();
		sortedInsert(s, x);

		// Put back the top item removed earlier
		s.push(temp);
	}

	// Method to sort stack
	static void sortStack(Stack<Integer> s) {
		// If stack is not empty
		if (!s.isEmpty()) {
			// Remove the top item
			int x = s.pop();

			// Sort remaining stack
			sortStack(s);

			// Push the top item back in sorted stack
			sortedInsert(s, x);
		}
	}

	// Utility Method to print contents of stack
	static void printStack(Stack<Integer> s) {
		ListIterator<Integer> lt = s.listIterator();

		// forwarding
		while (lt.hasNext())
			lt.next();

		// printing from top to bottom
		while (lt.hasPrevious())
			System.out.print(lt.previous() + " ");
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

			int sizeOfStack = 0;
			sizeOfStack = sc.nextInt();
			Stack<Integer> s = new Stack<>();
			for (int i = 0; i < sizeOfStack ; i++) {
				int val = sc.nextInt();
				s.push(val);
			}

			sortStack(s);
			printStack(s);

		}

	}
}