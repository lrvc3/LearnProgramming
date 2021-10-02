#include<bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin >> n;
    while(n--){
        int tyre = 0;
        cin >> tyre;
        bool flag = false;
        while(tyre > 0){
            if(tyre%4 == 0){
                tyre -= 4;
            }else{
                if(tyre%2 == 0){
                    flag = true;
                    break;
                }
            }
        }
        if(flag){
            cout << "YES" << endl;
        }else{
            cout << "NO" << endl;
        }
    }
    return 0;
}