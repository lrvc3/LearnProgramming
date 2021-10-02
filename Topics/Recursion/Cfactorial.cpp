#include <bits/stdc++.h>
using namespace std;


int factorial(int n){

	if(n == 0)
		return 1;

	return n * factorial(n - 1);
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
    int ans = factorial(n);
    cout << ans;
	return 0;
}