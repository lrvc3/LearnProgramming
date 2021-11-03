/*
    Problem Link: https://leetcode.com/problems/number-of-distinct-substrings-in-a-string/ 
    Topic:
    Solution Video Link: https://www.youtube.com/watch?v=vAF8Wvs10Ts&ab_channel=CodeBeyond
    Time Complexity: insert - search = O(n)
    Space Complexity:  all distinct 
*/

#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int

// considering lowercase a-z
struct Node{

	Node* arr[26];
	bool flag;	

	bool contains(char ch){
		return (arr.[ch-'a'] != NULL);
	}

	void put(Node* newNode, char ch){
		arr[ch-'a'] = newNode;
	}

	Node* getNext(char ch){
		return arr[ch - 'a'];
	}

	void setFlag(){
		flag = true;
	}

	bool isFlagSet(){
		return flag;
	}
}

Node* root = new Node();
void distinctSubstrings(string s){
	int n = s.size();
	int cnt = 0;
	for (int i = 0; i < n; ++i)
	{
		Node* temp = root;
		for (int j = i; j < n; ++j)
		{
			if(!temp->contains(s[j])){
				Node* newNode = new Node();
				temp->put(newNode, s[j]);
				temp->getNext();
				cnt++;
			}
			temp = temp->getNext();
		}
	}
	return cnt;
}


int main(){
#ifndef ONLINE_JUDGE
    // for getting input from input.txt
    freopen("input.txt", "r", stdin);
    // for writing output to output.txt
    freopen("output.txt", "w", stdout);
#endif

    ull t;
    cin >> t;
    while(t--){


    }

    return 0;

}