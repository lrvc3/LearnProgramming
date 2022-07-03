/*
    Contest Link: https://www.codechef.com/SEPT21C
    Problem Link: https://www.codechef.com/SEPT21C/problems/TRAVELPS
    Platform: Codechef

*/


#include<bits/stdc++.h>

using namespace std;

int main(){
    int t;
    cin >> t;
    while(t--){
        // 0 - district
        // 1 - state
        int n, district, state;
        cin >> n >> district >> state;

        string s;
        cin >> s;
        int countZero = 0, countOne = 0;
        for (int i = 0; i < s.size(); i++)
        {
            if(s.at(i) == '0'){
                countZero++;
            }else{
                countOne++;
            }
        }
        long long int ans = (countOne * state) + (countZero * district);
        cout << ans << endl;
        

    }
    return 0;
}