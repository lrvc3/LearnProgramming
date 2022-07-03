#include <bits/stdc++.h>

using namespace std;

int main()
{

    int t;
    cin >> t;
    while (t--)
    {
        int n, k;
        cin >> n >> k;
        vector<long long> vec;

        for (int i = 0; i < n; i++)
        {
            long long val = 0;
            cin >> val;
            vec.push_back(val);
        }
        sort(vec.begin(), vec.end(), greater<>());
        // binary_search(vec.begin(), vec.end(), kval);
        int target = vec.at(k - 1);
        int ans = 0;
        for (int i = 0; i < n; i++)
        {

            if (vec.at(i) >= target)
            {
                ans++;
            }else{
                break;
            }
        }
        cout << ans << endl;
    }
    return 0;
}