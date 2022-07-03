#include <bits/stdc++.h>
using namespace std;

vector<long int> v;
map<long int, long int> hm;
long int returnLowerBound(long int value)
{
    long int ele = value;
    auto lb = lower_bound(hm.begin(), hm.end(), ele);
    long int valIndex = lb - hm.begin();
    // long int val = v.at(valIndex - 1);
    return valIndex;
}

int main()
{

    long int t;
    cin >> t;

    while (t--)
    {
        long int n, m;
        cin >> n >> m;
        long int remainingSum = -1;
        
        for (int i = 0; i < n; i++)
        {
            int value;
            cin >> value;
            if(hm.find(value) != hm.end()){
                hm[value] += 1;
            }else{
                hm[value] = 1;
            }
            
        }
        if(find(hm.begin(), hm.end(), m) != hm.end()){
            cout << "Yes" << endl;
        }
        // if (find(v.begin(), v.end(), m) != v.end())
        // {
        //     cout << "Yes" << endl;
        // }
        else
        {
            long int valIndex = returnLowerBound(m);
            long int val = v.at(valIndex - 1);
            remainingSum = m - val;
            if (valIndex != 1)
            {
                while (remainingSum > 0)
                {
                    if (find(v.begin(), v.end(), remainingSum) != v.end())
                    {
                        remainingSum = 0;
                    }
                    else
                    {
                        val = returnLowerBound(remainingSum);
                        remainingSum = remainingSum - val;
                    }
                }
            }
            else
            {
                break;
            }
        }
        if (remainingSum == 0)
        {
            cout << "Yes" << endl;
        }
        else
        {
            cout << "No" << endl;
        }

        v.clear();
    }

    return 0;
}
/*
Algo: 

demand (m) = 13
no of notes = 5
ex: | 1 | 5 | 5 | 10 | 10 |

Create a hashmap <int, count>

<1, 1>
<5, 2>
<10, 2>

Now find if 13 is present? if Yes -> great
Else

1. find lower_bound of 13
    in our case it would be 10

2. Get the value of x
    key * x = demand
    x = demand/key

    10 * x = 13
    x = 1

    now check whether 10 has a count of 1, if yes
    demand = demand - key * x

    Now do the same for lower_bound of demand and repeat
    demand = 3

    lowerbound of 3 is 1
    1 * x = 3
        x = 3

    check whether 1 has a count of 3
    in our case it doesnt have. so output no
    


*/