/*
    Problem Link: 
    Topic:
    Solution Video Link:
    Time Complexity:
    Space Complexity:  
*/
/*
	Topo sort works 
		iff directed graph
		and no graph

*/
int vis[100005];
void topoSortHelper(int node, stack<int> &st) {
	vis[node] = 1;
	for(auto it : adj[node]) {
		if(!vis[it]) {
			topoSortHelper(it, st);
		}
	}
	st.push(node);
}

void topoSort() {
	stack<int> st;
	// iterating through all the nodes
	for(int i = 1;i<=n;i++) {
		if(vis[i] == false) {
			topoSortHelper(i, st);
		}
	}

	while(!st.empty()) {
		cout << st.top() << " ";
		st.pop();
	}
}

// Kahns Algorithm
void topoSort() {
	vector<int> indegree(n, 0);

	// (1, 2)
	// adj[1].pb(2)
	for(int i = 0;i<n;i++) {
		for(auto it : adj[i]) {
			// i ---> it
			indegree[it]++;
		}
	}
	queue<int> q;
	for(int i = 0;i<n;i++) {
		if(indegree[i] == 0) {
			q.push(i);
		}
	}
	while(!q.empty()) {
		cout << q.front();
		int node = q.front();
		q.pop();

		for(auto it : adj[node]) {
			// node -> it
			indegree[it]--;
			if(indegree[it] == 0) q.push(it);
		}
	}
}

#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int


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