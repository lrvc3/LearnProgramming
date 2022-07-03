#include <bits/stdc++.h>

using namespace std;

int main()
{

    int t;
    cin >> t;
    while (t--)
    {
        int n, x;
        cin >> n >> x;
        map<int, int> hm;
        map<int, int> xorhm;

        for (int i = 0; i < n; i++)
        {
            int val = 0;
            cin >> val;
            hm[val]++;
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if ((hm.at(j) ^ x) == hm.at(i))
                {
                    xorhm[hm.at(i)]++;
                }
            }
        }

        for (auto const &x : xorhm)
        {
            std::cout << x.first // string (key)
                      << ':'
                      << x.second // string's value
                      << std::endl;
        }
    }
    return 0;
}