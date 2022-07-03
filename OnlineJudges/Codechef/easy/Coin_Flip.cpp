#include <bits/stdc++.h>
using namespace std;

int main()
{

    int t;
    cin >> t;
    while (t--)
    {
        int rounds, ansHead, ansTail;
        cin >> rounds;

        for (int i = 0; i < rounds; i++)
        {
            int I, N, Q;
            cin >> I >> N >> Q;

            if (I == Q)
                cout << (N / 2) << endl;
            else
                cout << N - (N / 2) << endl;

            // The below logic wont work because i did not consider the intial state of the coins
            // Initial state is important to compute the ans

            // if (N % 2 == 0)
            // {
            //     ansHead = N / 2;
            // }
            // else
            // {
            //     ansTail = N / 2;
            // }

            // if( N%2 == 0){
            //     cout <<  N / 2 << endl;
            // }else{
            //     if(I==Q){
            //         cout<< ansTail << endl;
            //     }else{
            //         cout << N - ansTail << endl;
            //     }
            // }
        }
    }
}