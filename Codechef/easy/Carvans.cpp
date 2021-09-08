#include <bits/stdc++.h>

using namespace std;

int main()
{

    int t;
    cin >> t;
    while (t--)
    {

        long int n;
        cin >> n;
        long int count = 0;
        long int a[n];
        long int value;
        for (int i = 0; i < n; i++)
        {
            cin >> value;
            a[i] = value;
        }
        //  Below is not required because in the loop we are already checking <= with value
        //  Therefore it will consider even if there is single value present

        //  Secondly, we need to compare the values with the one that is in the race
        // For example: consider 4 5 1 
        // 4 is eligible,       4 in race
        // 5 is less than 4     
        // 1 is less than 4     1 in race
        // output -2


        // if (n == 1)
        // {
        //     cout << 1 << endl;
        // }
        // else
        // {
            value = a[0];
            for (int i = 0; i < n; i++)
            {
                if (a[i] <= value)
                {   
                    value = a[i];
                    count = count + 1;
                }
            }
            cout << count << endl;
        // }
    }
}