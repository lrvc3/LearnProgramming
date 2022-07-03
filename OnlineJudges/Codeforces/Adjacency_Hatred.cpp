#include<bits/stdc++.h>

using namespace std;
int main(){

    int t;
    cin >> t;
    while(t--){
        int n = 0;
        cin >> n;
        int oddNo = 0, evenNo = 0;
        long ans[n];
        vector<long> odd;
        vector<long> even;

        for (int i = 0; i < n; i++)
        {
            long val = 0;
            cin >> val;
            if(val%2 == 0){
                even.push_back(val);
            }else{
                odd.push_back(val);
            }
        }
        sort(odd.begin(), odd.end());
        sort(even.begin(), even.end());
        if(odd.size() == 0 || even.size() == 0){
            cout << "-1" << endl;
        }else if(odd.size() == even.size()){
           for (int i = 0; i < n; i++)
           {
               cout << odd.at(i) << " ";
               cout << even.at(i) << " ";
           }
            cout << endl;
        }else if(odd.size() > even.size()){
             for (int i = 0; i < even.size(); i++)
           {
               cout << even.at(i) << " ";
               cout << odd.at(i) << " ";
           }
        //    print remmainng elements of odd
            for(int i = even.size(); i < odd.size(); i ++){
               cout << odd.at(i) << " ";
            }
            cout << endl;
        }else if (odd.size() < even.size()){
            for (int i = 0; i < odd.size(); i++)
           {
               cout << odd.at(i) << " ";
               cout << even.at(i) << " ";
           }
           //    print remmainng elements of even
            for(int i = odd.size(); i < even.size(); i ++){
               cout << even.at(i) << " ";
            }
            cout << endl;
        }

    }
    return 0;
}