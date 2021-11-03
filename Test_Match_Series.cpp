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
        int draw = 0;
        int india = 0;
        int england = 0;
        for (int i = 0; i < 5; i++){   
            int val = 0;
            cin >> val;
            if(val == 0){
                draw++;
            }else if(val == 1){
                india++;
            }else{
                england++;
            }
        }

        if(india > england){
            cout << "INDIA" << endl;
        }else if( england > india){
            cout << "ENGLAND" << endl;
        }else{
            cout << "DRAW" << endl;
        }

        

    }

    return 0;

}