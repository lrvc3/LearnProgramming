#include <bits/stdc++.h>

using namespace std;

// bool isDivisibleBy5(long int num)
// {
//     long int lastDigit = num % 10;
//     if (lastDigit == 0 || lastDigit == 5)
//     {
//         return true;
//     }
//     else
//     {
//         return false;
//     }
// }

// bool isDivisibleBy3(long int num)
// {
//     long int sum = 0;
//     while (num > 0)
//     {
//         long int rem = num % 10;
//         num = num / 10;
//         sum = sum + rem;
//     }
//     if (sum % 3 == 0)
//         return true;
//     else
//         return false;
// }

// int main()
// {

//     int t;
//     cin >> t;

//     while (t--)
//     {
//         long int count = 0;
//         long int num;
//         cin >> num;

//         for (int i = 1; i < num; i++)
//         {
//             bool isBy3 = isDivisibleBy3(i);
//             if (isBy3)
//             {
//                 count = count + i;
//             }
//             else
//             {
//                 bool isBy5 = isDivisibleBy5(i);
//                 if(isBy5){
//                     count = count + i;
//                 }
//             }
//         }
//         cout << count << endl;
//     }

//     return 0;
// }


// O(1) Solution : say N= 100 so, max multiple of 3 here below N is 99 
// i.e. 3*33 so, sum of all multiples of 3 has a pattern 3(1+2+3+....+33) use this
// N=10
// 1 2 3 4 5 6 7 8 9
int main()
{
    long N, num, three, five, fifteen = 0;
    cin >> N;

    for (int i = 0; i < N; i++)
    {
        cin >> num;
        //int sum=0;
        three = (num - 1) / 3;
        five = (num - 1) / 5;
        fifteen = (num - 1) / 15;

        cout << 3 * (three * (three + 1) / 2) + 5 * (five * (five + 1) / 2) - 15 * (fifteen * (fifteen + 1) / 2) << endl;
    }
    return 0;
}