#include<bits/stdc++.h>

using namespace std;

int longestKSubstr(string s, int k) {
        map<char, int> mp;
        mp.clear();
        
        int max = 0;
        
        int i = 0, j = 0;
        
        while(j < s.length()){
            
            mp[s[j]]++;
            
            if(mp.size() < k){
                j++;
                continue;
            }
            if(mp.size() == k){
                
                if(max < (j-i+1)){
                    max = j - i + 1;
                }
                j++;
            }
            
            if(mp.size() > k){
                while(mp.size() > k){
                    
                    mp[s[i]]--;
                    
                    if(mp[s[i]] == 0){
                        mp.erase(s[i]);
                    }
                    i++;
                }
                j++;
            }
        }
        
        if(max <= 0){
            return -1;
        }
        
        return max;
  }

int main(){

#ifndef ONLINE_JUDGE

	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);

#endif

	string s;
	cin >> s;

	int k;
	cin >> k;

	int ans = longestKSubstr(s, k);
	cout << ans;
	
}

// Test Case:
// aabacbebebe
// 3
// output: 7

// "aaaa", K = 2
// -1
