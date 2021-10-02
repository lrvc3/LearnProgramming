/*
    Problem Link: https://www.codechef.com/problems/POTATOES
    Platform: Codechef
*/

#include<bits/stdc++.h>

using namespace std;

bool isPrime(int no){
    for(int i = 2; i<= sqrt(no); i++){
        if(no%i == 0){
            return false;
        }
    }
    return true;
}

int findNextPrimeNum(int n){
    if(isPrime(n+1)){
        return n+1;
    }
    return findNextPrimeNum(n+1);
}

int main(){
    int t;
    cin >> t;
    while(t--){
        int x, y;
        cin >> x >> y;
        int num = x + y;
        int ans;
        if(num > 0 ){
            ans = findNextPrimeNum(num);
        }
        if(num == 0){
            cout << 1 << endl;
        }
        cout << (ans - num) << endl;
    }
    return 0;
}