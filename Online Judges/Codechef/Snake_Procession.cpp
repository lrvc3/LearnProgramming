/*
    Problem: https://www.codechef.com/SDPCB21/problems/SNAKPROC/
    Platform: Codechef
    Contest: SDPCB21
*/
#include<bits/stdc++.h>
using namespace std;

int main(){

    int r;
    cin >> r;
    while(r--){
        int l;
        string report;
        cin >> l;
        cin >> report;
        stack<char> stck; 
        int headNo = 0;
        int tailNo = 0;
        bool flag = true;
        if(report[0] == 'T'){
            cout << "Invalid" << endl;
        }else{
            for(auto s: report){
                if(s == '.'){
                    continue;
                }
                if(s == 'H'){
                    if(stck.empty()){
                        stck.push(s);
                    }else{
                        if(stck.top() == 'H'){
                            flag = false;
                            break;
                        }else{
                            stck.push(s);
                        }
                    }
                    
                }
                if(s == 'T'){
                    if(stck.empty()){
                        flag = false;
                        break;
                    }else{
                        if(stck.top() == 'T'){
                            flag = false;
                            break;
                        }else{
                            stck.pop();
                        }
                    }

                    
                }
            }

            if(flag && stck.empty()){
                cout << "Valid" << endl;
            }else{
                cout << "Invalid" << endl;
            }

        }
    }
    return 0;
}