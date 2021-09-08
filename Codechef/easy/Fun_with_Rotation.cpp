#include <bits/stdc++.h>
using namespace std;

// void leftRotation(long int *a, long int no, long int s){

//     long int temp[s];
//     for (int i = 0; i < no; i++)
//     {
//         temp[i] = a[i];
//     }

//     long int x = 0;
//     for (int i = no; i < s; i++)
//     {
//         a[x] = a[i];
//         x++;
//     }

//     x = 0;
//     for (int i = s-no; i < s; i++)
//     {
//         a[i] = temp[x];
//         x++;
//     }
// }

// void rightRotation(int *a, int k, int n)
// {
//     // construct an auxiliary array of size `k` and
//     // fill it with the last `k` elements of the input array
//     int aux[k];
//     for (int i = 0; i < k; i++) {
//         aux[i] = a[n-k+i];
//     }

//     // shift the first `n-k` elements of the input array at the end
//     for (int i = n-k-1; i >= 0; i--) {
//         a[i+k] = a[i];
//     }

//     // put the elements of the auxiliary array at their
//     // correct positions in the input array
//     for (int i = 0; i < k; i++) {
//         a[i] = aux[i];
//     }
// }

// The main problem here was to get the element after rotation in a certain direction.
// And not to rotate the array actually. So the challenge here is to compute the index of the 
// first element after k number of rotation in either direction

int main()
{

    int n, m, d;
    cin >> n >> m;
    vector<long int> v;
    for (int i = 0; i < n; i++)
    {
        long int val;
        cin >> val;
        v.push_back(val);
    }
    int res = 0, ans = 0;
    char c;
    while (m--)
    {
        cin >> c >> d;
        if (c == 'C')
        {
            res += n - d;
        }
        else if (c == 'A')
        {
            res += d;
        }
        else
        {
            d--;
            res = (res + n) % n;
            cout << v[(d - res + n) % n] << endl;
        }
    }

}
        // cin >> k >> d;
        // if (k == 'C')
        // {
        //     rotate(a.begin(), a.begin() + d, a.end());
        //     // leftRotation(a, d, N);
        // }
        // else if (k == 'A')
        // {
        //     rotate(a.begin(), a.begin() + a.size() - d, a.end());
        //     // rightRotation(a, d, N);
        // }
        // else
        // {
        //     if (d > 0)
        //         cout << a[d - 1] << endl;
        //     // auto val = find(a.begin(), a.end(), d-1);
        //     // if(val != a.end()){
        //     //     cout << a[val];
        //     // }else{
        //     //     cout << -1;
        //     // }
        // }