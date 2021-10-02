#include <bits/stdc++.h>
using namespace std;

// TLE
// W1 = 0 W3 = 1000 W4=1000
// First main is my solution
// Firstly whatever the problem statement suggests isnt necessarily the way to go ahead and solve, first check what should be the outcome.
// Accordingly then try to formulate the solution.

// Looking at my solution, i notice that i focused on the value of the salary rather than focusing on the number of steps to achieve the goal
// As a result, computation of the salary is not required. 

// int main()
// {

//     int t;
//     cin >> t;

//     while (t--)
//     {
// long int n;
// cin >> n;
// vector<long int> a;
// for (int i = 0; i < n; i++)
// {
//     int value = 0;
//     cin >> value;
//     a.push_back(value);
// }
//         if (count(a.begin(), a.end(), a.at(0)) == n)
//             cout << 0 << endl;
//         else
//         {
//             long int moves = 0;
//             while (count(a.begin(), a.end(), a.at(0)) != n)
//             {
//                 long int indexOfCurrentMax = max_element(a.begin(), a.end()) - a.begin();
//                 for (long int i = 0; i < n; i++)
//                 {
//                     if (i != indexOfCurrentMax)
//                     {
//                         a[i] = a.at(i) + 1;
//                     }
//                 }
//                 moves += 1;
//             }

//             cout << moves << endl;
//         }
//     }
//     return 0;
// }

// int maxElementIndex = std::max_element(v.begin(),v.end()) - v.begin();
// int maxElement = *std::max_element(v.begin(), v.end());

// int minElementIndex = std::min_element(v.begin(),v.end()) - v.begin();
// int minElement = *std::min_element(v.begin(), v.end());

// For those who still cannot understand the problem. Here final salaries of employees are not important. 
// We are only concerned with number of steps.

// What is given in question?
// Increase N-1 Workers salaries. And keep 1 worker’s salary as it is.

// Instead of given statement, what can we think of?
// Here salaries are relative to each other. So we can also think the question in different. What if we decrease one worker’s salary by 1? It will be alright.

// Let us take some examples:

// Method 1
// (As per given in question) :
// Input:
// 3
// 1 3 6
// step1 : 2 4 6
// step2 : 3 5 6
// step3 : 4 6 6
// step4 : 5 7 6
// step5 : 6 7 7
// step6 : 7 7 8
// step7 : 8 8 8

// So answer is 7 steps.

// Method 2
// (Considering relative salaries and decreasing 1 worker’s salary each time whose salary is greater than minimum salary present in all workers)

// Input:
// 3
// 1 3 6 (minimum is 1)
// step1 : 1 2 6
// step2 : 1 1 6
// step3 : 1 1 5
// step4 : 1 1 4
// step5 : 1 1 3
// step6 : 1 1 2
// step7 : 1 1 1
#include <bits/stdc++.h>
#define ll long long
using namespace std;

int main()
{
    int t, n, i, flag, mi, ans;
    cin >> t;
    while (t--)
    {
        cin >> n;
        int w[n];
        for (i = 0; i < n; i++)
        {
            cin >> w[i];
            if (i == 0)
            {
                mi = w[i];
            }
            else if (w[i] < mi)
            {
                mi = w[i];
            }
        }
        ans = 0;
        for (i = 0; i < n; i++)
        {
            if (w[i] > mi)
            {
                ans += w[i] - mi;
            }
        }
        cout << ans << "\n";
    }

    return 0;
}