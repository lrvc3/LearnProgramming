/*
    Contest Link: https://www.codechef.com/SEPT21C
    Problem Link: https://www.codechef.com/SEPT21C/problems/SHUFFLIN
    Platform: Codechef

*/
#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        long int n, sum = 0, evenNo = 0, oddNo = 0, evenIndex = 0, oddIndex = 0;
        cin >> n;
        evenIndex = n/2;
        oddIndex = n - (n/2);

        for (long int i = 0; i < n; i++)
        {
            int val;
            cin >> val;
            if(val % 2 == 0){
                evenNo++;
            }else{
                oddNo++;
            }            
        }
        sum = min(evenIndex, oddNo) + min(oddIndex, evenNo);
        cout << sum << endl;
    }

    return 0;
}