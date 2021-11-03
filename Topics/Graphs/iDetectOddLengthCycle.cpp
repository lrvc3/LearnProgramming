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
/*
	Color the graph using 2 colors alternative such that no two
	adjacent nodes are of the same color - bipartite graph

	So if we are not able to do that then its - odd length

*/


int adj[1000005];
int col[1000005]; // -> make sure to make it -1 at every index
bool checkBipartite(int node, int color) {
	col[node] = color;

	for(auto it : adj[node]) {
		// check for unvisited
		if(col[it] == -1) {
			if(checkBipartite(it, !color)) {
				return true;
			}
		}
		// when it comes here it means the col[it] is marked
		// as 1 or 0 which means it has been visited previously
		// hence we check if the adjacent has same color or not
		else if(col[it] != color) {
			return true;
		}
	}
	return false;
}


bool checkBipartiteBFS(int node, int color) {
	col[node] = color;
	queue<pair<int,int>> q;
	q.push({node, color});

	while(!q.empty()) {
		int node = q.front().first;
		int color = q.front().second;

		for(auto it : adj[node]) {
			if(vis[it] == -1) {
				q.push({it, !color});
				col[it] = !color;
			}
			else if(col[it] == color) {
				return false;
			}
		}
	}
	return false;
}

int main(){
#ifndef ONLINE_JUDGE
    // for getting input from input.txt
    freopen("input.txt", "r", stdin);
    // for writing output to output.txt
    freopen("output.txt", "w", stdout);
#endif

	memset(color, color+n, -1);

    return 0;

}