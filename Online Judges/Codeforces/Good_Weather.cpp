#include<bits/stdc++.h>
using namespace std;

int main(){
    int t = 0;
    cin >> t;
    while(t--){

        int s[7];
        int sunny = 0, rainy = 0;
        for(int i=0; i<7; i++){
            int val;
            cin >> val;
            if(val == 1){
                sunny+=1;
            }else{
                rainy +=1;                
            }
        }
        if(sunny > rainy){
            cout << "YES" << endl;
        }else{
            cout << "NO" << endl;

        }
        
    }
    return 0;
}