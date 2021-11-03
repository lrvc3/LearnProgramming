class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> vis(numCourses, 0);
        vector<int> pathVis(numCourses, 0);
        int n = numCourses;
        vector<int> indegree(n, 0);
        vector<int> ans;
//         Creating the adjList
        vector<int> adjList[numCourses];
        for(auto it: prerequisites){
            adjList[it[1]].push_back(it[0]);
            // (1, 2)
            // adj[1].pb(2)
            indegree[it[0]]++;
        }
        
        
        queue<int> q;
        for(int i = 0;i<n;i++) {
            if(indegree[i] == 0) {
                q.push(i);
            }
        }
        int count = 0;
        while(!q.empty()) {
            count++;
            ans.push_back(q.front());
            int node = q.front();
            q.pop();

            for(auto it : adjList[node]) {
                // node -> it
                indegree[it]--;
                if(indegree[it] == 0) q.push(it);
            }
        }
        
        if(count != n) {
            vector<int> dummy;
            return dummy;
        }
        else
            return ans;
        
    }
};