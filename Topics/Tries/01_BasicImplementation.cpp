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
		// now we need to move to that newly created node
		temp->getNext(word[i]);
	}
	// At the end we will set the value saying word is over
	temp->setFlag();
}


bool search(string word){
	Node* temp = root;
	for(int i = 0; i < word.size(); i++){
		// We have it
		if(temp->contains(word[i])){
			// we move to next
			temp->getNext(word[i]);
		}else{
			return false;
		}	
	}
	return temp->isFlagSet();
}


bool startsWith(string prefix){
	Node* temp = root;
	for (int i = 0; i < prefix.size(); ++i){}
	{
		if(!temp->contains(prefix[i])){
			return false;
		}else{
			temp->getNext(prefix[i]);
		}
	}
	return true;
}

int main(){


}