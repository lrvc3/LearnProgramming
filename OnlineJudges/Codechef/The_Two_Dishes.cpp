#include<bits/stdc++.h>

using namespace std;

int main(){

    int t;
    cin >> t;
    while(t--){
        long long int n, s;
        cin >> n >> s;
        long long t1 = 0;
        long long t2 = 0;
        
        if( n == s){
            cout << n << endl;
        }else if(n < s){
            t1 = n;
            t2 = s - t1;
            cout << abs(t1-t2) << endl;
        }else{
            t1 = s;
            cout << s << endl;
        }


    }
}