#include<bits/stdc++.h>

using namespace std;

int main(){

    int t;
    cin >> t;

    while(t--){
        int n;
        cin >> n;
        if(n%4 == 0){
            cout << "North" << endl;
        }
        if(n%4 == 1){
            cout << "East" << endl;
        }
        if(n%4 == 2){
            cout << "South" << endl;
        }
        if(n%4 == 3){
            cout << "West" << endl;
        }
    }

    return 0;
}