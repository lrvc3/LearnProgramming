/*
    Problem Link: https://www.lintcode.com/problem/787/
    Topic: Graphs - BFS
    Solution Video Link:
    Time Complexity:
    Space Complexity:  
*/

#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int


bool hasPath(vector<vector<int>> &maze, vector<int> &start, vector<int> &destination){

	int n = maze.size();
	int m = maze[0].size();

	queue<pair<int, int>> q;
	q.push({start[0], start[1]});

	int vis[n][m];
	memset(vis, 0, sizeof vis);

	vis[start[0]][start[1]] = 1;

	while(!q.empty()){

		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		if(x == destination[0] && y == destination[1]) 
			return true;


		int dx[] = {-1, 0, 1, 0};
		int dy[] = {0, 1, 0, -1};

		for(int ind = 0; ind < 4; ind++){
			int newX = x;
			int newY = y;

			while(newX >= 0 && newX < n && newY >= 0 && newY < n && maze[newX][newY] == 0){
				newX += dx[ind];
				newY += dy[ind];
			}
			newX -= dx[ind];
			newY -= dy[ind];

			if(!vis[newX][newY]){
				vis[newX][newY] = 1;
				q.push({newX, newY});
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

    return 0;

}