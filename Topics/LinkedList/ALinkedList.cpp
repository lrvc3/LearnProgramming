/*
    Problem Link:
    Topic:
    Solution Video Link:
    Time Complexity:
    Space Complexity:
    Difficulty:
*/

#include <bits/stdc++.h>
using namespace std;
#define ull unsigned long long int


class linkedList {

public:
	int data;
	linkedList *next;

	linkedList() {
		this->next = NULL;
	}
	linkedList(int data) {
		this->data = data;
		this->next = NULL;
	}

	// Add a node
	linkedList* addNode(linkedList *head, int data) {
		linkedList *newNode = new linkedList(data);
		if (head == NULL) {
			head = newNode;
		} else {
			linkedList *temp = head;
			while (temp->next != NULL) {
				temp = temp->next;
			}
			temp->next = newNode;
		}
		return head;
	}

	// print linkedlist
	void printLinkedList(linkedList *head) {
		linkedList* temp = head;
		if(temp == NULL){
			cout << "List is Empty" << endl;
		}else{
			while (temp != NULL) {
				cout << temp->data << "->";
				temp = temp->next;
			}			
			cout << "NULL"<< endl;
		}
	}

	// find the middle element
	int findMiddleElement(linkedList *head){

		if(head == NULL){
			cout << "List is empty" << endl;
			return -1;
		}else{
			auto sp = head, fp = head;

			while(fp!=NULL and fp->next !=NULL){
				sp = sp->next;
				fp = sp->next->next;
			}
			return sp->data;
		}

	}

	linkedList *deleteMiddleElement(linkedList *head){
		if(head == NULL){
			cout << "List is empty" << endl;
			return head;
		}else{
			auto sp = head, fp = head;
			auto prev = sp;
			while(fp!=NULL and fp->next !=NULL){
				prev = sp;
				sp = sp->next;
				fp = sp->next->next;
			}
			prev->next = sp->next;
			delete sp;

			return head;
		}
	}

	linkedList *deleteLinkedList(linkedList *head){
		if(head == NULL){
			cout << "List is empty" << endl;
		}else{
			auto prev = head;
			head = head->next;

			// To handle single element
			if(head == NULL){
				delete prev;
			}
			while(head != NULL){
				delete prev;
				prev = head;
				head = head->next;
			}
		}
		return head;
	}

	// print the linkedlist in reverseOrder
	void printElementsInReverse(linkedList *head){

		if(head == NULL){
			return;
		}

		printElementsInReverse(head->next);
		cout << head->data << " ";
	}

	auto reverseElements(linkedList *head){

		linkedList *prev = NULL, *curr = head;

		linkedList *next = NULL;
		while(curr != NULL){
			next = curr->next;
			curr->next = prev;

			prev = curr;
			curr = next;
		}
		return prev;
	}

	// print the linkedlist in reverseOrder
	bool checkPalindrome(auto &left, auto right){

		if(right == NULL){
			return true;
		}

		bool f = checkPalindrome(left, right->next);
		if(f == false){
			return false;
		}
		bool second = (right->data == left->data);
		left = left->next;
		return second;
	}

};


int main() {
#ifndef ONLINE_JUDGE
	// for getting input from input.txt
	freopen("input.txt", "r", stdin);
	// for writing output to output.txt
	freopen("output.txt", "w", stdout);
#endif
	linkedList *head = NULL;
	head = head->addNode(head, 1);
	head = head->addNode(head, 3);
	head = head->addNode(head, 5);
	head = head->addNode(head, 7);
	head = head->addNode(head, 9);
	head->printLinkedList(head);

	cout << head->findMiddleElement(head) << endl;

	head = head->deleteMiddleElement(head);
	head->printLinkedList(head);

	head = head->deleteLinkedList(head);
	head->printLinkedList(head);

	head = head->addNode(head, 11);
	head = head->addNode(head, 33);
	head = head->addNode(head, 55);
	head = head->addNode(head, 77);
	head = head->addNode(head, 99);
	head->printLinkedList(head);
	head->printElementsInReverse(head);
	cout << endl;

	head = head->reverseElements(head);
	head->printLinkedList(head);
	head = head->deleteLinkedList(head);

	head = head->addNode(head, 11);
	head = head->addNode(head, 33);
	head = head->addNode(head, 55);
	head = head->addNode(head, 33);
	head = head->addNode(head, 11);

	head->printLinkedList(head);
	if(head->checkPalindrome(head, head)){
		cout << "Is a palindrome" << endl;
	}else{
		cout << "Is not a palindrome" << endl;
	}


	return 0;

}