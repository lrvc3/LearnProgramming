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
Visited is used to keep track of the node which is visited
PathVisited  is used to keep track of the nodes visited in the 
current Path

if both visited and pathvisited is true then cycle
if visited is true and pathvisited is false, it means it is not
been visited in the current path that is going on
*/

int vis[1000005], pathVis[1000005];

bool dfsCycleDG(int node) {
	vis[node] = 1;
	pathVis[node] = 1;

	for(auto it : adj[node]) {
		if(vis[it] == false) {
			if(dfsCycleDG(it) == true) {
				return true;
			}
		}
		else if(vis[it] == 1 && pathVis[it] == 1) {
			return true;
		}
	}
	// this is the place where we unmarked the pathVisited
	pathVis[node] = 0;
	return false;
}
void dfsCycleChecker() {
	bool fl = false;
	for(int i = 1;i<=n;i++) {
		if(vis[i] == 0) {
			if(dfsCycleDG(i) == true) {
				fl = true;
				break;
			}
		}
	}
	if(fl == true) cout << "cycle";
	else cout << "no cycle";
}


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