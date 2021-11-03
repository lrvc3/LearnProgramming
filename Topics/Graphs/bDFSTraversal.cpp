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

vector<int> adj[100005];
int visited[100005];

void dfs(int node){
	// Printing the traversal
	cout << node << " ";
	visited[node] = 1;


	// Traversing the adjacent node
	for(auto node: adj[node]){
		if(!visited[node]){
			dfs(node);
		}
	}
}

void dfsSolve(){
	int n, m;
	cin >> n >> m;

	for (int i = 0; i < n; ++i)
	{
		int u, v;
		cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}


	for (int i = 0; i <n; ++i)
	{
		if(!visited[i]){
			dfs(i);
		}
	}

}


int main(){
#ifndef ONLINE_JUDGE
    // for getting input from input.txt
    freopen("input.txt", "r", stdin);
    // for writing output to output.txt
    freopen("output.txt", "w", stdout);
#endif

    dfsSolve();


    return 0;

}