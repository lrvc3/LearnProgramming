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

int binarySearch(int arr[], int n, int target){
	int low = 0;
	int high = n - 1;		
	while(low <=high){
		int mid = low + (high - low) / 2;

		if(arr[mid] == target){
			return mid;
		}else if(arr[mid] > target){
			high = mid - 1;
		}else{
			low = mid + 1;
		}
	}
	return -1;
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
    cout << binarySearch(arr, n, target);

    return 0;

}