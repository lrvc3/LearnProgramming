#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;
    cin >> t;

    while(t--){
        long long n, s, x = 0;
        cin >> n >> s;

        long long sum = (n*(n+1))/ 2;
        int ans = 0;
        x = sum - s ;
        if(x >= 1 && x<=n){
            cout << x << endl;
        }else{
            cout << "-1" << endl;
        }

    }

    return 0;
}