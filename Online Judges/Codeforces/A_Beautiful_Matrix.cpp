#include<bits/stdc++.h>
using namespace std;

int main(){
    int arr[5][5];

    int onePosI = 0;
    int onePosJ = 0;
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            int val;
            cin >> val;
            if(val == 1){
                onePosI = i;
                onePosJ = j;
            }

            arr[i][j] = val;
        }
        
    }
    int val1 = abs(2 - onePosI);
    int valJ = abs(2 - onePosJ);
    cout << val1+valJ << endl;
    

}