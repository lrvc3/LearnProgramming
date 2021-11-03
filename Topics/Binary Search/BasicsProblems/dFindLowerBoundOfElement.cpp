/*
    Problem Link:
    Topic:
    Solution Video Link:
    Time Complexity:
    Space Complexity:
    Difficulty:
*/

/*
	LowerBound >= target
	Example:
			0 1 2 3 4 5
	arr[] = 1 3 5 7 9 10
	lb = 7, ans = 7 
	lb = 8, ans = 9
	target = 11, ans = -1

*/

#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int

// returns index
int binarySearchLB(int arr[], int n, int target) {
	int low = 0;
	int high = n - 1;
	int ans = -1;
	while (low <= high) {
		int mid = low + (high - low) / 2;

		if (arr[mid] >= target) {
			ans = mid;
			// this will help in breaking the loop
			high = mid - 1;
		} else {
			low = mid + 1;
		}
	}
	return ans;
}

int main() {
#ifndef ONLINE_JUDGE
	// for getting input from input.txt
	freopen("input.txt", "r", stdin);
	// for writing output to output.txt
	freopen("output.txt", "w", stdout);
#endif

	int n;
	cin >> n;
	int arr[n];
	for (int i = 0; i < n; ++i)
	{
		cin >> arr[i];
	}
	int target;
	cin >> target;
	cout << binarySearchLB(arr, n, target);

	return 0;

}