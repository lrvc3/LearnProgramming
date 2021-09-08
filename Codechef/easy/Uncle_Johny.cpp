#include<bits/stdc++.h>
using namespace std;

int binary_search(int a[], int low, int n, int x){

    int start = low;
    int end = n-1;

    if( start == end){
        return 1;
    }

    while(start < end){
        int mid = (start) + (end+start)/2;
        if(a[mid] == x)
            return mid+1;
        else if(a[mid] < x){
            start = mid + 1;
        }else{
            end = mid - 1;            
        }
    }
    
    return -1;
}

int main(){

    int t;
    cin >> t;

    for (int i = 0; i < t; i++)
    {
        int n;
        cin >> n;
        int a[n];
        for (int i = 0; i < n; i++)
        {   
            int val;
            cin >> val;
            a[i] = val;
        }
        int k;
        cin >> k;
        int song = a[k-1];
        sort(a, a+n);

        for (int i = 0; i < n; i++)
        {
            if(a[i] == song)
                cout << i+1 << endl;
        }
        

            // cout << binary_search(a, 0, n, song) << endl;   
    }
    return 0;
}