/*
    Problem Link: https://leetcode.com/problems/rotting-oranges/
    Topic: Graph - BFS 
    Solution Video Link:
    Time Complexity:
    Space Complexity:  
    Java Code: https://leetcode.com/problems/rotting-oranges/discuss/238681/Java-Clean-BFS-Solution-with-comments

*/

#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int

struct node{
	int x, y, time;
	node(int _x, int _y, int _t){
		x = _x;
		y = _y;
		time = _t;		
	}
};

int ans(vector<vector<int>> &grid){
	int cnt = 0;
	int n = grid.size();
	int m = grid[0].size();

	queue<node> q;

	// push the rotten oranges
	for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){

			if(grid[i][j] == 2){
				q.push(node(i, j, 0));
			}
			// We store the total number of organges
			if(grid[i][j] != 0){
				cnt++;
			}
		}
	}

	int dx[] = {-1, 0, 1, 0};
	int dy[] = {0, 1, 0, -1};
	int ans = 0;
	int cntOranges = 0;
	while(!q.empty()){
		int x = q.front().x;
		int y = q.front().y;
		int time = q.front().time;
		ans = max(ans, time);
		cntOranges++;
		q.pop();
		for(int ind = 0; ind < 4; ind++){
			int newX = x + dx[ind];
			int newY = y + dy[ind];

			if(newX >= 0 && newX < n && newY >=0 && newY < m && grid[newX][newY] == 1){
				grid[newX][newY] = 2;
				
				q.push(node(newX, newY, time+1));
			}
		}

	}

	if(cnt == cntOranges){
		return ans;
	}else{
		return -1;
	}

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