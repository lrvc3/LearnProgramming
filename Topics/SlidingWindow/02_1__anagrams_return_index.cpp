#include <bits/stdc++.h>
using namespace std;

vector<int> findAnagrams(string s, string p) {
        

        // The window size is length of pattern string
        // why? because anagrams length will also be same
        int k = p.size();

        
        vector<int> indexAnagram;
        int counter = 0;

        // Start, end , ans
        int i = 0, j = 0, ans = 0;
        
        // Creating a map of pattern string
        map<char, int> mp;
        // we store the character and its frequency
        for(auto it: p){
            mp[it]++;
        }
        // Initialize a counter variable [distinct elements]
        counter = mp.size();
        // cout << counter << endl;


        while(j < s.size()){
            
            if(mp.find(s[j]) != mp.end()){
                mp[s[j]]--;
                
                if(mp[s[j]] == 0){
                    counter--;
                }
            }
            
            if(j-i+1 < k){
                j++;
                continue;
            } else if (j-i+1 == k){
                
                if(counter == 0){
                    ans++;
                    indexAnagram.push_back(i);

                }
                
                if(mp.find(s[i]) != mp.end()){
                    mp[s[i]]++;
                    if(mp[s[i]] == 1){
                        counter++;
                    }
                }
                i++;
            }
            j++;
        }
        // cout << ans << endl;
        return indexAnagram;
}

int main()
{


#ifndef ONLINE_JUDGE

    // freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

#endif

    string s = "cbaebabacd";
    string p = "abc";
    vector<int> a = findAnagrams(s, p);
    for(auto it: a){
        cout << it << " ";
    }
    cout << endl;
    return 0;
}