/*
    Problem Link: https://codeforces.com/problemset/problem/228/A
    Platform: Codeforces
    List of Problems: https://codeforces.com/blog/entry/82143
    Type: A
*/

#include<bits/stdc++.h>

using namespace std;

int main(){
    int a, b, c, d;
    cin >> a >> b >> c >> d;
    long int sum = a + b + c + d;
    // long int arr[4] = {a, b, c, d};

    // int countA = count(arr, arr+4, a);
    // int countB = count(arr, arr+4, b);
    // int countC = count(arr, arr+4, c);
    // int countD = count(arr, arr+4, d);
    set<int> s;
    s.insert(a);
    s.insert(b);
    s.insert(c);
    s.insert(d);
    if(sum % a == 0){
        cout << 3 << endl;
    }
    cout << 4-s.size() << endl;



    return 0;
}