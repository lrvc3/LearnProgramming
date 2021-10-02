/*
    Problem Link: https://leetcode.com/problems/k-th-symbol-in-grammar/
    Topic: Recursion
    Solution Video Link: https://youtu.be/5P84A0YCo_Y
    Time Complexity:
    Space Complexity:  
*/

#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int


int solve(int n, int k){

	if(n == 1 && k == 1){
		return 0;
	}

	int mid = (pow(2, n-1))/2;

	if(k <= mid){
		return solve(n-1, k);
	}else{
		return !solve(n-1, k-mid);
	}

}

int main(){
#ifndef ONLINE_JUDGE
    // for getting input from input.txt
    freopen("input.txt", "r", stdin);
    // for writing output to output.txt
    freopen("output.txt", "w", stdout);
#endif

    ull t;
    cin >> t;
    while(t--){


    }

    return 0;

}