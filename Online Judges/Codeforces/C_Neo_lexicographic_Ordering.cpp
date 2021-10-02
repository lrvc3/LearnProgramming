#include<bits/stdc++.h>
using namespace std;

int main(){
    string lexi;
    cin >> lexi;
    map<char, int> order;
    int count = 0;
    for(auto it : lexi){
        order[it] = count;
        count++;
    }

    int n;
    cin >> n;

    vector<pair<string, int>> inString;
    while(n--){
        string val = "";
        cin >> val;
        int l = val.size();
        inString.push_back(make_pair(val, l));
    }

    map<string, int> outputOrder;
    for (int i = 0; i < n; i++)
    {
        
    }
    

    return 0;
}