#include <bits/stdc++.h>
using namespace std;



/*

	Middle element:
	I/P -> 1 2 3 4 5	O/P -> 1 2 4 5
	I/P -> 1 2 3 4 5 6	O/P -> 1 2 3 5 6

	Middle Element:
	(size/2) + 1
*/

stack<int> deleteMiddleElement(stack<int> &nums, int targetIndex) {

	if (targetIndex == 1)
	{
		nums.pop();
		return nums;
	}

	int val = nums.top();
	nums.pop();
	nums = deleteMiddleElement(nums, targetIndex-1);
	nums.push(val);
	return nums;
}



int main() {

#ifndef ONLINE_JUDGE
	// for getting input from input.txt
	freopen("input.txt", "r", stdin);
	// for writing output to output.txt
	freopen("output.txt", "w", stdout);
#endif
	int size;
	cin >> size;
	stack<int> nums;
	for (int i = 0; i < size; i++)
	{
		int x; cin >> x;
		nums.push(x);
	}
	int target = (size / 2) + 1;
	nums = deleteMiddleElement(nums, target);
	while (!nums.empty()) {

		int val = nums.top();
		cout << val << " ";
		nums.pop();
	}

}