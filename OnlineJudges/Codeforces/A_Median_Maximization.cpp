#include<bits/stdc++.h>

using namespace std;

int main(){

    long int t;
    cin >> t;

    while (t--){
        long long int n, s;
        cin >> n, s;

        if(n == 1){
            cout << s << endl;
        }else if(s == 1){
            cout << 0;
        }else
            {
            int ans = 0;
            if(n % 2 == 0){
                ans = s/((n/2) +1 );
            }else{
                // not sure
            }
            cout << ans << endl;
        }
    }
}
