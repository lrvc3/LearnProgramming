
/*
    Topo sort wont work on cycles 
    so we are using the detecting cycles

    Question edges are reversed so when we create adjList
    we create from it[1] --- it[0]
    
*/

class Solution {
private:
    bool dfsCycle(int node, vector<int> &vis, vector<int> &pathVis, vector<int> adj[]){
        vis[node] = 1;
        pathVis[node] = 1;
        
        for(auto it: adj[node]){
            if(vis[it] == 0){
                if(dfsCycle(it, vis, pathVis, adj)){
                    return true;
                }
            }
            else if(pathVis[it] == 1){
                return true;
            }
        }
        
        pathVis[node] = 0;
        return false;
    }
    
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> vis(numCourses, 0);
        vector<int> pathVis(numCourses, 0);
        
        
//         Creating the adjList
        vector<int> adjList[numCourses];
        for(auto it: prerequisites){
            adjList[it[1]].push_back(it[0]);
        }
        
        
        for(int i = 0; i< numCourses; i++){
            if(!vis[i]){
                if(dfsCycle(i, vis, pathVis, adjList)){
                    return false;
                }
            }
            
        }
        return true;
        
    }
};