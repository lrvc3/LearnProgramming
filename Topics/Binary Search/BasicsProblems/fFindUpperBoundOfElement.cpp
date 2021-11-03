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
	ub: first greater than target
	ans is index
	ind =   0 1 2 3 4 5 6
	arr[] = 1 3 4 6 6 7 9
	target = 6, ans = 5
	target = 4, ans = 3
	target = 5, ans = 3
	target = 9, ans = 7
	target = 10, ans = 7


	6
	1 3 5 7 8 10
	6

*/
// returns index
int binarySearchUB(int arr[], int n, int target) {
	int low = 0;
	int high = n - 1;
	int ans = -1;
	while (low <= high) {
		int mid = low + (high - low) / 2;

		if (arr[mid] <= target) {
			low = mid + 1;
		} else {
			ans = mid;
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
	int res = binarySearchUB(arr, n, target);

	if(res > -1){
		cout << arr[res] << endl;
	}else{
		cout << res;
	}

	return 0;

}