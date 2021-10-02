/*
    Problem Link: https://practice.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1/?category[]=Recursion&category[]=Recursion&page=1&sortBy=submissions&query=category[]Recursionpage1sortBysubmissionscategory[]Recursion
    Topic: Recursion
    Solution Video Link: https://youtu.be/l45md3RYX7c
    Time Complexity:
    Space Complexity:  
*/

#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int

void solve(int n, int s, int d, int h){
	if(n == 1){
		cout << "move disk " << n << " from rod " << s << " to rod " << d;
		cout << endl;
		return;
	}

	solve(n-1, s, h, d);
	cout << "move disk " << n << " from rod " << s << " to rod " << d;
	cout << endl;
	solve(n-1, h, d, s);
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
    	int n;
    	cin >> n;
    	int s = 1;
    	int h = 2;
    	int d = 3;
    	solve(n, s, d, h);

    }

    return 0;

}