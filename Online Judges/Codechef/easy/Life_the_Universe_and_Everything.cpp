#include<bits/stdc++.h>

using namespace std;

int main(){
    int value = -1;
    vector<int> list;
    while(value != 42){
        cin >> value;
        if(value == 42){
            break;
        }else{
            list.push_back(value);
        }
    }

    for( int i = 0; i< list.size(); i++){
        cout << list[i] << "\n";
    }

}