#include<bits/stdc++.h>
using namespace std;

int main(){
    string s1, s2, s3;
    cin >> s1 >> s2 >> s3;
    string output = "";
    string t;
    cin >> t;
    for(auto it: t){
        if(it == '1'){
            output += s1;
        }
        if(it == '2'){
            output += s2;
        }
        if(it == '3'){
            output += s3;
        }
    }
    cout << output << endl;
    
    return 0;
}