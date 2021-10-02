#include <bits/stdc++.h>
using namespace std;

stack<int> put(stack<int> &nums,int key){
	// top >= will sort the stack in ascending order
	// top <= will sort the stack in descending order
	if(nums.size()==0 || nums.top()>=key){
		nums.push(key);
		return nums;
	}
	int val = nums.top();
	nums.pop();
	nums=put(nums,key);
	nums.push(val);	
	return nums;
}

stack<int> sort(stack<int> &nums){
	if(nums.size()==1)
		return nums;
	int lastNum = nums.top();
	nums.pop();
	nums = sort(nums);
	return nums=put(nums,lastNum);
}

int main(){

#ifndef ONLINE_JUDGE
    // for getting input from input.txt
    freopen("input.txt", "r", stdin);
    // for writing output to output.txt
    freopen("output.txt", "w", stdout);
#endif
    int size;
	cin >> size;
	stack<int> nums;
	for(int i=0; i<size; i++)
	{
		int x; cin >> x;
		nums.push(x);
	}
	
	nums = sort(nums);
	while(!nums.empty()){

		int val = nums.top();
		cout << val << " ";
		nums.pop();
	}

}