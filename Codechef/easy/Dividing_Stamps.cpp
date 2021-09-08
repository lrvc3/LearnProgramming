#include<bits/stdc++.h>

using namespace std;

int main(){

    long long int n, sum=0;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int val;
        cin >> val;
        sum +=val;
    }
    if((long long int)(n*(n+1))/2 == sum){
        cout << "YES" << endl;
    }else{
        cout << "NO" << endl;
    }
    

    return 0;
}