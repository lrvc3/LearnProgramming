/*
    Problem Link: 
    Topic:
    Solution Video Link:
    Time Complexity:
    Space Complexity:  
    Difficulty: 
*/

#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int


/*
	N = 26
	ans = 5

	1..26
	we know the square will be between 1 to 26
	
	Array is not given, but we know it is sorted :P

	i * i <= N


*/
// returns index
int binarySearchSquareRoot(int arr[], int n, int target) {
	int low = 1;
	int high = n;
	int ans = 1;
	while (low <= high) {
		int mid = low + (high - low) / 2;

		if (mid * mid <= target) {
			ans = mid;
			low = mid + 1;
		} else {
			high = mid - 1;
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
	cout << binarySearchUB(arr, n, target);

	return 0;

}