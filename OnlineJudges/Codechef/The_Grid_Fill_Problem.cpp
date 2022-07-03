#include<bits/stdc++.h>

using namespace std;

int main(){
    int t;
    cin >> t;

    while(t--){
        int n;
        cin >> n;

        if(n == 2){
            for (int i = 0; i < 2; i++)
            {
                for (int j = 0; j < 2; j++)
                {
                    cout << "-1" << " ";
                }
                cout << endl;
            }   
        }else{
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if( i == j){
                        cout << "-1" << " ";
                    }else{
                        cout << "1" << " ";
                    }
                }
                cout << endl;
                
            }
            

        }
    }
    return 0;
}