#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int


/*
        n = 7
    arr[] = 16 17 18 19 20 2 4

    ind - 0 1 2 3 4 5 6
    ele - 8 9 1 2 3 5 6
*/

int findMin(int nums[], int n) {


    int low = 0;
    int high = n - 1;
    while (low < high) {
        int mid = (low + high) / 2;
        /*
            arr[] = 1 1 1 0 0 1
    
        */

        // Since there are no duplicates we are sure we can eliminate
        if (nums[mid] > nums[high]) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }
    return nums[high];
}

int main() {
#ifndef ONLINE_JUDGE
    // for getting input from input.txt
    freopen("input.txt", "r", stdin);
    // for writing output to output.txt
    freopen("output.txt", "w", stdout);
#endif

    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; ++i)
    {
        cin >> arr[i];
    }
    cout << findMin(arr, n);

    return 0;

}