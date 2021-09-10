/*
    Problem Link: https://codeforces.com/problemset/problem/231/A
    Platform: Codeforces
    List of Problems: 
    Type: A
*/
#include<bits/stdc++.h>

using namespace std;

int main(){
    int n;
    cin >> n;
    int solve = 0;
    while (n--)
    {
        int p, v, t;
        cin >> p >> v >> t;
        if((p==1 && v ==1) || (p==1 && t==1) || (v==1 && t == 1)){
            solve++;
        }
    }
    cout << solve << endl;
    return 0;
}