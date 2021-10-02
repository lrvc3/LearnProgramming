#include<bits/stdc++.h>

using namespace std;

bool isPrime(int no){
    for(int i = 2; i<= sqrt(no); i++){
        if(no%i == 0){
            return false;
        }
    }
    cout << no << endl;
    return true;
}

int findNextPrimeNum(int n){
    if(isPrime(n+1)){
        return n;
    }
    return findNextPrimeNum(n+1);
}

int main(){
    int x, y;
    cin >> x >> y;
    int num = x + y;
    int ans;
    if(num > 0 ){
        ans = findNextPrimeNum(num);
    }
    if(num == 0){
        return 1;
    }
    return (ans - num);
}