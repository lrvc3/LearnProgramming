#include <bits/stdc++.h>
using namespace std;

int main() {

    int t;
    cin >> t;
    while(t--) {
        string g1 = "101";
        string g2 = "010";

        string feedback;
        cin >> feedback;
        if(feedback.find(g1) != string::npos || feedback.find(g2) != string::npos ){
            cout << "Good" << endl;
        }else{
            cout << "Bad" << endl;
        }


    }

}

