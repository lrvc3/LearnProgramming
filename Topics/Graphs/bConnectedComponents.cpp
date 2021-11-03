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
int count = 0;



void dfs(int node, int components[]){
    // Printing the traversal
    cout << node << " ";
    visited[node] = 1;
    components[node] = count;


    // Traversing the adjacent node
    for(auto node: adj[node]){
        if(!visited[node]){
            dfs(node, components);
        }
    }
}


void findConnectComponents(){
    int n, m;
    cin >> n >> m;
    int components[n];
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
            count++;
            dfs(i, components);
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

    findConnectComponents();
    cout << count << endl;

    for(int it: components){
        cout << it << " ";
    }
    cout << endl;


    return 0;

}