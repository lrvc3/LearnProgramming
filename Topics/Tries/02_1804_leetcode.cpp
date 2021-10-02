#include<bits/stdc++.h>
using namespace std;

// considering lowercase a-z
struct Node{

	Node* arr[26];
	int cntWordsEnd = 0;
	int cntPrefix = 0;

	bool contains(char ch){
		return (arr.[ch-'a'] != NULL);
	}

	void put(Node* newNode, char ch){
		arr[ch-'a'] = newNode;
	}

	Node* getNext(char ch){
		return arr[ch - 'a'];
	}

	void increaseCntWordsEndsWith(){
		cntWordsEnd++;
	}

	void increaseCntPrefixes(){
		cntPrefix++;
	}

	void decreaseCntWordsEndsWith(){
		cntWordsEnd--;
	}

	void decreaseCntPrefixes(){
		cntPrefix--;
	}

	int getCntWordsEndWith(){
		return cntWordsEnd;
	}

	int getCntPrefixes(){
		return cntPrefix;
	}
}

// Creating a root
Node* root = new Node();

void insert(string word){

	Node* temp = root;
	for (int i = 0; i < word.size(); ++i)
	{
		// Not present
		if(!temp->contains(word[i-'a'])){
			Node* newNode = new Node();
			// we insert 
			temp->put(newNode, word[i]);
		}
		// we add the prefixes as well
		temp->increaseCntPrefixes();
		// now we need to move to that newly created node
		temp->getNext(word[i]);
	}
	// At the end we will set the value saying word is over
	temp->increaseCntWordsEndsWith();
}


int countWordsEqualTo(string word){
	Node* temp = root;
	for(int i = 0; i < word.size(); i++){
		// We have it
		if(temp->contains(word[i])){
			// we move to next
			temp->getNext(word[i]);
		}else{
			return 0;
		}	
	}
	return temp->getCntWordsEndWith();
}


int countWordsStartingWith(string prefix){
	Node* temp = root;
	for (int i = 0; i < prefix.size(); ++i){}
	{
		if(!temp->contains(prefix[i])){
			return 0;
		}else{
			temp->getNext(prefix[i]);
		}
	}
	return temp->getCntPrefixes();
}

// erase given word
void erarse(string word){
	Node* temp = root;

	// First we need to search whether that word exists
	if(countWordsEqualTo(word) == 0) return;

	// Now if it exists
	for (int i = 0; i < word.size(); ++i)
	{
		temp->decreaseCntPrefixes();
		temp->getNext();
	}
	temp->decreaseCntWordsEndsWith();
}

int main(){


}