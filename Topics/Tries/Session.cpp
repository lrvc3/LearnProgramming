// https://www.youtube.com/watch?v=thsleiL6zxg&list=PLN4aKSfpk8TRA7KPBYdmqteT8bILQK113&ab_channel=CodeBeyond




#include<bits/stdc++.h>
using namespace std;
#define int long long
#define setbits(n) __builtin_popcountll(n);



struct Node {
	Node* arr[26]; 
	bool flag = false; 

	bool contains(char c) {
		return (arr[c - 'a'] != NULL); 
	}

	void put(char c, Node* newNode) {
		arr[c - 'a'] = newNode; 
	}

	Node* getNext(char ch) {
		return arr[ch - 'a']; 
	}

	void setFlag() {
		flag = true; 
	}

	bool isFlagSet() {
		return flag; 
	}
};

Node* root = new Node();  

void insert(string word) {
	Node* temp = root; 
	for(int i = 0; i < word.size(); i++) {
		// there might be a previous instance of s[i]
		// previously there was word, now i am inserting worse
		if(!temp->contains(temp, word[i])) {
			Node* newNode = new Node(); 
			temp->put(word[i], newNode); 
		}
		temp = temp->getNext(word[i]); 
	}
	temp->setFlag(); 
}

bool search(string word) {
	Node* temp = root; 
	for(int i = 0; i< word.size(); i++) {
		if(temp->contains(word[i])) {
			temp = temp->getNext(); 
		}
		else {
			return false; 
		}
	}
	return temp->isFlagSet(); 
}

bool startsWith(string word) {
	Node* temp = root; 
	for(int i = 0; i < word.size(); i++) {
		if(temp->contains(word[i])) {
			temp = temp->getNext(); 
		}
		else {
			return false; 
		}
	}
	return true; 
}

// TRIES-II 
struct Node {
	Node* arr[26]; 
	int cntWordsEnd = 0;
	int cntPrefixs = 0; 

	bool contains(char c) {
		return (arr[c - 'a'] != NULL); 
	}

	void put(char c, Node* newNode) {
		arr[c - 'a'] = newNode; 
	}

	Node* getNext(char ch) {
		return arr[ch - 'a']; 
	}

	void increaseWordsEndsWith() {
		cntWordsEnd++; 
	}

	void increaseCntPrefixs() {
		cntPrefixs++; 
	}

	void decreaseWordsEndsWith() {
		cntWordsEnd--; 
	}

	void decreaseCntPrefixs() {
		cntPrefixs--; 
	}


	int getCountWordsEnd() {
		return cntWordsEnd; 
	}

	int getCntPrefixs() {
		return cntPrefixs; 
	}
};

Node* root = new Node();  

void insert(string word) {
	Node* temp = root; 
	for(int i = 0; i < word.size(); i++) {
		// there might be a previous instance of s[i]
		// previously there was word, now i am inserting worse
		if(!temp->contains(temp, word[i])) {
			Node* newNode = new Node(); 
			temp->put(word[i], newNode); 
		}
		temp->increaseCntPrefixs(); 
		temp = temp->getNext(word[i]); 
	}
	temp->increaseWordsEndsWith(); 
}

int countWordsEqualTo(string word) {
	Node* temp = root; 
	for(int i = 0; i< word.size(); i++) {
		if(temp->contains(word[i])) {
			temp = temp->getNext(); 
		}
		else {
			return false; 
		}
	}
	return temp->getCountWordsEnd(); 
}

int startsWith(string word) {
	Node* temp = root; 
	for(int i = 0; i < word.size(); i++) {
		if(temp->contains(word[i])) {
			temp = temp->getNext(); 
		}
		else {
			return 0; 
		}
	}
	return temp->getCntPrefixs(); 
}

void erase(string word) {
	Node* temp = root; 
	// If does not exists, no need to erase anything 
	if(search(word) == 0) return; 

	for(int i = 0;i<word.size(); i++) {
		temp->decreaseCntPrefixs(); 
		temp->getNext(); 
	}
	temp->decreaseWordsEndsWith(); 
}


struct Node {
	Node* arr[26]; 
	bool flag = false; 

	bool contains(char c) {
		return (arr[c - 'a'] != NULL); 
	}

	void put(char c, Node* newNode) {
		arr[c - 'a'] = newNode; 
	}

	Node* getNext(char ch) {
		return arr[ch - 'a']; 
	}

	void setFlag() {
		flag = true; 
	}

	bool isFlagSet() {
		return flag; 
	}
};
int insert(string word) {
	Node* temp = root; 
	int cnt = 0;
	for(int i = 0; i < word.size(); i++) {
		// there might be a previous instance of s[i]
		// previously there was word, now i am inserting worse
		if(!temp->contains(temp, word[i])) {
			Node* newNode = new Node(); 
			temp->put(word[i], newNode); 
		}
		if(temp->isFlagSet()) cnt++; 
		temp = temp->getNext(word[i]); 
	}
	temp->setFlag(); 
	return cnt; 
}

string longestWord(vector<string> &words) {
	sort(words.begin(), words.end()); 
	string res = ""; 

	for(int i = 0;i<words.size();i++) {
		int cnt = insert(words[i]); 
		if(cnt == words[i].size() - 1 && words[i].size() > res.size()) {
			res = words[i]; 
		}
	}
	return res; 
}

signed main() {
#ifndef ONLINE_JUDGE
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
#endif
	
}























