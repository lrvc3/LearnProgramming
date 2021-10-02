#include<bits/stdc++.h>

using namespace std;

int main(){

    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        vector<long int> vec;
        int maxElement = 0;
        for (int i = 0; i < n; i++)
        {
            int val = 0;
            cin >> val;
            if(maxElement < val){
                maxElement = val;
            }
        }
        // *max_element(vec.begin(), vec.end());
        long long ans = (pow(10,5) - maxElement) + (pow(10,5) - maxElement + 1);
        cout << ans << endl;
    }
    return 0;
}