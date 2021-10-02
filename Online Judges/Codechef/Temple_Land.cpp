/*
    Problem Link: https://www.codechef.com/SDPCB21/problems/TEMPLELA
    Platform: Codechef
    Contest code: SDPCB21

*/

#include<bits/stdc++.h>

using namespace std;

int main(){

    int s;
    cin >> s;
    while(s--){
        int n;
        cin >> n;
        vector<int> vec(n, 0);
        for (int i = 0; i < n; i++)
        {
            int val = 0;
            cin >> val;
            vec[i] = val;
        }
        if(n%2 == 0){
            cout << "no" << endl;
        }else if(vec[0] != 1){ 
            cout << "no" << endl;
        }else{
            int midIndex = n/2;
            // 1 3 5 3 1
            bool left = true;
            for (int i = 0; i < midIndex; i++)
            {
                if(vec.at(i) != i+1){
                    left = false;
                    break;
                }
            }
            bool right = true;
            // 5 3 1
            for (int i = midIndex+1; i < n; i++)
            {
                if(vec.at(i) != (i-1)){
                    right = false;
                    break;
                }
            }
            
            if(left && right){
                cout << "yes" << endl;
            }else{
                cout << "no" << end;
            }
            
        }
        
    }
    return 0;
}