/*
    Problem Link:
    Topic:
    Solution Video Link:
    Time Complexity:
    Space Complexity:
*/

#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int


long long count = 0;
// avoid space at the starting of the string in "move disk....."
long long toh(int n, int s, int d, int h) {
    if (n == 1) {
        cout << "move disk " << n << " from rod " << s << " to rod " << d;
        cout << endl;
        return 1;
    }

    int left = toh(n - 1, s, h, d);
    cout << "move disk " << n << " from rod " << s << " to rod " << d;
    cout << endl;
    int right = toh(n - 1, h, d, s);
    return 1 + left + right;
}

int main() {
#ifndef ONLINE_JUDGE
    // for getting input from input.txt
    freopen("input.txt", "r", stdin);
    // for writing output to output.txt
    freopen("output.txt", "w", stdout);
#endif

    ull t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        long long ans = toh(n, 0, 0, 0);
        cout << ans << endl;
    }

    return 0;

}