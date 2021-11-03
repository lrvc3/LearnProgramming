/*
    Problem Link:
    Topic:
    Solution Video Link:
    Time Complexity:
    Space Complexity:
*/

#include <bits/stdc++.h>
using namespace std;

void storeAdjListWithWeight(int n, int m) {
	vector<pair<int, int>> adjList[n + 1];

	for (int i = 0; i < m; ++i)
	{
		int u, v, wt;
		cin >> u >> v >> wt;

		adjList[u].push_back({v, wt});
		// the next line is required only for undirected graph
		adjList[v].push_back({u, wt});
	}
}

void storeAsAdjacnecyList(int n, int m) {
	// Store at every index a vector
	// n+1 if 1 based
	// SC: N + 2E (E: Edges)
	vector<int> adjList[n + 1];

	for (int i = 0; i < m; ++i)
	{
		int u, v;
		cin >> u >> v;

		adjList[u].push_back(v);
		// the next line is required only for undirected graph
		adjList[v].push_back(u);
	}
}

void storeAsAdjacencyMatrix(int n, int m) {
	// n - no of nodes, m - no of edges
	// n+1 if 1 based
	// SC: N^2
	int adj[n + 1][n + 1];

	for (int i = 0; i < m; ++i)
	{
		int u, v;
		cin >> u >> v;

		adj[u][v] = 1;
		// the next line is required only for undirected graph
		adj[v][u] = 1;
	}
}


int main() {
#ifndef ONLINE_JUDGE
	// for getting input from input.txt
	freopen("input.txt", "r", stdin);
	// for writing output to output.txt
	freopen("output.txt", "w", stdout);
#endif
	int n, m;
	cin >> n >> m;
	storeAsAdjacencyMatrix(n, m);

	storeAsAdjacnecyList(n, m);

	return 0;

}