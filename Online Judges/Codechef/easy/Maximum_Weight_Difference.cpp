// #include<bits/stdc++.h>
// using namespace std;

// vector<long int> w;
// void findMinElementsofSize(long int k, long int sum){
//     vector<long int> minElements;
//     long int newSum = 0;
//     while(k--){
//         int minElementIndex = min_element(w.begin(),w.end()) - w.begin();
//         int minElement = *min_element(w.begin(), w.end());
//         minElements.push_back(minElement);
//         w.erase(w.begin()+minElementIndex);
//     }
//     newSum = accumulate(minElements.begin(), minElements.end(), 0);
//     cout <<  abs(newSum - (sum - newSum)) ;

// }

// int main(){

//     long int t;
//     cin >> t;
//     while(t--){
//         long int N, K, sum = 0;
//         cin >>N>>K;
    
//         for (int i = 0; i < N; i++)
//         {
//             long int val;
//             cin >> val;
//             w.push_back(val);
//             sum = sum + val;
//         }
//         long int mid = N / 2;
//         if( K > mid){
//             K = N - K;
//         }
//         sort(w.begin(), w.end());
//         findMinElementsofSize(K, sum);

        
//     }

//     return 0;
// }


#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);
    
    int t, n, k, d, p;
    cin >> t;
    while(t--) {
        cin >> n >> k;
        int w[n];
        for(int i = 0; i < n; i++) {
            cin >> w[i];
        }
        sort(w, w+n);
        d = 0;
        p = min(k, n-k);
        for(int i = 0; i < p; i++) {
            d -= w[i];
        }
        for(int i = p; i < n; i++) {
            d += w[i];
        }
        cout << d << "\n";
    }
}
