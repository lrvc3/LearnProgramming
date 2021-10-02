/*
    Problem Link: https://codeforces.com/problemset/problem/112/A
    Platform: Codeforces
    Type: A
    Problem Code: 112/A
*/
#include<bits/stdc++.h>

using namespace std;

int main(){
   
    string s1, s2;
    cin >> s1 >> s2;
    transform(s1.begin(), s1.end(), s1.begin(), ::toupper);
    transform(s2.begin(), s2.end(), s2.begin(), ::toupper);
    // sort(s1.begin(), s1.end());
    // sort(s2.begin(), s2.end());
    // cout << s1 << endl;
    if(s1.compare(s2) < 0){
        cout << -1 << endl;
    }else if(s1.compare(s2) == 0){
        cout << 0 << endl;
    }else{
        cout << 1 << endl;
    }
    return 0;
}