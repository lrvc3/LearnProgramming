#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int

int search(int* arr, int target, int n) {
    int low = 0, high = n - 1;

    while (low <= high) {
        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid;
            // Assuming the array is sorted in the left half
        } else if (arr[low] <= arr[mid]) {
            // now we need to confirm whether it lies in the sorted section or not
            if ( target >= arr[low] && target <= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } else {
            // Assuming the array is sorted in the right half
            if ( target >= arr[mid] && target <= arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

    }

    return -1;
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
    int target;
    cin >> target;
    cout << search(arr, target, n);

    return 0;

}