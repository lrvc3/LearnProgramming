/*
    Problem Link:
    Topic:
    Solution Video Link:
    Time Complexity:
    Space Complexity:
*/

#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int


void reverseArray(int i, int &arr) {
	if ( i > arr.size() / 2) {
		return;
	}

	int temp = arr[i];
	arr[i] = arr[n - i - 1];
	arr[n - i - 1] = temp;
	reverseArray(i + 1, arr);
}


void printArray(int &arr) {

	for (int i = 0; i < arr.size(); ++i)
	{
		cout << arr[i] << " ";
	}
	cout << endl;
}

int main() {
#ifndef ONLINE_JUDGE
	// for getting input from input.txt
	freopen("input.txt", "r", stdin);
	// for writing output to output.txt
	freopen("output.txt", "w", stdout);
#endif

	ull t;
	cin >> t;
	while (t--) {

		int no;
		cin >> no;
		int arr[no];
		for (int i = 0; i < no; ++i)
		{
			int val;
			cin >> val;
			arr[i] = val;
		}

		reverseArray(0, arr);
		printArray(arr);

	}

	return 0;

}