/*
    Problem Link: https://codeforces.com/problemset/problem/236/A
    Platform: Codeforces
    List of Problems: https://codeforces.com/blog/entry/82143
    
*/

#include <bits/stdc++.h>
using namespace std;

int main(){
    string s;
    cin >> s;
    int n = s.size();
    set<char> c;
    for (int i = 0; i < n; i++)
    {
        c.insert(s.at(i));
    }
    
    if(c.size() % 2 == 0){
        cout << "CHAT WITH HER!" << endl;
    }else{
        cout << "IGNORE HIM!" << endl;
    }
    return 0;
}
