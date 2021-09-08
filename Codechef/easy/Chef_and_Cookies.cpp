#include<bits/stdc++.h>

using namespace std;

int main(){

    long long int t;
    cin >> t;
    while(t--){
        long long int N, B;
        unsigned long long int ans;
        cin >> N >> B;
        ans = N/B;

        /*
        consider the example, N = 11 and B = 3
        11/3 = 3
        this means we can have 3 extra cookies from the crumbs
        11 - 3 = 8. So we need to bake 8 cookies.

        Now suppose, N = 9 and b = 3
        9/3 = 3 
        we get 3 cookies.
        9 - 3 = 6
        consider:
        1 cookie    
        2 cookie    
                    
        3 cookie    
        4 cookie    
                    
        5 cookie    
        6 cookie    
                            



        */
        // if(ans<N){
        //     cout << (ans+1) << endl;
        // }else{
        //     cout << (N-ans+1) << endl;
        // }
        if(N % B == 0){
            cout << (N-ans+1) << endl;
        }
        else{
            cout << (N-ans) << endl;
        }
    }
    return 0;
}