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


int visited[10005];
vector<int> adjList[10005];

void bfs(int node){
	visited[node] = 1;
	queue<int> q;
	q.push(node);

	while(!q.empty()){
		int node = q.front();
		q.pop();
		cout << node << " ";

		for(auto it: adjList[node]){
			if(!visited[it]){
				bfs(it);
				q.push(it);
			}
		}		
	}
}


void bfsSolve(){
	int n, m;
	cin >> n >> m;

	for (int i = 0; i < n; ++i)
	{
		int u, v;
		cin >> u >> v;
		adjList[u].push_back(v);
		adjList[v].push_back(u);
	}


	for (int i = 0; i <n; ++i)
	{
		if(!visited[i]){
			bfs(i);
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

    ull t;
    cin >> t;
    while(t--){


    }

    return 0;

}