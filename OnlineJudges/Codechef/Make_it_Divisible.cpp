#include<bits/stdc++.h>
using namespace std;

int main(){
    int t = 0;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        vector<int> vec(n, 3);
        if(n%3 == 0){
            vec[n-1] = 1;
            vec[n-2] = 2;
        }
        for (int i = 0; i < n; i++)
        {
            cout << vec[i];
        }
        cout << endl;
    }
    return 0;
}