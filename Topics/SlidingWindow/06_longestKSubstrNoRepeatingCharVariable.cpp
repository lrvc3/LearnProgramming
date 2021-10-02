#include<bits/stdc++.h>

using namespace std;

int lengthOfLongestSubstring(string s) {
        map<char, int> mp;
        mp.clear();
        
        int max = 0;
        int i = 0, j = 0;
        
        while(j < s.length()){
            
            mp[s[j]]++;
            
            
            if(mp.size() > (j-i+1)){
                j++;
                continue;
            }
           else if(mp.size() == (j-i+1)){
                
                if(max < (j-i+1)){
                    max = j - i + 1;
                }
                j++;
            }
            
           else if(mp.size() < (j-i+1)){
                while(mp.size() < (j-i+1)){
                    
                    mp[s[i]]--;
                    
                    if(mp[s[i]] == 0){
                        mp.erase(s[i]);
                    }
                    i++;
                }
                j++;
            }
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
	int ans = lengthOfLongestSubstring(s);
	cout << ans;
	
}

// Test Case:
// "pwwkew"
// output: 3

// bbbb
// 1