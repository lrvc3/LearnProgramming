/*
    Contest Link: https://www.codechef.com/SEPT21C
    Problem Link: https://www.codechef.com/SEPT21C/problems/AIRLINE
    Platform: Codechef

*/

#include<bits/stdc++.h>
using namespace std;

int main(){

    long long int t;
    cin >> t;
    while (t--){
        int a, b, c, d, e;
        cin >> a >> b >> c >> d >> e;

        int min1 = min(a, b);
        int minElemnt = min(min1, c);
        int sum = a + b + c;
        if(minElemnt <= e && ((sum - minElemnt)  <= d)){
            cout << "YES" << endl;
        }else{
            cout << "NO" << endl;
        }
    }

    return 0;
}