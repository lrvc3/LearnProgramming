/*
    Topic: Recursion 
    Platform: LeetCode
    Problem Statement Link: https://leetcode.com/problems/combination-sum/

*/
#include<bits/stdc++.h>

using namespace std;

int target = 8;
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
        combinationSum(index, candidates, ds, n, sum, ans);
        sum += candidates.at(index);
        ds.pop_back();
    }

    combinationSum(index+1, candidates, ds, n, sum, ans);
}

int main(){

    vector<int> candidates = {2, 3, 5};
    vector<int> ds;
    vector<vector<int>> ans;
    combinationSum(0, candidates, ds, 3, target, ans);
    // simply return the ans
    // return ans;
    return 0;
}
