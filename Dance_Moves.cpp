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

    ull t;
    cin >> t;
    while(t--){
        int c, d;
        cin >> c >> d;
        int cnt = 0;
        // k+2, k-1

        if(c < d){
            while(c < d){
                c += 2;
                cnt++;
            }

            if(c > d){
                while(c != d){
                    c -=1;
                    cnt++;
                }
            }
        }else if (c > d){
            while(c!=d){
                c -=1;
                cnt++;
            }
        }else{
            cnt = 0;
        }
        cout << cnt << endl;
    }

    return 0;

}