#include <bits/stdc++.h>
using namespace std;

// IBH approach - we try to eventually make the input smaller
// we dont go through the entire tree
// Most of the logic depends on how we have designed the induction

void printNto1Numbers(int n){

	// Base Condition
	if(n == 1){
		cout << 1 << " ";
		return;
	}

	// induction
	cout << n << " ";

	// Hypothesis
	printNto1Numbers(n-1);

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
    printNto1Numbers(n);
	return 0;
}