#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;
    cin >> t;
    while(t--){
        int noOfWords;
        cin >> noOfWords;
        map<string, int> hm;
        int totalCount = 0;
        while (noOfWords--)
        {
            string s;
            cin >> s;
            hm[s]++;
            long int count = 0;
            // d, f  - left hand
            // j, k - right hand
            // 0.2 if with different hand
            // 0.4 if written with same hand
            // word already appeared, then half second
            bool left = false;
            bool right = false;
            map<string, int> hmCount;
            if(hm.find(s) != hm.end() && hm.count(s) > 1){
                for(auto it: s){
                    if(it == 'f'){
                        if(!left){
                            count = count + 0.2;
                        }else{
                            count += 0.4;
                        }
                        left = true;
                        right = false;
                    }
                    if(it == 'd'){
                        if(!left){
                            count = count + 0.2;
                        }else{
                            count += 0.4;
                        }
                        left = true;
                        right = false;
                    }
                    if(it == 'j'){
                        if(!right){
                            count = count + 0.2;
                        }else{
                            count += 0.4;
                        }
                        left = false;
                        right = true;                    
                    }
                    if(it == 'k'){
                        if(!right){
                            count = count + 0.2;
                        }else{
                            count += 0.4;
                        }
                        left = false;
                        right = true;                    
                    }                
                }
                hmCount[s] = count;
                totalCount += count;
            }else{
                int val = hmCount[s]/2;
                totalCount += val;
            }
            
        }
        cout << totalCount << endl;   

    }
    return 0;
}