/*
    Problem Link: https://codeforces.com/problemset/problem/214/A
    Platform: Codeforces
    Type: A
    Problem Code: 214/A
*/
#include<bits/stdc++.h>

using namespace std;

int main(){

    int n, m;
    cin >> n >> m;
    int count = 0;
    for (int i = 0; i < 1000; i++)
    {
        for (int j = 0; j < 1000; j++)
        {
            if((i*i + j == n ) && ( i + j * j == m )){
                count++;
            }
        }
        
    }
    
    cout << count << endl;
    return 0;
}