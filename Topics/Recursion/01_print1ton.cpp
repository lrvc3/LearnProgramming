/*


*/

#include<bits/stdc++.h>
using namespace std;

// Induction BaseCond Hypothesis
//  Tree, LinkedList

// Step 1: Hypothesis:
// print(n) - print numbers from 1 to n

// print(7) - 1 2 3 4 5 6 7
// print(6) - 1 2 3 4 5 6 

// Step 2: Basic Condition:
// n == 1 return 1;


// Step 3: Induction

// we know print(n) will print 1 to n numbers
// print(n-1) will print 1 to n - 1 numbers - how will i get n here

// we simply print it


void printNNumbers(int n){

	// Base condition
	if(n == 1){
		cout << 1 << " ";
		return;
	}

	// Hypothesis
	printNNumbers(n-1);

	// Induction
	cout << n << " ";

}


int main(){

#ifndef ONLINE_JUDGE
    // for getting input from input.txt
    freopen("input.txt", "r", stdin);
    // for writing output to output.txt
    freopen("output.txt", "w", stdout);
#endif

    int n;
    cin >> n;
    printNNumbers(n);
    return 0;

}