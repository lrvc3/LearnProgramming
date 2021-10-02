#include<bits/stdc++.h>
using namespace std;


int solve(vector<pair<long long, int>> &v, int totalTime, int remainingTime, long long points, int idx, int n, vector<int> &ansVec){

    int a, b, xQuestions;
    if(idx == n){
        ansVec.push_back(points);
        // cout << points << endl;
        return points;
    }

    // considering
    // if((v.at(idx).second * 20) <= remainingTime){
    //     remainingTime = remainingTime - (v.at(idx).second * xQuestions);
    //     points = points + v.at(idx).first * xQuestions;
    //     a = solve(v, totalTime, remainingTime, points, idx+1, n);
    // }else{
        xQuestions = remainingTime/v.at(idx).second;
        xQuestions = xQuestions < 20 ? xQuestions: 20;
        remainingTime = remainingTime - (v.at(idx).second * xQuestions);
        points = points + v.at(idx).first * xQuestions;
        a = solve(v, totalTime, remainingTime, points, idx+1, n, ansVec);
    // }

    // not considering
    remainingTime = remainingTime + (v.at(idx).second * 20);
    points = points -  v.at(idx).first * xQuestions;
    b = solve(v, totalTime, remainingTime, points, idx+1, n, ansVec);

    // int mz = a + b;
    return a + b;
}

int main(){
    int t = 0;
    cin >> t;
    while(t--){
        int total = 240;
        int ans = 0;
        int a, b, c;
        cin >> a >> b >> c;
        long long x, y, z;
        cin >> x >> y >> z;
        vector<pair<long long, int>> v;
        v.push_back(make_pair(x, a));
        v.push_back(make_pair(y, b));
        v.push_back(make_pair(z, c));
        vector<int> ansVec;
        ans = solve(v, total, 240, 0, 0, 3, ansVec);
        sort(ansVec.begin(), ansVec.end());

        cout << ansVec.at(ansVec.size()-1) << endl;
        


    }
    return 0;
}