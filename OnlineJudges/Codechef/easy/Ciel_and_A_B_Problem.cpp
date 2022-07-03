#include<bits/stdc++.h>
using namespace std;

int main(){
// Exactly 1 digit difference
// No negative ans
    int a;
    int b;
    int ans;
    cin >> a;
    cin >> b;
    ans = a - b;
     if(ans < 0){
        ans = ans * -1;
    }
    // check the units place to ensure only 1 digit is modified
    if(ans%10< 9){
        ans = ans +1;
    }else{
        ans = ans - 1;
    }   
    cout << ans;


}