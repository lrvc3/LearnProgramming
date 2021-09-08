#include<bits/stdc++.h>

using namespace std;

int main(){

    long long int n1, n2, n3;
    cin >> n1>>n2>>n3;

    map<int, int> hm;
    for (int i = 0; i < n1; i++)
    {
        int val;
        cin >> val;
        if(hm.find(val) != hm.end()){
            
            hm.insert(make_pair(val, ))
            hm[val] = hm.at(val) + 1;
        }else{
            hm[val] = 1;
        }
    }
    


    return 0;
}