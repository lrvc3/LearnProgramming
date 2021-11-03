/*
    Problem Link: 
    Topic:
    Solution Video Link:
    Time Complexity:
    Space Complexity:  
    Difficulty: 
*/

#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int

long long int gcd(long long int a, long long int b){
    if (a == 0)
        return b;
    return gcd(b % a, a);
}

// method to return LCM of two numbers
long long int lcm(long long int a, long long int b){
    return (a / gcd(a, b)) * b;
}

int main()
{

    ull t;
    cin >> t;
    while (t--)
    {
        long long int c, d;
        cin >> c >> d;

        
        cout << 2*c << " " << (c*d * (c * d - 1)) << endl;
    }

    return 0;
}