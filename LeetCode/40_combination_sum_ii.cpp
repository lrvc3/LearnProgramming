/*

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

*/

#include<bits/stdc++.h>

using namespace std;

int target = 5;
void combinationSum(int index, vector<int> &candidates, vector<int> &ds, int n, int sum, vector<vector<int>> &ans ) {
    if(index == n){
        if(sum  == 0){
            // ans.push_back(ds);
            // Printing
            for(auto it : ds){
                cout << it << " ";
            }
            cout << endl;
        }
        return;
    }

    if(candidates.at(index) <= sum){
        sum -= candidates.at(index);
        ds.push_back(candidates.at(index));
        combinationSum(index+1, candidates, ds, n, sum, ans);
        sum += candidates.at(index);
        ds.pop_back();
    }

    combinationSum(index+1, candidates, ds, n, sum, ans);
}

int main(){

    vector<int> candidates = {2,5,2,1,2};
    vector<int> ds;
    vector<vector<int>> ans;
    int size = candidates.size();
    combinationSum(0, candidates, ds, size, target, ans);
    // simply return the ans
    // return ans;
    return 0;
}
