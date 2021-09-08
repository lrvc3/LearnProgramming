#include<bits/stdc++.h>

using namespace std;

int main(){

    int t;
    cin >> t;
    while(t--){
        string J;
        cin >> J;

        string S;
        cin >> S;

        set<char> jewels;
        long int count = 0;
        // map<char, int> hm;
        for (int i = 0; i < J.length(); i++)
        {
            // hm[J[i]] += 1;
            jewels.insert(J[i]);
        }
        for (int i = 0; i < S.length(); i++)
        {
            if(jewels.find(S[i]) != jewels.end()){
                count = count + 1;
            }
        }
        cout << count << endl;

    }
}