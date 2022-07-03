#include<bits/stdc++.h>
using namespace std;

int main(){

    string s;
    int n;
    cin  >> n;
    cin >> s;
    if(s.at(n-1) == 'o'){
        cout << "Yes" << endl;
    }else{
        cout << "No" << endl;
    }

    return 0;
}