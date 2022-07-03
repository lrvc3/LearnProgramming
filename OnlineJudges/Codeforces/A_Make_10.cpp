#include<bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin >>n;
    int target = 10;
    while(n--){
        // 2 - 3, 3 - 4, 4 - 1
        long long a, b, c, a1 = 0, v1 = 0, count = 0;
        cin >> a >> b >> c;
        long long ans = 0;
        if( b == 0 && c == 0 && a >=5){
            ans = a/5;
        }else if( a == 0 && c == 0 && b >=0){
            ans = 0;
        }else if( a == 0 && b == 0 && c >=0){
            ans = 0;
        }else{
            v1 = min(a,b);
            if(v1 > 0 && v1 % 2 == 0){
                a1 = 2*v1 + 3*v1;
            }else if(v1 > 3){
                v1--;
                a1 = 2*v1 + 3*v1;
            }
            count = v1/10;
            a -= v1;
            b -= v1;
            if(b ==  2*c){
                count += c;
            }
        }
        cout >> count >> endl;
    }

    return 0;
}