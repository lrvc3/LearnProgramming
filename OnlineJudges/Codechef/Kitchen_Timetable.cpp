/*
    Problem: https://www.codechef.com/SDPCB21/problems/KTTABLE
    Platform: Codechef
    Contest: SDPCB21
*/

#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;
    cin >> t;

    while(t--){
        long int n;
        cin >>n;
        vector<long int> vecCT(n+1, 0);
        int students = 0;
        for (int i = 1; i <= n; i++)
        {
            long long int val = 0;
            cin >> val;
            vecCT[i] = val;
        }
        for (int i = 1; i <= n; i++)
        {
            long long int val = 0;
            cin >> val;
            if(val <= vecCT[i] - vecCT[i-1]){
                students++;
            }
            
        }
        cout << students << endl;
        
    }

    return 0;
}

