#include <bits/stdc++.h>
using namespace std;

int main()
{

    int t;
    cin >> t;

    while (t--)
    {
        int x, y, a, b, k;
        cin >> x >> y >> a >> b >> k;
        long long petrol = x;
        long long diesel = y;
        for (int i = 0; i < k; i++)
        {
            petrol += a;
            diesel += b;
        }

        if (petrol == diesel)
        {
            cout << "SAME PRICE"<< endl;
        }
        else if (petrol > diesel)
        {
            cout << "DIESEL" << endl;
        }
        else
        {
            cout << "PETROL" << endl;
        }
    }
    return 0;
}