/*
    Problem Link: 
    Topic:
    Solution Video Link:
    Time Complexity:
    Space Complexity:  
    Difficulty: 
*/

#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int

int binarySearchFirstOccurence(int arr[], int n, int target) {
    int low = 0;
    int high = n - 1;
    int ans = -1;
    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            ans = mid;
            high = mid - 1;
        } else if (arr[mid] > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ans;
}



int binarySearchLastOccurence(int arr[], int n, int target) {
    int low = 0;
    int high = n - 1;
    int ans = -1;
    while (low <= high) {
        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            ans = mid;
            low = mid + 1;
        } else if (arr[mid] > target) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ans;
}

int main(){
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
    int first = binarySearchFirstOccurence(arr, n, target);
    int last = binarySearchLastOccurence(arr, n, target);
    int res = -1;
    if(first == -1 || last == -1){
        res = -1;
    }else if (first == last){
        res = first;
    }else{
        res = last - first + 1;
    }
    cout << res;


    return 0;

}