/*
    Problem Link: 
    Topic:
    Solution Video Link:
    Time Complexity:
    Space Complexity:  
    Difficulty: 
*/

#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int

bool cmp (pair<long, long> &a, pair<long, long> &b){
    return a.second < b.second;
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
        int n;
        cin >> n;
        vector<pair<long, long>> vec;
        for (int i = 0; i < n; i++){
            long ans = 0;
            cin >> ans;
            vec.push_back(make_pair(ans, i));
        }
        
        sort(vec.begin(), vec.end());

        long long k = 0;

        for (int i = 0; i < n; i++){
            if(vec[i].first > k){
                vec[i].first = k;
                k++;
            }else if(vec[i].first == k){
                vec[i].first = k;
            }
        }
        
        sort(vec.begin(), vec.end(), cmp);
        for (int i = 0; i < n; i++){
            cout << vec[i].first << " ";
        }
        cout << endl;



    }

    return 0;

}