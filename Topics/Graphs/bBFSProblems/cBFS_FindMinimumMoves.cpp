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


int findMinimumMoves(int start, int end, int arr[], int n) {
	int visited[end + 1];
	visited[start] = 1;

	queue<pair<int, int>> q;
	q.push(make_pair(start, 0));


	while (!q.empty()) {
		int node = q.front().first;
		int steps = q.front().second;

		if (node == end) {
			return steps;
		}
		q.pop();

		for (int i = 0; i < n; i++) {
			int dest = node * arr[i];
			if (dest <= end && !visited[dest]) {
				q.push({dest, steps + 1});
				visited[dest] = 1;
			}
		}
	}

	return -1;

}


int main() {


	int start, end, n;
	cin >> start >> end >> n;

	int arr[n];
	for (int i = 0; i < n; i++) {
		int val;
		cin >> val;
		arr[i] = val;
	}

	int ans = findMinimumMoves(start, end, arr, n);
	cout << ans << endl;

	return 0;

}