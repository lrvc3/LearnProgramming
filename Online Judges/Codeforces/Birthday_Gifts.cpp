#include<bits/stdc++.h>
using namespace std;

int main(){
    int t;
    cin >> t;
    while(t--){
        long long n, k;
        cin >> n >> k;
        vector<int> prices(n,0);
        for (int i = 0; i < n; i++)
        {
            int val;
            cin >> val;
            prices[i] = val;
        }
        sort(prices.begin(), prices.end());
        // 5 4 3 2 1
        // 3 3 1
        int chef = 0;
        int chefBro = 0;
        int i;
        for(i = n-1; i >=0 ; i-=2){
            if(k == 0){
                break;
            }
            chef += prices.at(i);
            chefBro += prices.at(i-1);
            k--;
        }  
        chefBro += a[i];

        cout << max(chef, chefBro) << endl;
        
    }
    return 0;
}