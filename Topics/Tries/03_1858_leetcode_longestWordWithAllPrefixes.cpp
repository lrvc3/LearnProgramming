#include<bits/stdc++.h>
using namespace std;

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

// Creating a root
Node* root = new Node();


void insertModified(string word){

	Node* temp = root;
	int cnt = 0;
	for (int i = 0; i < word.size(); ++i)
	{
		// Not present
		if(!temp->contains(word[i-'a'])){
			Node* newNode = new Node();
			// we insert 
			temp->put(newNode, word[i]);
		}
		if(temp->isFlagSet()) cnt++;
		// now we need to move to that newly created node
		temp->getNext(word[i]);
	}
	// At the end we will set the value saying word is over
	temp->increaseCntWordsEndsWith();
}


// longest word with all prefixes
void longestWord(vector<string> &words){
	sort(words.begin(), words.end());
	string res = "";
	int maxF = 0;
	for (int i = 0; i < words.size(); ++i)
	{
		int cnt = insertModified(words[i]);
		if(cnt == words[i].size() - 1 && words[i].size() > res.size()){
			res = words[i];
		}
	}

}

int main(){


}