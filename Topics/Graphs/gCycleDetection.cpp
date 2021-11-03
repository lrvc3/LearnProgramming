/*
    Problem Link:
    Topic:
    Solution Video Link:
    Time Complexity:
    Space Complexity:
*/

// Only using visited array we wont be able to differentiate
// the return of dfs and the actual cycle, so we need to keep
// track of the parent


int visited[100005];
int adjList[100005];
bool dfs(int node, int parent) {
	visited[node] = 1;

	for (auto it : adjList[node]) {
		if (!visited[it]) {
			// the first condition says that if one call is getting a cycle
			// we need not go ahead
			if (dfs(it, node)) {
				return true;
				// While returning if the node is not the parent then its a cycle
			} else if (visited[it] && it != parent) {
				return true;
			}
		}
	}
	return false;
}




int vis[100005];

bool bfsCycle(int node) {
	queue<pair<int,int>> q;
	q.push({node, 0});
	vis[node] = 1;

	while(!q.empty()) {
		int node = q.front().first;
		int par = q.front().second;
		q.pop();

		for(auto it : adj[node]) {
			if(vis[it] == 0) {
				q.push({it, node});
				vis[it] = 1;
			}
			else if(vis[it] == true && it != par) {
				return true;
			}
		}
	}
	return false;
}
void bfsCycleChecked() {
	bool fl = false;
	for(int i = 1;i<=n;i++) {
		if(vis[i] == 0) {
			if(bfsCycle(i) == true) {
				fl = true;
				break;
			}
		}
	}
	if(fl == true) cout << "cycle";
	else cout << "no cycle";
}



#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int


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


	}

	return 0;

}