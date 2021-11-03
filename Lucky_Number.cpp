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
        bool f = false;
        for (int i = 0; i < 3; i++){
            int val = 0;
            cin >> val;
            if(val == 7){
                f = true;
            }
        }
        if(f == true){
            cout << "YES" << endl;
        }else{
            cout << "NO" << endl;
        }

    }

    return 0;

}