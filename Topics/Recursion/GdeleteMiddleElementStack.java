import java.io.*;
import java.util.*;

public class GdeleteMiddleElementStack {

	static Stack<Integer> deleteMiddleElement(Stack<Integer> s, int target){

		if(target == 1){
			s.pop();
			return s;			
		}

		int val = s.peek();
		s.pop();
		deleteMiddleElement(s, target - 1);
		s.push(val);
		return s;
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
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int T=sc.nextInt();
		while(T-->0)
		{
		 	int size = sc.nextInt();
		 	Stack<Integer> st = new Stack();

		 	for (int i = 0; i < size; i++) {
		 		int val = sc.nextInt();
		 		st.push(val);
		 	}

		 	int target = (size/2) + 1;
		 	deleteMiddleElement(st, target);
		 	printStack(st);
		}
		
	}
}