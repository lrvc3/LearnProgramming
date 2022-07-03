#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;
    cin>>t;
    while (t--)
    {
        int x, y, k, n;
        cin>>x>>y>>k>>n;        
        bool bIsLucky = false;
        for (int i = 0; i < n; i++)
        {
            int c, p;
            cin >> p>>c;

            if(c <= k && ((p+y) >= x)){
                bIsLucky = true;
                cout << "LuckyChef" << endl;
                break;
            }
        }
        if(!bIsLucky){
            cout << "UnluckyChef"<< endl;
        }else{
            bIsLucky = false;
        }
        
    }
    return 0;
    
}